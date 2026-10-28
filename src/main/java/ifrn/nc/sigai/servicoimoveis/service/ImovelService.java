package ifrn.nc.sigai.servicoimoveis.service;

import ifrn.nc.sigai.servicoimoveis.dto.request.ImovelRequestDTO;
import ifrn.nc.sigai.servicoimoveis.dto.response.ImovelResponseDTO;
import ifrn.nc.sigai.servicoimoveis.exception.ImovelNaoEncontradoException;
import ifrn.nc.sigai.servicoimoveis.model.Imovel;
import ifrn.nc.sigai.servicoimoveis.repository.ImovelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImovelService {

    private final ImovelRepository repository;

    public ImovelResponseDTO criar(ImovelRequestDTO dto) {
        Imovel salvo = repository.save(toEntity(dto));

        return toResponseDTO(salvo);
    }

    public List<ImovelResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public List<Imovel> listarPorEndereco(String endereco) {
        return repository.findByEnderecoContainingIgnoreCase(endereco);
    }

    public ImovelResponseDTO buscarPorId(Long id) {
        Imovel imovel = repository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));

        return toResponseDTO(imovel);
    }

    public ImovelResponseDTO atualizar(Long id, ImovelRequestDTO dto) {
        Imovel imovel = repository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));

        imovel.setEndereco(dto.getEndereco());
        imovel.setValorAluguel(dto.getValorAluguel());
        imovel.setDescricao(dto.getDescricao());

        Imovel atualizado = repository.save(imovel);
        return toResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        Imovel imovel = repository.findById(id)
                .orElseThrow(() -> new ImovelNaoEncontradoException(id));
        repository.deleteById(id);
    }

    private Imovel toEntity(ImovelRequestDTO dto) {
        return new Imovel(null, dto.getEndereco(), dto.getValorAluguel(), dto.getDescricao(), null);
    }

    private ImovelResponseDTO toResponseDTO(Imovel imovel) {
        return new ImovelResponseDTO(imovel.getId(), imovel.getEndereco(), imovel.getValorAluguel());
    }
}
