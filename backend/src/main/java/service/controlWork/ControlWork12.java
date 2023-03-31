package service.controlWork;

import utility.utilityLog.LogFactory;

public class ControlWork12 extends Thread {
    private final int task;
    private final int time;

    private final String name;

    public ControlWork12(int task, String name, int time) {
        this.task = task;
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println("Student " + name + " get task №" + task);
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            LogFactory.warning(this.getClass().getName(), "Sleep exception", e.getStackTrace());
        }
        System.out.println("Student " + name + " finished the control work with time - " + time + " seconds.");
    }
}
