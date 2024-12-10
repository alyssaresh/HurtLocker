//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class JerkSONObject {
//    private JerkSONParser jerk;
//    private String entry;
//    private Map<String, Object> map;
//
//    public JerkSONObject(String w) {
//        this.entry = w;
//        this.map = new HashMap<>();
//    }
//
//
//    public void setKeyValues() {
//        String regex = "(\\w+):\\s*([^:@^*%;]+)";
//        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(entry);
//        while (matcher.find()) {
//            String key = matcher.group(1);
//            String value = matcher.group(2);
//            map.put(key.toLowerCase(), value.toLowerCase());
//        }
//    }
//
//    public Map<String, Object> getMap(){
//        return map;
//    }
//}