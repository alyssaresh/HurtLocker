import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class MainTest {
    private String jerkText;
    private JerkSONParser jerkSONParser;

    @BeforeEach
    public void setUp() throws IOException {
        this.jerkSONParser = new JerkSONParser();
        this.jerkText = jerkSONParser.getJerkData();
    }

    @Test
    public void getJerkData() throws Exception {
        JerkSONParser jerk = new JerkSONParser();
        String jerkText = jerk.getJerkData();
        String actual = (new Main()).readRawDataToString();
        String expected = jerkText;
        assertEquals(expected, actual);
    }

    @Test
    public void findGroceryItem(){
        String regex = "Milk";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jerkText);
        if (matcher.find()) {
            String word = matcher.group();
            assertEquals(regex, word);
        } else {
            fail("No match found for the word 'Milk'");
        }
    }


}