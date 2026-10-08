package ifrn.nc.sigai.servicoimoveis.service;

import ifrn.nc.sigai.servicoimoveis.dto.request.FotoRequestDTO;
import ifrn.nc.sigai.servicoimoveis.dto.response.FotoResponseDTO;
import ifrn.nc.sigai.servicoimoveis.exception.FotoNaoEncontradaException;
import ifrn.nc.sigai.servicoimoveis.model.Foto;
import ifrn.nc.sigai.servicoimoveis.repository.FotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoService {

    private final FotoRepository repository;

    public FotoService(FotoRepository repository) {
        this.repository = repository;
    }

    public FotoResponseDTO criar(FotoRequestDTO dto) {
        Foto salvo = repository.save(toEntity(dto));
        return toResponseDTO(salvo);
    }

    public List<Foto> listar() {
        return repository.findAll();
    }

    public FotoResponseDTO buscarPorId(Long id) {
        Foto foto = repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));
        return toResponseDTO(foto);
    }

    public FotoResponseDTO atualizar(Long id, FotoRequestDTO dto) {
        Foto foto = repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));
        foto.setUrl(dto.getUrl());
        foto.setLegenda(dto.getLegenda());
        foto.setPrincipal(dto.getPrincipal());

        Foto atualizada = repository.save(foto);
        return toResponseDTO(atualizada);
    }

    public void deletar(Long id) {
        Foto foto = repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));
        repository.deleteById(id);
    }

    private Foto toEntity(FotoRequestDTO dto) {
        return new Foto(
                null,
                dto.getImovelId(),
                dto.getUrl(),
                dto.getLegenda(),
                dto.getPrincipal()
        );
    }

    private FotoResponseDTO toResponseDTO(Foto foto) {
        return new FotoResponseDTO(
                foto.getId(),
                foto.getImovelId(),
                foto.getUrl(),
                foto.getLegenda(),
                foto.getPrincipal()
        );
    }
}
