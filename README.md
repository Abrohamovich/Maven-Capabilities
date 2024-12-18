# Maven-Capabilities project

---

This project demonstrates the ability to install
project artifacts (here `password-generator`) into a local `Maven` repository,
and subsequently use it in your other project.
`PasswordGenerator` class:

```
package ua.ithillel.util;

import java.util.Random;

public class PasswordGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "0123456789" +
            "`~!@#$%^&*()_-+=[]{};:'\"\\|<>,.?";
    private static final int LENGTH = CHARACTERS.length();

    Random random = new Random();

    public String generatePassword(int length) {
        if (length<=0){
            throw new IllegalArgumentException("Length should be greater than zero");
        }else {
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int randomInt = random.nextInt(LENGTH);
                char randomChar = CHARACTERS.charAt(randomInt);
                password.append(randomChar);

            }
            return password.toString();
        }
    }

}
```

`PasswordGeneratorTest` class:

```
package app.ua.ithillel.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.ithillel.util.PasswordGenerator;

class PasswordGeneratorTest {
    @Test
    void passwordLength(){
        PasswordGenerator pg = new PasswordGenerator();
        int length = 20;
        String password = pg.generatePassword(length);
        Assertions.assertEquals(length, password.length());
    }
    @Test
    void passwordException(){
        PasswordGenerator pg = new PasswordGenerator();
        int length = -7;
        Assertions.assertThrows(IllegalArgumentException.class, () -> { pg.generatePassword(length); });
    }
}
```
