package utility.utilityLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class LogReader {
    private static final String LOG_STORAGE_FILE = "utility/utilityLog/LogFile.txt";
    Path path = Path.of(LOG_STORAGE_FILE);

    public void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_STORAGE_FILE))) {
            {
                String line;
                System.out.println("  ");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("  ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessageFromFile() {

        try (Stream<String> message = Files.lines(path)) {
            message.forEach(s -> System.out.println((Arrays.stream(s.split("/")).toList().get(3))));

        } catch (IOException e) {
            LogFactory.warning(this.getClass().getName(), "File don't exist", e.getStackTrace());
        }

    }


    public void logInfoCounter() {
        System.out.print("Кількість логів з рівнем INFO: ");

        try (Stream<String> allInfo = Files.lines(path)) {
            long allInfoCounter = allInfo.count();

            try (Stream<String> allInfo2 = Files.lines(path)) {
                System.out.println(allInfo2.skip(allInfoCounter / 2).filter(s -> s.startsWith("INF", 11)).count());

            } catch (IOException e) {

                throw new RuntimeException(e);
            }

        } catch (IOException e) {

            throw new RuntimeException(e);
        }


    }
}



