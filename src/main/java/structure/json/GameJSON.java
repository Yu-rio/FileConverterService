package structure.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameJSON {
    private int id;
    private String publisher;
    private String title;
    private int releaseYear;
    private String engine;
    private DetailsJSON details;
}