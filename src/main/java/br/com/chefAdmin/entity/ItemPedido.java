package br.com.chefAdmin.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.chefAdmin.util.BaseEntity;

@Entity
public class ItemPedido extends BaseEntity{

	private static final long serialVersionUID = 3548929003417083303L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Produto produto;
	
	private int quantidade;
	
	private String observacao;
	
	@ManyToOne
	private Pedido pedido;

	public Long getId() {
		return id;
	}
	
	
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		total = produto.getValor().multiply(new BigDecimal(quantidade));
		return total;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
