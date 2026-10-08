package ifrn.nc.sigai.servicoimoveis.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoRequestDTO {

    @NotNull(message = "ID do imóvel é obrigatório")
    private Long imovelId;

    @NotBlank(message = "URL é obrigatório")
    private String url;

    @Size(max = 200, message = "Legenda deve ter no máximo 200 caracteres")
    private String legenda;

    @NotNull(message = "Campo obrigatório true ou false")
    private Boolean principal;
}
