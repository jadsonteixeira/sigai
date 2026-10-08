package ifrn.nc.sigai.servicoimoveis.repository;

import ifrn.nc.sigai.servicoimoveis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findByEndereco(String endereco);

    List<Imovel> findByValorAluguelLessThan(Double valor);

    List<Imovel> findByEnderecoContainingIgnoreCase(String trecho);
}
