package fatec.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente  extends Pessoa{
        
        
	private Long id;
	private Double limitCred;
	private Double limitDisp;
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Cliente() {		
		super();
		
	}
	
	
	public Cliente(String cpf,String nome,Double limiteDisp) {
		super(cpf, nome);
		this.limitDisp = limiteDisp;
		this.limitCred = limiteDisp;
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
	public Double getLimitCred() {
		return limitCred;
	}
	public void setLimitCred(Double limitCred) {
		this.limitCred = limitCred;
	}
	public Double getLimitDisp() {
		Double vlrCompra=0.0;
		//Calcula o valor do pedido
		for(Pedido p: pedidos) {
			vlrCompra += p.getSubTotal();
		}
		
		//Subtrai o valos do pedido do Limite disponivel
		return limitDisp - vlrCompra;
	}
	public void setLimitDisp(Double limitDisp) {
		this.limitDisp = limitDisp;
	}
	

	
    
}
