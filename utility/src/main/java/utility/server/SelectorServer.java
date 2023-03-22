package utility.server;

import utility.utilityLog.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;


public class SelectorServer {

    private static final int SERVER_PORT = 8081;
    private ByteBuffer buffer = ByteBuffer.allocate(2048);
    private static final String BLACKLIST_STORAGE_FILE = "BlackList/BlackList.txt";
    Path path = Paths.get(BLACKLIST_STORAGE_FILE);

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private WatchService watchService;
    private WatchKey key;
    Set<String> blackList = new HashSet<>();

    public SelectorServer() {
        try {

            start();
        } catch (IOException | InterruptedException e) {
            LogFactory.warning(this.getClass().getName(), "Problems with server", e.getStackTrace());
        }
    }

    public void start() throws IOException, InterruptedException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(SERVER_PORT));
        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);


        System.out.println("Server started and listening at port = " + SERVER_PORT);

        while (true) {
            selector.select();

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey currentKey = keyIterator.next();
                keyIterator.remove();

                blackList = createBlackList();
                watchService = FileSystems.getDefault().newWatchService();
                key = path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

                if (!currentKey.isValid()) {
                    continue;
                }

                if (currentKey.isAcceptable()) {
                    acceptConnection(currentKey);
                } else if (currentKey.isReadable()) {
                    readMessage(currentKey);
                } else if (currentKey.isWritable()) {
                    write(currentKey);
                }
            }
        }
    }

    public void acceptConnection(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel clientChannel = serverSocketChannel.accept();

        if (clientIPInBlackList(clientChannel)) {
            clientChannel.close();

        } else {

            clientChannel.configureBlocking(false);


            clientChannel.register(selector, SelectionKey.OP_READ);
            System.out.println("New client connected: " + clientChannel.getRemoteAddress());
        }
    }

    public void readMessage(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();

        if (clientIPInBlackList(clientChannel)) {
            clientChannel.close();

        } else {

            buffer.clear();

            int bytesRead = clientChannel.read(buffer);


            if (bytesRead == -1) {
                key.cancel();
                System.out.println("Connection closed by client = " + clientChannel.getRemoteAddress());
                clientChannel.close();
                return;
            }

            String dataFromClient = new String(buffer.array(), 0, buffer.position());
            System.out.println("Gor from client = " + dataFromClient);
            System.out.println("Request received from = " + clientChannel.getRemoteAddress());
            key.interestOps(SelectionKey.OP_WRITE);
        }
    }


    public void write(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        if (clientIPInBlackList(socketChannel)) {
            socketChannel.close();
        } else {
            String response = "Hello from server!";
            System.out.println(response);
            buffer.clear();
            buffer.put(response.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            key.interestOps(SelectionKey.OP_READ);
        }
    }


    public Set<String> createBlackList() throws IOException {
        blackList = new HashSet<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                blackList.add(line);
            }

            return blackList;
        }
    }

    public Set<String> readBlackListFile() throws IOException {

        if (watchService.poll() != null) {
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    blackList.add(line);
                }
            }
            key.reset();
        }

        return blackList;
    }

    public boolean clientIPInBlackList(SocketChannel clientChannel) throws IOException {

        boolean status = false;
        String clientAddress = clientChannel.getRemoteAddress().toString().substring(1);
        System.out.println("clientAddress = " + clientAddress);
        int endIP = clientAddress.indexOf(":");
        String clientIp = clientAddress.substring(0, endIP);

        Optional<Set<String>> blackListOptional = Optional.ofNullable(readBlackListFile());

        if (blackListOptional.isPresent()) {
            if (readBlackListFile().contains(clientIp)) {
                System.out.println("IP in blacklist");
                status = true;
            }
        }
        return status;

    }
}
