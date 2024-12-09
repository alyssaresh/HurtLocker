import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JerkSONParser {
    HashMap<Integer, JerkSONObject> map;


    public JerkSONParser(){
        this.map = new HashMap<>();
    }

    //not sure if I need this....
    public String getJerkData() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public void SetHashMap() throws IOException {
    String jerkText = this.getJerkData();
    String[] words = jerkText.split("##");
    Integer index = 0;
        for (String w : words) {
        JerkSONObject jo = new JerkSONObject(w);
        map.put(index, jo);
        index++;
        }
    }

    public HashMap<Integer,JerkSONObject> GetHashMap() {
        return map;
    }
}
