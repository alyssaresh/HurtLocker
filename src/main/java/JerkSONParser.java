import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONParser {
    HashMap<String, GroceryItem> map;
    int errorCount;


    public JerkSONParser() {
        this.map = new HashMap<>();
        this.errorCount = 0;
    }

    public void parse(String data) throws Exception {
        String regex = "([^:@^*%;]+##)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            String entry = matcher.group(1);
            try {
                parseEntry(entry);
            } catch (Exception e) {
                errorCount++;
            }
        }
    }

    private void parseEntry(String entry) {
        String keyValueRegex = "(\\w+):\\s*([^:@^*%;]+)";
        Pattern pattern = Pattern.compile(keyValueRegex);
        Matcher matcher = pattern.matcher(entry);

        String name = null;
        String price = null;
        String type = null;
        String expiration = null;

        while (matcher.find()) {
            String key = matcher.group(1).toLowerCase();
            String value = matcher.group(2);

            switch (key) {
                case "name":
                    name = value;
                    break;
                case "price":
                    price = value;
                    break;
                case "type":
                    type = value;
                    break;
                case "expiration":
                    expiration = value;
                    break;
            }

            if (name != null && price != null && type != null && expiration != null) {
                addGroceryItem(name, price, type, expiration);
            } else {
                throw new IllegalArgumentException("Missing name or price");
            }
    }
}

    private void addGroceryItem(String name, String price, String type, String expiration) {
        map.putIfAbsent(name, new GroceryItem());
    }

}
