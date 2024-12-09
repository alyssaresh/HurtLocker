import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class JerkSONParser {

    //not sure if I need this....
    public String getJerkData() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }
}
