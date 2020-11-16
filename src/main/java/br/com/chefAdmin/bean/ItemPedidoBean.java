package br.com.chefAdmin.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import br.com.chefAdmin.dao.ProdutoDao;
import br.com.chefAdmin.entity.Produto;
import java.io.Serializable;

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
	
	@PostConstruct
	public void init() {
		try{		
			this.listaProduto = new ArrayList<>();
			this.produto = new Produto();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void carregaListas() {
		try {
			this.listaProdutoCategoria = ArrayListMultimap.create();
			List<Produto> lista = new ArrayList<Produto>();
			lista = produtoDao.findAll();
			
			for(Produto p  : lista) {
				this.listaProdutoCategoria.put(p.getCategoria().getDescricao(), p);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void carregaItensCategoria(String categoria) {
		if(this.listaProdutoCategoria.containsKey(categoria)) {
			this.listaProduto = this.listaProdutoCategoria.get(categoria);
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

}
