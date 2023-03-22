package utility.server;

import utility.utilityLog.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientSocket {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 8081;

    public ClientSocket() {
        try {
            start();
        } catch (IOException e) {
            LogFactory.warning(this.getClass().getName(), "Problems with client socket IO files", e.getStackTrace());
        }
    }


    public void start() throws IOException {
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        byte[] data = "hello from client".getBytes();


        System.out.println("Starting sending data to server.... ");
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);

        int totalDataGot = 0;
        int bytesResived = 0; // Bytes received in last read

        while (bytesResived < data.length) {
            if (
                    (bytesResived = in.read(
                            data,
                            totalDataGot,
                            data.length - bytesResived)) == -1) {
                throw new SocketException("Connection closed forcfully");
            }

            totalDataGot += bytesResived;
        }

        System.out.println("Got info from server = " + new String(data));


        socket.close();


    }
}

