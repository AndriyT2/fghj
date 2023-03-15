package utility.utilityLog;

import utility.IntTrue;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UnknownFormatConversionException;

public class LogWriter {

    private static final String LOG_STORAGE_FILE = "LogFile.txt";
    private static final String pathToFile = "LogLevel.txt";


    Path path = Paths.get(pathToFile);
    private static final int bufferSize = 132;
   static ByteBuffer buffer = ByteBuffer.allocate(bufferSize);


    protected static void writeDataToFile(Log log) {
        String level = returnLevel();
        if (level.equalsIgnoreCase("ERROR")){
            if(log.getLevel().toString().equalsIgnoreCase("ERROR")) {writeCheckLogToFile(log);}
        } else if (level.equalsIgnoreCase("WARNING")) {
            if(log.getLevel().toString().equalsIgnoreCase("WARNING")
                    |log.getLevel().toString().equalsIgnoreCase("ERROR")) {writeCheckLogToFile(log);}
        } else if (level.equalsIgnoreCase("INF0")) {
            if(log.getLevel().toString().equalsIgnoreCase("INF0")
                    |log.getLevel().toString().equalsIgnoreCase("WARNING")
                    |log.getLevel().toString().equalsIgnoreCase("ERROR")) {writeCheckLogToFile(log);}
        } else if (level.equalsIgnoreCase("DEBUG")) {
            if(log.getLevel().toString().equalsIgnoreCase("DEBUG")
                    |log.getLevel().toString().equalsIgnoreCase("INF0")
                    |log.getLevel().toString().equalsIgnoreCase("WARNING")
                    |log.getLevel().toString().equalsIgnoreCase("ERROR")) {writeCheckLogToFile(log);}
        } else {
            if(!log.getLevel().toString().equalsIgnoreCase("OFF")) {
                     throw new UnknownFormatConversionException("Incorrect value of the level parameter in LogLevel.txt");
            }
        }


    }

    private static void writeCheckLogToFile(Log log){
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_STORAGE_FILE, true))){
            {writer.write(log + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static   String getLevel() throws IOException {
        int  endOfWordBefore = 6;                 //6 - end of word "level=" in LogLevel.txt
        FileChannel inChannel = new FileInputStream(pathToFile).getChannel();

        inChannel.read(buffer);
        String level = new String(buffer.array()).substring(endOfWordBefore, buffer.position()).strip();
        buffer.clear();
        inChannel.close();

        return level;
    }

    private static String returnLevel(){
        try {
            return getLevel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void levelChange() {
        try {
            enterLogLevel();
        } catch (IOException e) {
            LogFactory.error(this.getClass().getName(), "LevelChange text file problem", e.getStackTrace());
        }
    }


    private String setLevel() throws IOException {
        String level = getLevel();
        boolean exit = false;
        int answer;
        while (!exit) {
            do {
                LogFactory.debug(this.getClass().getName(), "SetLevel.List with options");
                System.out.println("""
                        Select the numerical value of the desired level for LogFile:
                        1 - DEBUG;
                        2 - INFO;
                        3 - WARNING;
                        4 - ERROR;
                        5 - OFF;
                        6 - Return to the main menu.""");

                answer = new IntTrue().intTrue();

            } while (answer < 1 || answer > 6);

            switch (answer) {
                case 1 -> {
                    level = "DEBUG";
                }
                case 2 -> {
                    level = "INF0";
                }
                case 3 -> {
                    level = "WARNING";
                }
                case 4 -> {
                    level = "ERROR";
                }
                case 5 -> {
                    level = "OFF";
                }
                case 6 -> {
                    exit = true;
                    LogFactory.debug(this.getClass().getName(), "Close SetLevel");
                }
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }
        }
        return level;
    }

    private  void enterLogLevel() throws IOException {
        LogFactory.debug(this.getClass().getName(), "Change the level of logs");
        String level = setLevel();
        FileChannel inChannel = new RandomAccessFile(pathToFile, "rw").getChannel();
        inChannel.position(6);
        buffer.put("        ".getBytes());//It is correct?
        buffer.flip();
        inChannel.write(buffer);
        buffer.clear();
        inChannel.position(6);
        buffer.put(level.getBytes());
        buffer.flip();
        inChannel.write(buffer);
        buffer.clear();
        inChannel.close();
    }
}


