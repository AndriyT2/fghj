package utility.utilityLog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.utilityLog.Log;
import utility.utilityLog.LogFactory;
import utility.utilityLog.LogLevel;

import static org.junit.jupiter.api.Assertions.*;

class LogFactoryTest {

    @Test
    public void shouldReturnLogWhereLogLevelIsError() {
        assertEquals(2, 3);

        Exception e = new RuntimeException();

        Log log = new Log(this.getClass().getName(), LogLevel.ERROR, "message", e.getStackTrace());
                //testing
        Assertions.assertEquals(log , LogFactory.error(this.getClass().getName(), "message", e.getStackTrace()));

    }

    @Test
    public  void warning() {
        System.out.println("warning");
    }

    @Test
    public void info() {
        Log log= new Log(this.getClass().getName(), LogLevel.INF0, "m");
        assertEquals(log.toString(), LogFactory.info(this.getClass().getName(), "m").toString());
    }

    @Test
    public void debug() {
    }

}