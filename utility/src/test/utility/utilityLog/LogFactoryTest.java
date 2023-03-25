package utility.utilityLog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogFactoryTest {

    @DisplayName("errorLog")
    @Test
    public void shouldCreateLogWhereLogLevelIsError() {
        Exception e = new RuntimeException();

        //testing
        Assertions.assertNotEquals(LogLevel.INF0, LogFactory.error(this.getClass().getName(), "Log test", e.getStackTrace()).getLevel());
    }

    @Test
    public void returnFalseIfLogLevelIsNotError() {
        Exception e = new RuntimeException();
        int count = LogFactory.getLogsStorage().size() + 1;

        //testing
        Assertions.assertEquals(LogLevel.ERROR, LogFactory.error(this.getClass().getName(), "Log test", e.getStackTrace()).getLevel());
        assertEquals(count, LogFactory.getLogsStorage().size());
    }


    @DisplayName("warningLog")
    @Test
    public void shouldCreateLogWhereLogLevelIsWarning() {
        Exception e = new RuntimeException();
        int count = LogFactory.getLogsStorage().size() + 1;
        //testing
        Assertions.assertEquals(LogLevel.WARNING, LogFactory.warning(this.getClass().getName(), "Log test", e.getStackTrace()).getLevel());

    }

    @DisplayName("infoLog")
    @Test
    public void shouldCreateLogWhereLogLevelIsInfo() {
        int count = LogFactory.getLogsStorage().size() + 1;
        //testing
        Assertions.assertEquals(LogLevel.INF0, LogFactory.info(this.getClass().getName(), "Log test").getLevel());
    }

    @DisplayName("debugLog")
    @Test
    public void shouldCreateLogWhereLogLevelIsDebug() {
        int count = LogFactory.getLogsStorage().size() + 1;
        //testing
        Assertions.assertEquals(LogLevel.DEBUG, LogFactory.debug(this.getClass().getName(), "Log test").getLevel());

    }

}