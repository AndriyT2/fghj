package service.CourseBackup;

import utility.utilityLog.LogFactory;

import java.io.*;

public class ReadBackup {
    private static String backupFile = "src/service/courseBackup/Backup.bin";
    public ReadBackup() {

        try(FileInputStream backupFIS = new FileInputStream(backupFile);
            ObjectInputStream backupOIS = new ObjectInputStream(backupFIS)){

            System.out.println(backupOIS.readObject().toString());
            LogFactory.info(this.getClass().getName(), "Display  course Backup");

        } catch (IOException | ClassNotFoundException e) {
            LogFactory.error(this.getClass().getName(), "Course Backup", e.getStackTrace());
        }
    }
}
