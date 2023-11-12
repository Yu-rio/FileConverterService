package structure.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement (localName = "library")
public class LibraryXML {
@JacksonXmlElementWrapper(useWrapping = false)
@JacksonXmlProperty(localName = "game")
    private List<GameXML> library;

    public List<GameXML> getLibrary() {
        return library;
    }

    public void setLibrary(List<GameXML> library) {
        this.library = library;
    }
}
