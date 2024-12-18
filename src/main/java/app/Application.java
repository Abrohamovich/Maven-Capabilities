package app;
import ua.ithillel.util.*;

public class Application {
    public static void main(String[] args) {
        PasswordGenerator pg = new PasswordGenerator();
        int length = 10;

        for (int i = 0; i < 10; i++) {
            String password = pg.generatePassword(10);
            System.out.println("Generated password with length " + length + " : "  + password);
        }

    }

}