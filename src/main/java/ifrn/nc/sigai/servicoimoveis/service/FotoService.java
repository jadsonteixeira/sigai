package ifrn.nc.sigai.servicoimoveis.service;

import ifrn.nc.sigai.servicoimoveis.dto.request.FotoRequestDTO;
import ifrn.nc.sigai.servicoimoveis.dto.response.FotoResponseDTO;
import ifrn.nc.sigai.servicoimoveis.exception.FotoNaoEncontradaException;
import ifrn.nc.sigai.servicoimoveis.exception.ImovelNaoEncontradoException;
import ifrn.nc.sigai.servicoimoveis.model.Foto;
import ifrn.nc.sigai.servicoimoveis.model.Imovel;
import ifrn.nc.sigai.servicoimoveis.repository.FotoRepository;
import ifrn.nc.sigai.servicoimoveis.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FotoService {

    private final FotoRepository repository;
    private final ImovelRepository imovelRepository;

    public FotoResponseDTO criar(FotoRequestDTO dto) {

        Foto salvo = repository.save(toEntity(dto));

        return toResponseDTO(salvo);
    }

    public FotoResponseDTO buscarPorId(Long id) {

        Foto foto = repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));

        return toResponseDTO(foto);
    }

    public FotoResponseDTO atualizar(Long id, FotoRequestDTO dto) {

        repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));

        Foto fotoAtualizada = toEntity(dto);
        fotoAtualizada.setId(id);

        fotoAtualizada = repository.save(fotoAtualizada);

        return toResponseDTO(fotoAtualizada);
    }

    public void deletar(Long id) {

        repository.findById(id)
                .orElseThrow(() -> new FotoNaoEncontradaException(id));

        repository.deleteById(id);
    }

    public List<FotoResponseDTO> listar() {

        List<Foto> fotos = repository.findAll();

        return fotos.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private Foto toEntity(FotoRequestDTO dto) {

        Imovel imovel = imovelRepository.findById(dto.getImovelId())
                .orElseThrow(() -> new ImovelNaoEncontradoException(dto.getImovelId()));

        return new Foto(
                null,
                imovel,
                dto.getUrl(),
                dto.getLegenda(),
                dto.getPrincipal());
    }

    private FotoResponseDTO toResponseDTO(Foto foto) {

        return new FotoResponseDTO(
                foto.getId(),
                foto.getImovel().getId(),
                foto.getUrl(),
                foto.getLegenda(),
                foto.getPrincipal()
        );
    }
}
