package converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import structure.json.*;
import structure.xml.GameXML;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс для конвертации файла из XML в JSON
 */
public class XMLToJSONConverter {
    private static List<GameXML> readFileXML(String pathName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(pathName);
        return xmlMapper.readValue(file, new TypeReference<>() {
        });
    }

    private static GenresJSON changeStructure(final List<GameXML> library) {
        return GenresJSON.builder()
                .genres(library.stream()
                        .collect(Collectors.groupingBy(game -> game.getDetails().getGenre()))
                        .entrySet().stream().sorted(Map.Entry.comparingByKey())
                        .map(entry -> GenreJSON.builder()
                                .name(entry.getKey())
                                .games(entry.getValue().stream()
                                        .map(gameXML -> GameJSON.builder()
                                                .id(gameXML.getId())
                                                .publisher(gameXML.getPublisher())
                                                .title(gameXML.getTitle())
                                                .releaseYear(gameXML.getReleaseYear())
                                                .engine(gameXML.getEngine())
                                                .details(DetailsJSON.builder()
                                                        .developer(gameXML.getDetails().getDeveloper())
                                                        .platforms(gameXML.getDetails().getPlatforms())
                                                        .build())
                                                .build())
                                        .toList())
                                .build())
                        .toList())
                .build();
    }

    public static void convertXmlToJson(String inputPathName, String outputPathName) throws IOException {
        List<GameXML> library = readFileXML(inputPathName);
        GenresJSON genres = changeStructure(library);
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.writeValue(new File(outputPathName), genres);
    }
}
