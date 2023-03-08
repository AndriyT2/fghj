package utility.utilityLog;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class LogReader {
    private static final String LOG_STORAGE_FILE = "LogFile.txt";
    Path path = Path.of(LOG_STORAGE_FILE);

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

    public void readMessageFromFile() {

        try {
            Files.lines(path).forEach(s -> System.out.println((Arrays.stream(s.split("/")).toList().get(3))));

        } catch (IOException e) {
            LogFactory.warning(this.getClass().getName(), "File don't exist", e.getStackTrace());
        }

    }
}



