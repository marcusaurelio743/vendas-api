package vendasapi.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import vendasapi.rest.produtos.ProdutoFormRequest;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 200)
	private String nome;
	@Column(length = 200)
	private String sku;

	private String descricao;
	@Column(precision = 16, scale = 2)

	private BigDecimal preco;
	
	

	public Produto() {
		super();
		
	}
	

	public Produto( String nome, String sku, String descricao, BigDecimal preco) {
		
		this.nome = nome;
		this.sku = sku;
		this.descricao = descricao;
		this.preco = preco;
	}
	public Produto( ProdutoFormRequest formRequest) {
		
		this.nome = formRequest.getNome();
		this.sku = formRequest.getSku();
		this.descricao = formRequest.getDescricao();
		this.preco = formRequest.getPreco();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", sku=" + sku + ", descricao=" + descricao + ", preco=" + preco
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
