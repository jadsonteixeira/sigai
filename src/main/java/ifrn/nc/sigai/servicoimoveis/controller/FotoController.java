package ifrn.nc.sigai.servicoimoveis.controller;

import ifrn.nc.sigai.servicoimoveis.dto.request.FotoRequestDTO;
import ifrn.nc.sigai.servicoimoveis.dto.response.FotoResponseDTO;
import ifrn.nc.sigai.servicoimoveis.model.Foto;
import ifrn.nc.sigai.servicoimoveis.service.FotoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    private final FotoService service;

    public FotoController(FotoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FotoResponseDTO> criar(@Valid @RequestBody FotoRequestDTO dto) {
        FotoResponseDTO foto = service.criar(dto);
        URI uri = URI.create("fotos/" + foto.getId());
        return ResponseEntity.created(uri).body(foto);
    }

    @GetMapping
    public List<Foto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public FotoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FotoResponseDTO> atualizar(@PathVariable Long id,
                                                     @Valid @RequestBody FotoRequestDTO dto) {
        FotoResponseDTO atualizada = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
