package structure.json;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenresJSON {
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = WRAPPER_OBJECT)
    private List<GenreJSON> genres;
}
