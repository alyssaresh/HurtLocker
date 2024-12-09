import org.apache.commons.io.IOUtils;

import java.util.HashMap;

public class Main {
    private HashMap<Integer, JerkSONObject> map;
    private String jerkText;

    public Main() throws Exception {
        this.map = new HashMap<>();
        this.jerkText = (new Main()).readRawDataToString();
    }

    //this is finding the RawData.txt file wherever it is in the classpath -- java can't access these files using system paths
    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public HashMap<Integer, JerkSONObject> PutDataInMap() {
        String[] words = jerkText.split("##");
        Integer index = 0;
        for (String w : words) {
            JerkSONObject jo = new JerkSONObject(w);
            map.put(index, jo);
            index++;
        }
        return map;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
    }


}
