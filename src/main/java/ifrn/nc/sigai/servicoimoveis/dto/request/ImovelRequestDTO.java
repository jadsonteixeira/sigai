package ifrn.nc.sigai.servicoimoveis.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImovelRequestDTO {

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotNull
    @Positive
    private Double valorAluguel;

    @Size(max = 500)
    private String descricao;
}
