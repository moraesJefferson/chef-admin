package br.com.chefAdmin.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {


	private static final long serialVersionUID = 3919081198868632560L;
	@Inject
	EntityManager manager;
	
	@AroundInvoke
	public Object  executaTX(InvocationContext contexto) throws Exception {

        manager.getTransaction().begin();

        //chama o método do DAO que precisa de TX
        Object resultado = contexto.proceed();

        manager.getTransaction().commit();
        return resultado;
    }
}
