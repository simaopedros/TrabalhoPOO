package fatec.poo.model;

public class ItemPedido{
        
	private Long id;
	private Integer sequencia;
	private Double qtdVendida;
	private Produto produto;
	
	

	public ItemPedido() {
		super();
		
	}
	
	public ItemPedido(Integer sequencia,Double quantidade,Produto produto ) {
		this.sequencia = sequencia;
		this.qtdVendida = quantidade;
		this.produto = produto;
		this.baixarEstoque(quantidade);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSequencia() {
		return sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public Double getQtdVendida() {
		return qtdVendida;
	}

	public void setQtdVendida(Double qtdVendida) {
		
		this.qtdVendida = qtdVendida;
		this.baixarEstoque(qtdVendida);
	}
	
	private void baixarEstoque(Double qtdVendida) {
		
		if((this.getProduto().getQtdEstoque()-qtdVendida) > 0) {
			this.produto.setQtdEstoque(this.produto.getQtdEstoque() - qtdVendida);
		}else {
			this.qtdVendida = this.produto.getQtdEstoque();
			this.produto.setQtdEstoque(this.produto.getQtdEstoque() - this.qtdVendida);
		}
		
	}

	
	public Double getSubTotal() {
		return this.qtdVendida * this.produto.getPreco();
	}
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
	
	

}
