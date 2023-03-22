package service.courseBackup;

import utility.utilityLog.LogFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadBackup {
    private static String backupFile = "service/src/main/java/service/courseBackup/Backup.bin";

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
