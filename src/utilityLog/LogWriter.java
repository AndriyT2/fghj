package utilityLog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LogWriter {

    private static final String LOG_STORAGE_FILE = "LogFile.txt";




    protected static void writeDataToFile(Log log) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_STORAGE_FILE, true))){
            {writer.write(log + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
