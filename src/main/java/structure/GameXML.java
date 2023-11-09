package structure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class GameXML {
    @JacksonXmlProperty (isAttribute = true)
    private int id;
    private String publisher;
    private String title;
    private int releaseYear;
    private String engine;
    private DetailsXML details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public DetailsXML getDetails() {
        return details;
    }

    public void setDetails(DetailsXML details) {
        this.details = details;
    }
}
