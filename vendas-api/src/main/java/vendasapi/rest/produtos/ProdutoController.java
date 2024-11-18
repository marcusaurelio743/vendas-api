package vendasapi.rest.produtos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vendasapi.model.Produto;
import vendasapi.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto) {
		
		Produto EntidadeProduto  = produto.toModel();
		
		produtoRepository.save(EntidadeProduto);
		
		
		return ProdutoFormRequest.fromModel(EntidadeProduto);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> Atualizar(@PathVariable Long id, @RequestBody ProdutoFormRequest produto) {
		Optional<Produto> produtoExistente = produtoRepository.findById(id);
		
		if(produtoExistente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Produto entidadeProduto = produto.toModel();
		entidadeProduto.setId(id);
		entidadeProduto.setDataCadastro(produtoExistente.get().getDataCadastro());
		produtoRepository.save(entidadeProduto);
		
		return ResponseEntity.ok().build();
	}

}
