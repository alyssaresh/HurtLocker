import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
//    private String jerkText;
//    private JerkSONParser jerkSONParser;
//
//    @BeforeEach
//    public void setUp() throws IOException {
//        this.jerkSONParser = new JerkSONParser();
//        this.jerkText = jerkSONParser.getJerkData();
//    }

//    @Test
//    public void getJerkData() throws Exception {
//        JerkSONParser jerk = new JerkSONParser();
//        String jerkText = jerk.getJerkData();
//        String actual = (new Main()).readRawDataToString();
//        String expected = jerkText;
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void findGroceryItem(){
//        String regex = "Milk";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(jerkText);
//        if (matcher.find()) {
//            String word = matcher.group();
//            assertEquals(regex, word);
//        } else {
//            fail("No match found for the word 'Milk'");
//        }
//    }
//
//    @Test
//    public void SplitItemsByHashtag() throws IOException {
//        JerkSONParser parser = new JerkSONParser();
//        String jerkText = parser.getJerkData();
//        String regex = "##";
//        String[] words = jerkText.split(regex);
//        System.out.println(Arrays.toString(words));
//    }
//
//    @Test
//    public void JerkSONToMap() throws Exception {
//        jerkSONParser.SetHashMap();
//        HashMap<Integer, String> map = jerkSONParser.GetHashMap();
//        assertTrue(map.containsKey(0));
//        System.out.println(map);
//    }
//
//    @Test
//    public void CheckJerkSONObjHashMap() {
//        JerkSONObject jo = new JerkSONObject("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
//        jo.setKeyValues();
//        System.out.println(jo.getMap());
//    }
//
//    @Test
//    public void JerkSONObjCategoryToString() {
//        JerkSONObject jo = new JerkSONObject("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
//        jo.setKeyValues();
//        String actual = String.format("name:%8s", jo.getMap().get("name"));
//        String expected = "name:    milk";
//        assertEquals(expected, actual);
//    }


    @Test
    public void GetEachEntry() throws Exception {
        String output = (new Main()).readRawDataToString();
        String regex = "([^#]+)##";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(output);
        while (matcher.find()) {
            String entry = matcher.group(1);
            System.out.println(entry);
            GroceryItem grocery = new GroceryItem();
            grocery.setValues(entry);
            System.out.println(grocery);
        }
    }

}