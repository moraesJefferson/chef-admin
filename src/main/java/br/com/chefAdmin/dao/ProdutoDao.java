package br.com.chefAdmin.dao;

import javax.ejb.Stateless;

import br.com.chefAdmin.entity.Produto;
import br.com.chefAdmin.util.AbstractDAO;

@Stateless
public class ProdutoDao extends AbstractDAO<Produto, Long>{

	public ProdutoDao(Class<Produto> classe) {
		super(Produto.class);
	}

	private static final long serialVersionUID = 945165345350089027L;

	
}
