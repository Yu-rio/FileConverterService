package org.example;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static converters.JSONToXMLConverter.convertJsonToXml;
import static converters.XMLToJSONConverter.convertXmlToJson;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = args[0];
        String output = args[1];
        String jsonFile = ".json$";
        String xmlFile = ".xml$";
        Pattern patternJson = Pattern.compile(jsonFile);
        Pattern patternXml = Pattern.compile(xmlFile);
        Matcher matcherJson = patternJson.matcher(input);
        Matcher matcherXml = patternXml.matcher(output);
        if(matcherJson.find()&&matcherXml.find()) convertJsonToXml(input, output);
        else {
            matcherJson = patternJson.matcher(output);
            matcherXml = patternXml.matcher(input);
            if(matcherJson.find()&&matcherXml.find())
                convertXmlToJson(input, output);
            else System.out.println("Check paths of files");
        }
    }
}