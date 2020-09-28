package br.com.chefAdmin.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;


public abstract class AbstractDAO<T, PK> implements Serializable {

	private static final long serialVersionUID = 4304870101163862398L;
	
	@PersistenceContext(unitName = "chef-admin", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	private final Class<T> classe;

	public EntityManager entityManager() {
		return em;
	}

	public AbstractDAO(Class<T> classe) {
		this.classe = classe;
	}

	public void save(T object) {
		em.persist(object);
	}
	
	public List<T> findAll() {
		String hql = "select c from " + classe.getSimpleName() + " c ";
		TypedQuery<T> query = em.createQuery(hql, classe);
		List<T> lista = query.getResultList();
		return lista;
	}

	public void update(T object) {
		em.merge(object);
	}

	public void remove(T object) {
		em.remove(object);
	}

	public T find(PK pk) {
		return em.find(classe, pk);
	}

	public Long count() {
		String hql = "select count(c) from " + classe.getSimpleName() + " c ";
		TypedQuery<Long> query = em.createQuery(hql, Long.class);
		Long count = query.getSingleResult();
		return count;
	}
}