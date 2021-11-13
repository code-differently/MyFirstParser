import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @BeforeEach
    public void setUp() {
        hamletParser = new HamletParser();
        hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testFindHoratio() {
        //Todo : Add Test
        String test = hamletText;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(test);
        Assertions.assertTrue(matcher.find());
    }

    @Test
    public void testFindHamlet() {
        //Todo : Add Test
        String test = hamletText;
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(test);
        Assertions.assertTrue(matcher.find());
    }

    @Test
    public void testChangeHamletToJordan() {
        //Todo : Add Test
        String test = "Hamlet is a play.";
        String expected = "Jordan is a play.";
        String actual = hamletParser.changeHamletToJordan(test);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Todo : Add Test
        String test = "There once was a boy named Horatio hey hey!";
        String expected = "There once was a boy named Tariq hey hey!";
        String actual = hamletParser.changeHoratioToTariq(test);
        Assertions.assertEquals(expected, actual);
    }

}