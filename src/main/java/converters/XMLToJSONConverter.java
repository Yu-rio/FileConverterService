package converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import structure.json.*;
import structure.xml.GameXML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для конвертации файла из XML в JSON
 */
public class XMLToJSONConverter{
    private static List<GameXML> readFileXML(String pathName) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File(pathName);
        return xmlMapper.readValue(file, new TypeReference<List<GameXML>>(){});
    }
    private static GenresJSON changeStructureXMLToJSON(List<GameXML> library){
        GenresJSON genres = new GenresJSON();
        List<GenreWrapperJSON> genresWrapperJSON = new ArrayList<>();
        for (GameXML gameXML : library) {
            String genreNameXML = gameXML.getDetails().getGenre();
            int index = 0;
            boolean flag = false;
            for( GenreWrapperJSON genre : genresWrapperJSON){
                String genreNameJSON = genre.getGenre().getName();
                if(genreNameXML.equals(genreNameJSON)){
                    flag = true;
                    break;
                }
                index++;
            }
            if(!flag){
                index = genresWrapperJSON.size();
                GenreJSON newGenre = new GenreJSON();
                newGenre.setName(genreNameXML);
                List<GameJSON> games = new ArrayList<>();
                newGenre.setGames(games);
                GenreWrapperJSON newGenreWrapper = new GenreWrapperJSON();
                newGenreWrapper.setGenres(newGenre);
                genresWrapperJSON.add(newGenreWrapper);

            }
            GameJSON gameJSON = new GameJSON();
            gameJSON.setTitle(gameXML.getTitle());
            gameJSON.setPublisher(gameXML.getPublisher());
            gameJSON.setReleaseYear(gameXML.getReleaseYear());
            gameJSON.setEngine(gameXML.getEngine());
            DetailsJSON gameDetailsJSON = new DetailsJSON();
            gameDetailsJSON.setDeveloper(gameXML.getDetails().getDeveloper());
            gameDetailsJSON.setPlatforms(gameXML.getDetails().getPlatforms());
            gameJSON.setDetails(gameDetailsJSON);
            genresWrapperJSON.get(index).getGenre().getGames().add(gameJSON);
        }
        genres.setGenres(genresWrapperJSON);
        return genres;
    }
    public static void convertXmlToJson(String inputPathName, String outputPathName) throws IOException {
        List<GameXML> library;
        try {
            library = readFileXML(inputPathName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GenresJSON genres = changeStructureXMLToJSON(library);
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        jsonMapper.writeValue(new File(outputPathName), genres);
    }
}
