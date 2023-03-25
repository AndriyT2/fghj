package service.controlWork;

import utility.utilityLog.LogFactory;

public class ControlWork13 implements Runnable {
    private final int timeEnd;


    public ControlWork13(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeEnd * 1000L);
            System.out.println("The time of control work is over!");
        } catch (InterruptedException e) {
            LogFactory.warning(this.getClass().getName(), "Sleep exception", e.getStackTrace());
        }
    }
}
