package br.com.chefAdmin.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.chefAdmin.dao.PedidoDao;
import br.com.chefAdmin.dao.ProdutoDao;
import br.com.chefAdmin.entity.ItemPedido;
import br.com.chefAdmin.entity.Pedido;
import br.com.chefAdmin.entity.Produto;
import br.com.chefAdmin.tx.Transacional;

@Named
@SessionScoped
public class CarrinhoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386077676323732600L;

	@Inject
	ProdutoDao produtoDao;
	
	@Inject
	PedidoDao pedidoDao;
	
	private Pedido pedido;
	
	private Long id;

	private Produto produto;
	
	private String observacao;
	
	@PostConstruct
	public void init() {
		this.pedido = new Pedido();
		this.produto = new Produto();
		this.observacao = "";
	}
		
	public String addItemPedidoCarrinho(Produto produto) {
		this.produto = produto;
		ItemPedido item = new ItemPedido();
		item.setProduto(this.produto);
		item.setQuantidade(1);
		item.setObservacao(observacao);
		item.setPedido(pedido);
		pedido.add(item);
		return "carrinho";
	}
	
	public void remover(ItemPedido itemPedido) {
		this.pedido.getListaItensPedido().remove(itemPedido);
		this.pedido.setTotal(new BigDecimal(0));
	}
	
	@Transacional
	public void finalizar() {
		pedidoDao.save(pedido);
		limpaCarrinho();
	}
	
	private void limpaCarrinho() {
		this.pedido = new Pedido();
		this.produto = new Produto();
		this.observacao = "";
		
	}

	public String irParaMenu() {
		return "menu";
	}
	
	public String irParaCarinho() {
		return "carrinho.xhtml";
	}
	
	public String irParaInicio() {
		return "inicio";
	}
	
	public Long getId() {
		return id;
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
