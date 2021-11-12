import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void testFindHamlet() {
        //Todo : Add Test
    }

    @Test
    public void testChangeHamletToJordan() {
        //Todo : Add Test
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Todo : Add Test
    }


}