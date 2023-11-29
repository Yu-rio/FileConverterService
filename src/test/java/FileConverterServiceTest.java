import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static converters.JSONToXMLConverter.convertJsonToXml;
import static converters.XMLToJSONConverter.convertXmlToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileConverterServiceTest {
    @Test
    void testXmlToJson() throws IOException {
        String pathXmlFile = "src/test/resources/GameLibrary.xml";
        String pathJsonFile = "src/test/resources/GameLibrary.json";
        String pathName = "src/test/resources/result/convertedGameLibrary.json";
        convertXmlToJson(pathXmlFile, pathName);
        File pathNameOriginalFile = new File(pathJsonFile);
        File pathNameConvertedFile = new File(pathName);
        ObjectMapper mapper = new ObjectMapper();
        assertEquals(mapper.readTree(pathNameOriginalFile), mapper.readTree(pathNameConvertedFile));
    }

    @Test
    void testJsonToXml() throws IOException {
        String pathXmlFile = "src/test/resources/GameLibrary.xml";
        String pathJsonFile = "src/test/resources/GameLibrary.json";
        String pathName = "src/test/resources/result/convertedGameLibrary.xml";
        convertJsonToXml(pathJsonFile, pathName);
        File pathNameOriginalFile = new File(pathXmlFile);
        File pathNameConvertedFile = new File(pathName);
        XmlMapper xmlMapper = new XmlMapper();
        assertEquals(xmlMapper.readTree(pathNameOriginalFile), xmlMapper.readTree(pathNameConvertedFile));
    }
}
