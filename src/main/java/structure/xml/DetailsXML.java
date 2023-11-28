package structure.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailsXML {
    private String developer;
    private String genre;
    @JacksonXmlElementWrapper(localName = "platforms")
    @JacksonXmlProperty(localName = "platform")
    private List<String> platforms;
}
