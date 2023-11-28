package org.example;

import java.io.IOException;

import static converters.JSONToXMLConverter.convertJsonToXml;
import static converters.XMLToJSONConverter.convertXmlToJson;
import static fileprocessing.FileValidation.pathValidator;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = args[0];
        String output = args[1];

        if (pathValidator(input, output) == 0)
            convertJsonToXml(input, output);
        else if (pathValidator(input, output) == 1)
            convertXmlToJson(input, output);
    }
}