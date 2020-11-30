package br.com.chefAdmin.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import br.com.chefAdmin.dao.ProdutoDao;
import br.com.chefAdmin.entity.Produto;
import br.com.chefAdmin.tx.Transacional;

@Named
@SessionScoped
public class ItemPedidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2043838603507851803L;

	@Inject
	ProdutoDao produtoDao;
		
	private ListMultimap<String, Produto> listaProdutoCategoria;
	
	private List<Produto> listaProduto;
		
	private Produto produto;
	
	private List<Produto> listaProdutoPratos;
	private List<Produto> listaProdutoEntradas;
	private List<Produto> listaProdutoBebidas;
	private List<Produto> listaProdutoSaladas;
	private List<Produto> listaProdutoSobremesas;
	
	
	@PostConstruct
	public void init() {
		try{		
			this.listaProduto = new ArrayList<>();
			this.produto = new Produto();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transacional
	public void carregaListas() {
		try {
			//this.listaProdutoCategoria = ArrayListMultimap.create();
			List<Produto> lista = new ArrayList<Produto>();
			
			this.listaProdutoPratos = new ArrayList<Produto>();
			this.listaProdutoEntradas= new ArrayList<Produto>();
			this.listaProdutoBebidas= new ArrayList<Produto>();
			this.listaProdutoSaladas= new ArrayList<Produto>();
			this.listaProdutoSobremesas= new ArrayList<Produto>();
			
			
			
			lista = produtoDao.findAll();
			
			for(Produto p  : lista) {
				//this.listaProdutoCategoria.put(p.getCategoria().getDescricao(), p);
				
				if(p.getCategoria().getDescricao().equals("Entradas")) {
					this.listaProdutoEntradas.add(p);
				}else if(p.getCategoria().getDescricao().equals("Saladas")) {
					this.listaProdutoSaladas.add(p);
				}else if(p.getCategoria().getDescricao().equals("Pratos")) {
					this.listaProdutoPratos.add(p);
				}else if(p.getCategoria().getDescricao().equals("Sobremesas")) {
					this.listaProdutoSobremesas.add(p);
				}else {
					this.listaProdutoBebidas.add(p);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListMultimap<String, Produto> getListaProdutoCategoria() {
		return listaProdutoCategoria;
	}

	public void setListaProdutoCategoria(ListMultimap<String, Produto> listaProdutoCategoria) {
		this.listaProdutoCategoria = listaProdutoCategoria;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProdutoPratos() {
		return listaProdutoPratos;
	}

	public void setListaProdutoPratos(List<Produto> listaProdutoPratos) {
		this.listaProdutoPratos = listaProdutoPratos;
	}

	public List<Produto> getListaProdutoEntradas() {
		return listaProdutoEntradas;
	}

	public void setListaProdutoEntradas(List<Produto> listaProdutoEntradas) {
		this.listaProdutoEntradas = listaProdutoEntradas;
	}

	public List<Produto> getListaProdutoBebidas() {
		return listaProdutoBebidas;
	}

	public void setListaProdutoBebidas(List<Produto> listaProdutoBebidas) {
		this.listaProdutoBebidas = listaProdutoBebidas;
	}

	public List<Produto> getListaProdutoSaladas() {
		return listaProdutoSaladas;
	}

	public void setListaProdutoSaladas(List<Produto> listaProdutoSaladas) {
		this.listaProdutoSaladas = listaProdutoSaladas;
	}

	public List<Produto> getListaProdutoSobremesas() {
		return listaProdutoSobremesas;
	}

	public void setListaProdutoSobremesas(List<Produto> listaProdutoSobremesas) {
		this.listaProdutoSobremesas = listaProdutoSobremesas;
	}

}
