package common.lib.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformDtoResponse {
    private Long id;
    private String name;
    private String genres;
    private String url;
    private Long idCompany;
}
