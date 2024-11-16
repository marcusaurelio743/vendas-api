package vendasapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vendasapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
