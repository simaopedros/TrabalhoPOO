package fatec.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido{
	
	private Long id;
	private String numero;
	private String dataEmissao;
	private String dataPagamento;
	private String formaPagamento;
	private Boolean situacao;
	private Vendedor vendedor;
	private Cliente cliente;
	
	public List<ItemPedido> itemsPedido = new ArrayList<>();
	
	public Pedido(String numero,String dataEmissao) {
		this.numero = numero;
		this.dataEmissao = dataEmissao;
	}
	
	
	public Pedido() {
		super();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getDataEmissao() {
		return dataEmissao;
	}


	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}


	public String getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public Boolean getSituacao() {
		return situacao;
	}


	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
	
	
	


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
		this.vendedor.addPedido(this);
	}


	public Cliente getCliente() {
		return cliente;
	}
	
	public void printValorTotal() {
		System.out.println("Valor Total: "+getSubTotal());
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		this.cliente.addPedido(this);
	}
	
	public void addItem(ItemPedido item) {
		this.itemsPedido.add(item.getSequencia()-1,item);
	}
	
	
	public void removeItem(ItemPedido item) {
		this.itemsPedido.remove(item);
	}


	public List<ItemPedido> getItemsPedido() {
		return itemsPedido;
	}


	public Double getSubTotal() {
		Double total = 0.0;
		for(ItemPedido ip:itemsPedido) {
			total += ip.getSubTotal();
		}
		
		return total;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public void imprimirItemsPedido() {
		for(ItemPedido ip:itemsPedido) {
			if(ip.getQtdVendida() >0.0) {
				System.out.println(String.format("SEQ: %d Item: %s QTD: %f VLR: %f SUBTOTAL: %f", 
						ip.getSequencia(),ip.getProduto().getDescricao(),ip.getQtdVendida(),ip.getProduto().getPreco(),ip.getSubTotal()));
			}
			
		}
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
