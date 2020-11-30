package br.com.chefAdmin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.chefAdmin.dao.PedidoDao;
import br.com.chefAdmin.entity.Pedido;

@Named
@SessionScoped
public class PedidoBean implements Serializable{

	private static final long serialVersionUID = 4464270106498194388L;

	@Inject
	PedidoDao pedidoDao;
	
	private List<Pedido> listaPedido;
	
	private Pedido pedido;
	
	@PostConstruct
	public void init() {
		this.listaPedido = new ArrayList<>();
		this.listaPedido = this.pedidoDao.findAll();
	}
	
	public String irParaVisao(Pedido pedido) {
		this.pedido = pedido;
		return "visao";
	}
	
	public String retornaLista() {
		return "historico";
	}
	
	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
