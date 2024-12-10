import org.apache.commons.io.IOUtils;

import java.util.HashMap;

public class Main {

    //this is finding the RawData.txt file wherever it is in the classpath -- java can't access these files using system paths
    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }


    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
    }


}
