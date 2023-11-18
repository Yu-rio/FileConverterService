import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static converters.JSONToXMLConverter.convertJsonToXml;
import static converters.XMLToJSONConverter.convertXmlToJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

class  FileConverterServiceTest{
    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/result/convertedGameLibrary.json"})
    void testXmlToJson(String pathName) throws IOException {
        String pathXmlFile = "src/test/resources/GameLibrary.xml";
        String pathJsonFile = "src/test/resources/GameLibrary.json";
        convertXmlToJson(pathXmlFile, pathName);
        Path pathNameOriginalFile = Path.of(pathJsonFile);
        Path pathNameConvertedFile = Path.of(pathName);
        String contentOriginalFile = Files.readString(pathNameOriginalFile);
        String contentConvertedFile = Files.readString(pathNameConvertedFile);
        contentOriginalFile = contentOriginalFile.replaceAll("\\s", "");
        contentConvertedFile = contentConvertedFile.replaceAll("\\s", "");
        assertEquals(contentOriginalFile, contentConvertedFile);
    }

    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/result/convertedGameLibrary.xml"})
    void testJsonToXml(String pathName) throws IOException {
        String pathXmlFile = "src/test/resources/GameLibrary.xml";
        String pathJsonFile = "src/test/resources/GameLibrary.json";
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
