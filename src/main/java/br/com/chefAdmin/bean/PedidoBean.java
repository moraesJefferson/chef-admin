package br.com.chefAdmin.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.chefAdmin.dao.ProdutoDao;
import br.com.chefAdmin.entity.Produto;

@Model
public class PedidoBean {

	@Inject
	ProdutoDao produtoDao;
	
	private List<Produto> listaProdutos;
	
	@PostConstruct
	public void init() {
		try{
			listaProdutos = new ArrayList<>();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void carregaListaProdutos() {
		this.listaProdutos = produtoDao.findAll();
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
}
