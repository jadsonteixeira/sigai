package ifrn.nc.sigai.servicoimoveis.controller;

import ifrn.nc.sigai.servicoimoveis.dto.request.ImovelRequestDTO;
import ifrn.nc.sigai.servicoimoveis.dto.response.ImovelResponseDTO;
import ifrn.nc.sigai.servicoimoveis.model.Imovel;
import ifrn.nc.sigai.servicoimoveis.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelService service;

    public ImovelController(ImovelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ImovelResponseDTO> criar(@Valid @RequestBody ImovelRequestDTO dto) {
        ImovelResponseDTO imovel = service.criar(dto);
        URI uri = URI.create("imoveis/" + imovel.getId());
        return ResponseEntity.created(uri).body(imovel);
    }

    @GetMapping
    public List<Imovel> listar() {
        return service.listar();
    }

    @GetMapping("/endereco")
    public List<Imovel> listarPorEndereco(@RequestParam String endereco) {
        return service.listarPorEndereco(endereco);
    }

    @GetMapping("/{id}")
    public ImovelResponseDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImovelResponseDTO> atualizar(@PathVariable Long id,
                                                       @Valid @RequestBody ImovelRequestDTO imovel) {
        ImovelResponseDTO atualizado = service.atualizar(id, imovel);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
