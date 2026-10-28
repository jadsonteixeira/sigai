package ifrn.nc.sigai.servicoimoveis.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenResponseDTO {

    private String token;
    private String tipo;
}
