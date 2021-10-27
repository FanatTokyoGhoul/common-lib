package common.lib.models.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoContentDtoRequest {
    private String name;
    private String genres;
    private String image;
    private String description;
    private Long idPerson;
}
