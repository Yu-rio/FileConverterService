import org.junit.jupiter.api.Test;

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
        Path pathNameOriginalFile = Path.of(pathJsonFile);
        Path pathNameConvertedFile = Path.of(pathName);
        String contentOriginalFile = Files.readString(pathNameOriginalFile);
        String contentConvertedFile = Files.readString(pathNameConvertedFile);
        contentOriginalFile = contentOriginalFile.replaceAll("\\s", "");
        contentConvertedFile = contentConvertedFile.replaceAll("\\s", "");
        assertEquals(contentOriginalFile, contentConvertedFile);
    }

    @Test
    void testJsonToXml() throws IOException {
        String pathXmlFile = "src/test/resources/GameLibrary.xml";
        String pathJsonFile = "src/test/resources/GameLibrary.json";
        String pathName = "src/test/resources/result/convertedGameLibrary.xml";
        convertJsonToXml(pathJsonFile, pathName);
        Path pathNameOriginalFile = Path.of(pathXmlFile);
        Path pathNameConvertedFile = Path.of(pathName);
        String contentOriginalFile = Files.readString(pathNameOriginalFile);
        String contentConvertedFile = Files.readString(pathNameConvertedFile);
        contentOriginalFile = contentOriginalFile.replaceAll("\\s", "");
        contentConvertedFile = contentConvertedFile.replaceAll("\\s", "");
        assertEquals(contentOriginalFile, contentConvertedFile);
    }
}
