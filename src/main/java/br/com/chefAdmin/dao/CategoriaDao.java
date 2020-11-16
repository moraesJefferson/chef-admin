package br.com.chefAdmin.dao;

import br.com.chefAdmin.entity.Categoria;
import br.com.chefAdmin.util.AbstractDAO;

public class CategoriaDao extends AbstractDAO<Categoria, Long>{

	private static final long serialVersionUID = 7962997782590121416L;

	public CategoriaDao() {
		super(Categoria.class);	
	}

}
