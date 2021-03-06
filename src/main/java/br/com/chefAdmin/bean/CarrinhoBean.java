package br.com.chefAdmin.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import br.com.chefAdmin.dao.PedidoDao;
import br.com.chefAdmin.entity.ItemPedido;
import br.com.chefAdmin.entity.Pedido;
import br.com.chefAdmin.entity.Produto;
import br.com.chefAdmin.tx.Transacional;

@Named
@SessionScoped
public class CarrinhoBean implements Serializable{

	private static final long serialVersionUID = -5735477162129853159L;

	@Inject
	PedidoDao pedidoDao;
	
	@Inject
	private FacesContext facesContext;
	
	private Pedido pedido;
	
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
		try {
			pedido.setData(Calendar.getInstance().getTime());
			pedidoDao.save(pedido);
			
//			String contextName = facesContext.getExternalContext().getRequestContextPath();
//			HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
//			response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);			
//			response.setHeader("Location", contextName + "/" + "services/pagamento?uuid=" + pedido.getUuid());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
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
