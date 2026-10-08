package ifrn.nc.sigai.servicoimoveis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoResponseDTO {

    private Long id;
    private Long imovelId;
    private String url;
    private String legenda;
    private Boolean principal;
}
