package converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import structure.json.*;
import structure.xml.DetailsXML;
import structure.xml.GameXML;
import structure.xml.LibraryXML;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;

/**
 * Класс для конвертации файла из JSON в XML
 */
public class JSONToXMLConverter {
    private static GenresJSON readFileJSON(String pathName) throws IOException {
        JsonMapper jsonMapper = new JsonMapper();
        File file = new File(pathName);
        return jsonMapper.readValue(file, new TypeReference<>() {
        });
    }

    private static LibraryXML changeStructure(final GenresJSON genres) {
        return LibraryXML.builder()
                .library(genres.getGenres().stream()
                        .flatMap(genreJSON -> genreJSON.getGames().stream()
                                .map(gameJSON -> GameXML.builder()
                                        .id(gameJSON.getId())
                                        .publisher(gameJSON.getPublisher())
                                        .title(gameJSON.getTitle())
                                        .releaseYear(gameJSON.getReleaseYear())
                                        .engine(gameJSON.getEngine())
                                        .details(DetailsXML.builder()
                                                .developer(gameJSON.getDetails().getDeveloper())
                                                .genre(genreJSON.getName())
                                                .platforms(gameJSON.getDetails().getPlatforms())
                                                .build())
                                        .build()))
                        .sorted(Comparator.comparingInt(GameXML::getId))
                        .toList())
                .build();
    }

    public static void convertJsonToXml(String inputPathName, String outputPathName) throws IOException {
        GenresJSON genres = readFileJSON(inputPathName);
        LibraryXML library = changeStructure(genres);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(outputPathName), library);
    }
}
