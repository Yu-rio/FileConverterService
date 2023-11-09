package structure;

import java.util.List;

public class GenreJSON {

    private String name;
    private List<GameJSON> games;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GameJSON> getGames() {
        return games;
    }

    public void setGames(List<GameJSON> games) {
        this.games = games;
    }
}
