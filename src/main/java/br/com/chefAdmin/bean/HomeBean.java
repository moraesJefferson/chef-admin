//package br.com.chefAdmin.bean;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import br.com.chefAdmin.dao.ProdutoDao;
//import br.com.chefAdmin.vo.QuantidadeVO;
//
//@Named
//@SessionScoped
//public class HomeBean implements Serializable{
//
//	private static final long serialVersionUID = -7292400774307177939L;
//	
//	@Inject
//	ProdutoDao produtoDao;
//	
//	private List<QuantidadeVO> lista;
//	
//	@PostConstruct
//	public void init() {
//		this.lista =  new ArrayList<>();
//		this.lista = produtoDao.consultaQuantidade();
//	}
//
//	public List<QuantidadeVO> getLista() {
//		return lista;
//	}
//
//	public void setLista(List<QuantidadeVO> lista) {
//		this.lista = lista;
//	}
//
//}
