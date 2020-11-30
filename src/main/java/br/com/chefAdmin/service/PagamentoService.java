package br.com.chefAdmin.service;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.chefAdmin.dao.PedidoDao;
import br.com.chefAdmin.entity.Pedido;

@Path("/pagamento")
public class PagamentoService {

	@Context
	ServletContext context;

	@Inject
	private PedidoDao pedidoDao;

	@Inject
	private PagamentoGateway pagamentoGateway;

	private static ExecutorService executor = Executors.newFixedThreadPool(50);

	@POST
	public void pagar(@Suspended final AsyncResponse ar, @QueryParam("uuid") String uuid) {
		Pedido pedido = pedidoDao.buscaPorUuid(uuid);

		String contextPath = context.getContextPath();
		
		executor.submit(() -> {
			try {
				String resposta = pagamentoGateway.pagar(pedido.getTotal());
				System.out.println(resposta);

				URI responseUri = UriBuilder
						.fromPath("http://localhost:8080" + contextPath + "/module/home.xhtml")
						.queryParam("msg", "Compra realizada com sucesso").build();

				Response response = Response.seeOther(responseUri).build();
				ar.resume(response);
			} catch (Exception e) {
				ar.resume(new WebApplicationException(e));
			}
		});
	}
}
