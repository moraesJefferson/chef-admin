package br.com.chefAdmin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.chefAdmin.util.BaseEntity;

@Entity
public class Pedido extends BaseEntity{

	private static final long serialVersionUID = 1095109731746533386L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST)
	private List<ItemPedido> listaItensPedido;
	
	private String uuid;
	
	private BigDecimal total;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@PrePersist
	public void prePersist() {
		this.uuid = UUID.randomUUID().toString();
	}
	
	public Pedido() {
		this.listaItensPedido = new ArrayList<ItemPedido>();
		this.total = new BigDecimal(0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public BigDecimal getTotal() {
		this.setTotal(new BigDecimal(0));
		for(ItemPedido item : this.listaItensPedido) {
			this.setTotal(this.total.add(item.getProduto().getValor().multiply(new BigDecimal(item.getQuantidade()))));
		}
		
		return total;
	}
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ItemPedido> getListaItensPedido() {
		return listaItensPedido;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void add(ItemPedido itemPedido) {
		this.listaItensPedido.add(itemPedido);
	}
}
