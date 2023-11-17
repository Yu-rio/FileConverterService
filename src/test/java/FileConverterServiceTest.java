import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class  FileConverterServiceTest{
    @ParameterizedTest
    @ValueSource(strings = {"src/test/resources/result/convertedGameLibrary.json"})
    void testXmlToJson(String pathName) throws IOException {
        Path pathNameOriginalFile = Path.of("src/test/resources/GameLibrary.json");
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
        Path pathNameOriginalFile = Path.of("src/test/resources/GameLibrary.xml");
        Path pathNameConvertedFile = Path.of(pathName);
        String contentOriginalFile = Files.readString(pathNameOriginalFile);
        String contentConvertedFile = Files.readString(pathNameConvertedFile);
        contentOriginalFile = contentOriginalFile.replaceAll("\\s", "");
        contentConvertedFile = contentConvertedFile.replaceAll("\\s", "");
        assertEquals(contentOriginalFile, contentConvertedFile);
    }
}
