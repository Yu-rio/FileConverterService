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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс для конвертации файла из JSON в XML
 */
public class JSONToXMLConverter {
    private static GenresJSON readFileJSON(String pathName) throws IOException {
        JsonMapper jsonMapper = new JsonMapper();
        File file = new File(pathName);
        return jsonMapper.readValue(file, new TypeReference<GenresJSON>(){});
    }
    private static LibraryXML changeStructureJSONToXML(GenresJSON genres){
        LibraryXML library = new LibraryXML();
        List<GameXML> gamesLibrary = new ArrayList<>();
        for(GenreWrapperJSON genreWrapper: genres.getGenres()){
            String genre = genreWrapper.getGenre().getName();
            List<GameJSON> games = genreWrapper.getGenre().getGames();
            for(GameJSON gameJson: games){
                GameXML game = new GameXML();
                game.setId(gameJson.getId());
                game.setTitle(gameJson.getTitle());
                game.setPublisher(gameJson.getPublisher());
                game.setEngine(gameJson.getEngine());
                game.setReleaseYear(gameJson.getReleaseYear());
                DetailsXML details = new DetailsXML();
                details.setDeveloper(gameJson.getDetails().getDeveloper());
                details.setGenre(genre);
                details.setPlatforms(gameJson.getDetails().getPlatforms());
                game.setDetails(details);
                gamesLibrary.add(game);
            }
        }
        gamesLibrary.sort(Comparator.comparingInt(GameXML::getId));
        library.setLibrary(gamesLibrary);
        return library;
    }
    public static void convertJsonToXml(String inputPathName, String outputPathName) throws IOException {
        GenresJSON genres;
        try {
            genres = readFileJSON(inputPathName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LibraryXML library = changeStructureJSONToXML(genres);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(outputPathName), library);
    }
}
