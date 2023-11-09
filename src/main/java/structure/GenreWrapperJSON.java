package structure;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreWrapperJSON {
    @JsonProperty("genre")
    private GenreJSON genre;
    public GenreJSON getGenre() {
        return genre;
    }
    public void setGenres(GenreJSON genre) {
        this.genre = genre;
    }
}
