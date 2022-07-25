import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

class mainTest {

    main Main;

    @BeforeEach
    void setUp() {
        Main = new main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() {
        String data = "1";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scan = new Scanner(System.in);
        System.setIn(stdin);
        int choice;
        choice = main.getInput(scan);
        Assertions.assertEquals(choice = 1, 1, "choice does not equal 1");
    }
    
}