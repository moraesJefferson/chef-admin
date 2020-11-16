package br.com.chefAdmin.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.QueryHints;

import br.com.chefAdmin.entity.Produto;
import br.com.chefAdmin.util.AbstractDAO;

@Stateless
public class ProdutoDao extends AbstractDAO<Produto, Long>{

	private static final long serialVersionUID = 945165345350089027L;
	
	public ProdutoDao() {
		super(Produto.class);
	}
	
	public List<String> findAllCategoria(){
		String hql = "Select distinct p.categoria from Produto p";
		
		TypedQuery<String> query = entityManager().createQuery(hql, String.class)
				.setHint(QueryHints.CACHEABLE, true);
		
		return query.getResultList();
		
	}	
	
}
