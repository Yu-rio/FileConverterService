package structure;

import java.util.List;

public class GenresJSON {
    private List<GenreWrapperJSON> genres;
    public List<GenreWrapperJSON> getGenres() {
        return genres;
    }
    public void setGenres(List<GenreWrapperJSON> genres) {
        this.genres = genres;
    }
}
