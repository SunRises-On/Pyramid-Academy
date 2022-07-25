
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

class mainTest {
    main Main;
    @BeforeEach
    void setUp() {
        Main = new main();
    }

    @AfterEach
    void tearDown() {
    }

    //test console input of name
    @Test
    void main() {
        String name = "name";
        String checkName = "";
        InputStream stdin = System.in; //automate the console input for name
        System.setIn(new ByteArrayInputStream(name.getBytes()));
        Scanner scan = new Scanner(System.in);//reset stdin
        System.setIn(stdin);
        checkName = main.getName(scan);
        Assertions.assertEquals(checkName = "name", "name","User name isn't correct");
    }

    //Test random number function
    @RepeatedTest(100)
    void repeatedTest(TestInfo testInfo){
        System.out.println("Executing repeated test.");
        int min = 1;
        int max = 20;
        int random = -1;
        random = main.getRandom(max, min);
        System.out.println(random);
        //if random is not in range (1,20) test will fail
        assertTrue("random is out of range: " + random, min <= random && random <= max);

    }
}