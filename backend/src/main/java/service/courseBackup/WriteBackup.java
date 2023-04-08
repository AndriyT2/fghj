package service.courseBackup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import utility.utilityLog.LogFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Component
@Scope("prototype")
@Lazy
public class WriteBackup {

    private static String backupFile = "backend/src/main/resources/Backup.bin";

    @Autowired
    public WriteBackup(service.courseBackup.CourseBackup courseBackup) throws FileNotFoundException {

        try (FileOutputStream backupFOS = new FileOutputStream(backupFile);
             ObjectOutputStream backupOOS = new ObjectOutputStream(backupFOS)) {

            backupOOS.writeObject(courseBackup);
            LogFactory.info(this.getClass().getName(), "Create  courseBackup");

        } catch (IOException e) {
            LogFactory.error(this.getClass().getName(), "Course Backup", e.getStackTrace());
        }
    }
}
