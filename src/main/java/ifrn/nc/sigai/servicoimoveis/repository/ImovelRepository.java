package ifrn.nc.sigai.servicoimoveis.repository;

import ifrn.nc.sigai.servicoimoveis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findByEnderecoContainingIgnoreCase(String endereco);
    List<Imovel> findByValorAluguelLessThanEqual(Double valorMaximo);
    List<Imovel> findByEnderecoContainingIgnoreCaseAndValorAluguelLessThanEqual(String endereco, Double valorMaximo);
}
