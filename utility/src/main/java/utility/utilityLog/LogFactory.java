package utility.utilityLog;

import java.util.ArrayList;
import java.util.List;

public class LogFactory {

    private String nameClass;

    private static List<Log> logsStorage = new ArrayList<>();


    public static Log error(String name, String message, StackTraceElement[] stackTrace) {
        Log errorLog = new Log(name, LogLevel.ERROR, message, stackTrace);
        logsStorage.add(errorLog);
        LogWriter.writeDataToFile(errorLog);
        return errorLog;
    }


    public static Log warning(String name, String message, StackTraceElement[] stackTrace) {
        Log warningLog = new Log(name, LogLevel.WARNING, message, stackTrace);
        logsStorage.add(warningLog);
        LogWriter.writeDataToFile(warningLog);
        return warningLog;
    }

    public static Log info(String name, String message) {
        Log infoLog = new Log(name, LogLevel.INF0, message);
        logsStorage.add(infoLog);
        LogWriter.writeDataToFile(infoLog);
        return infoLog;
    }

    public static Log debug(String name, String message) {
        Log debugLog = new Log(name, LogLevel.DEBUG, message);
        logsStorage.add(debugLog);
        LogWriter.writeDataToFile(debugLog);
        return debugLog;
    }

    public static List<Log> getLogsStorage() {
        return logsStorage;
    }

}



