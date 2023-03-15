package service.CourseBackup;

import utility.utilityLog.LogFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteBackup {

    private static String backupFile = "src/main/java/service/courseBackup/Backup.bin";
    public WriteBackup(service.CourseBackup.CourseBackup courseBackup) throws FileNotFoundException {

        try(FileOutputStream backupFOS = new FileOutputStream(backupFile);
            ObjectOutputStream backupOOS = new ObjectOutputStream(backupFOS)){

            backupOOS.writeObject(courseBackup);
            LogFactory.info(this.getClass().getName(), "Create  courseBackup");

        } catch (IOException e) {
            LogFactory.error(this.getClass().getName(), "Course Backup", e.getStackTrace());
        }
    }
}
