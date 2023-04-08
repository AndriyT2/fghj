package service.courseBackup;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import utility.utilityLog.LogFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
@Component
@Scope("prototype")
@Lazy
public class ReadBackup {
    private static String backupFile = "backend/src/main/resources/Backup.bin";

    public ReadBackup() {

        try (FileInputStream backupFIS = new FileInputStream(backupFile);
             ObjectInputStream backupOIS = new ObjectInputStream(backupFIS)) {

            System.out.println(backupOIS.readObject().toString());
            LogFactory.info(this.getClass().getName(), "Display  course Backup");

        } catch (IOException | ClassNotFoundException e) {
            LogFactory.error(this.getClass().getName(), "Course Backup", e.getStackTrace());
        }
    }
}
