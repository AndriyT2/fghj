package utilityLog;

import models.Lecture;
import utility.ScannerThis;

import java.io.*;

public class LogReader {
    private static final String LOG_STORAGE_FILE = "LogFile.txt";

    public void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_STORAGE_FILE))) {
            {
                String line;
                System.out.println("");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
