package fatec.poo.model;


import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Pessoa {
	
	private Long id;
	private Double salarioBase;
	private Double taxaComissao;
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	public Vendedor(String cpf,String nome,Double salarioBase) {
		super(cpf, nome);
		this.salarioBase = salarioBase;
	}
	public Vendedor() {
		super();
		
	}
	
	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}
	
	public void removerPedido(Pedido pedido) {
		this.pedidos.remove(pedido);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Double getTaxaComissao() {
		return taxaComissao;
	}
	public void setTaxaComissao(Double taxaComissao) {
		this.taxaComissao = taxaComissao;
	}
	
	
	public Double getCommissao() {
		Double comissao = 0.0;
		if(this.taxaComissao == null || this.taxaComissao <= 0.0) {
			return 0.0;
		}
		for(Pedido p:pedidos) {
			comissao += (p.getSubTotal() * this.taxaComissao);
		}
		
		return comissao;
	}
	
	
}
