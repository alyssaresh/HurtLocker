import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryItem {


    private String name;
    private String price;
    private String type;
    private String expiration;
    private Map<String, String> map;

    public GroceryItem() {
        this.name = "";
        this.price = "";
        this.type = "";
        this.expiration = "";
        this.map = new HashMap<>();
    }

    public void setValues(String entry) {
        String keyValueRegex = "(\\w+):\\s*([^:@^*%;]+)";
        Pattern pattern = Pattern.compile(keyValueRegex);
        Matcher matcher = pattern.matcher(entry);

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
        }
    }

    @Override
    public String toString(){
        return "Name: " + name;
    }

}
