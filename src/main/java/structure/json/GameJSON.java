package structure.json;

public class GameJSON {
    private String publisher;
    private String title;
    private int releaseYear;
    private String engine;
    private DetailsJSON details;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public DetailsJSON getDetails() {
        return details;
    }

    public void setDetails(DetailsJSON details) {
        this.details = details;
    }
}

