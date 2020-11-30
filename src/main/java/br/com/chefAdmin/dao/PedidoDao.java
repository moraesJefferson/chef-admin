package br.com.chefAdmin.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.chefAdmin.entity.Pedido;
import br.com.chefAdmin.util.AbstractDAO;

public class PedidoDao extends AbstractDAO<Pedido, Long>{

	private static final long serialVersionUID = 1560766646262729461L;
	
	@Inject
	EntityManager em;

	public PedidoDao() {
		super(Pedido.class);		
	}

	public Pedido buscaPorUuid(String uuid) {
		String hql = "from Pedido p where p.uuid = :uuid";
		TypedQuery<Pedido> query = em.createQuery(hql, Pedido.class);
		query.setParameter("uuid", uuid);
		return query.getSingleResult();
	}
	
}
