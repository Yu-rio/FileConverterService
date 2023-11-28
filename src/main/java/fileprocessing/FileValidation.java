package fileprocessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileValidation {
    public static Integer pathValidator(String input, String output){
        String jsonFile = ".json$";
        String xmlFile = ".xml$";
        Pattern patternJson = Pattern.compile(jsonFile);
        Pattern patternXml = Pattern.compile(xmlFile);
        Matcher matcherJson = patternJson.matcher(input);
        Matcher matcherXml = patternXml.matcher(output);
        if(matcherJson.find()&&matcherXml.find())
            return 0;
        else {
            matcherJson = patternJson.matcher(output);
            matcherXml = patternXml.matcher(input);
            if(matcherJson.find() && matcherXml.find())
                return 1;
        }
        return 2;
    }
}
