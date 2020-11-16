package br.com.chefAdmin.dao;

import br.com.chefAdmin.entity.Pedido;
import br.com.chefAdmin.util.AbstractDAO;

public class PedidoDao extends AbstractDAO<Pedido, Long>{

	private static final long serialVersionUID = 1560766646262729461L;

	public PedidoDao() {
		super(Pedido.class);		
	}
}
