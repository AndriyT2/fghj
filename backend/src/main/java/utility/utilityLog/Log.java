package utility.utilityLog;

import java.time.LocalDate;
import java.util.Arrays;

public class Log {
    private String name;
    private LogLevel level;
    private String message;
    private LocalDate data;
    private StackTraceElement[] stacktrace;

    protected Log(String name, LogLevel level, String message, StackTraceElement[] stacktrace) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.data = LocalDate.now();
        this.stacktrace = stacktrace;
    }

    public LogLevel getLevel() {
        return level;
    }

    @Override
    public String toString() {
        String s;
        if (stacktrace == null) {
            s = data + "/" + level + "/" + name + "/" + message;
        } else {
            s = data + "/" + level + "/" + name + "/" + message + "/" + Arrays.toString(stacktrace);
        }
        return s;

    }

    protected Log(String name, LogLevel level, String message) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.data = LocalDate.now();
    }
}
