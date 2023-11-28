package structure.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameXML {
    @JacksonXmlProperty(isAttribute = true)
    private int id;
    private String publisher;
    private String title;
    private int releaseYear;
    private String engine;
    private DetailsXML details;
}
