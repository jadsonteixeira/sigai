package ifrn.nc.sigai.servicoimoveis.controller;

import ifrn.nc.sigai.servicoimoveis.dto.request.ImovelRequestDTO;
import ifrn.nc.sigai.servicoimoveis.dto.response.ImovelResponseDTO;
import ifrn.nc.sigai.servicoimoveis.model.Imovel;
import ifrn.nc.sigai.servicoimoveis.service.ImovelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/imoveis")
@RequiredArgsConstructor
public class ImovelController {

    private final ImovelService service;

    @PostMapping
    public ResponseEntity<ImovelResponseDTO> criar(@Valid @RequestBody ImovelRequestDTO dto) {

        ImovelResponseDTO imovel = service.criar(dto);

        URI uri = URI.create("imoveis/" + imovel.getId());

        return ResponseEntity.created(uri).body(imovel);
    }

    @GetMapping
    public ResponseEntity<List<ImovelResponseDTO>> listar() {

        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ImovelResponseDTO buscar(@PathVariable Long id) {

        return service.buscarPorId(id);
    }

    @GetMapping("/filtrar")
    public List<ImovelResponseDTO> listar(@RequestParam (required = false) String endereco,
                                          @RequestParam(required = false) Double valorMaximo) {

        return service.listar(endereco, valorMaximo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImovelResponseDTO> atualizar(@PathVariable Long id,
                                                       @Valid @RequestBody ImovelRequestDTO imovel) {

        ImovelResponseDTO atualizado = service.atualizar(id, imovel);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
