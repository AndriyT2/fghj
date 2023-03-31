package utility;

import utility.utilityLog.LogFactory;

import java.util.InputMismatchException;

public class IntTrue {
    int number;
    boolean rule = false;

    public int intTrue() {
        while (!rule) {
            try {
                number = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
                rule = true;
            } catch (InputMismatchException e) {
                LogFactory.warning(this.getClass().getName(), "Entered a symbol instead of a number", e.getStackTrace());
                System.out.println("Необхідно ввести число, а не символи. Спробуйте знову!");
                ScannerThis.getInstance().nextLine();
            }
        }
        return number;
    }
}
