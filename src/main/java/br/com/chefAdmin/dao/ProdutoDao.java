package br.com.chefAdmin.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.annotations.QueryHints;

import br.com.chefAdmin.entity.Produto;
import br.com.chefAdmin.util.AbstractDAO;
import br.com.chefAdmin.vo.QuantidadeVO;


public class ProdutoDao extends AbstractDAO<Produto, Long>{

	private static final long serialVersionUID = 945165345350089027L;
	
	@Inject
	EntityManager em;
	
	public ProdutoDao() {
		super(Produto.class);
	}
	
	public List<String> findAllCategoria(){
		String hql = "Select distinct p.categoria from Produto p";
		
		TypedQuery<String> query = em.createQuery(hql, String.class)
				.setHint(QueryHints.CACHEABLE, true);
		
		return query.getResultList();
		
	}
	
	public List<QuantidadeVO> consultaQuantidade(){
		String hql = "select new br.com.chefAdmin.vo.QuantidadeVO (count(i.produto) as qtd, p.nome as nome) from produto p, itempedido i "
				+ "where i.produto.id = p.id "
				+ "group by nome "
				+ "order by qtd desc "
				+ "limit 5 ";
		
		TypedQuery<QuantidadeVO> query = em.createQuery(hql, QuantidadeVO.class);	
		return query.getResultList();
	}
}
