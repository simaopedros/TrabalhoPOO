import java.util.UUID;

import enums.UnidadeMedida;
import fatec.poo.model.Cliente;
import fatec.poo.model.ItemPedido;
import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;
import utils.DateUtil;

public class Aplic {
	
	public static void main(String[] args) {
		//=====================================================================
		Vendedor v1 = new Vendedor("123456789", "Jos� Maria Trindade", 1200.00);
		v1.setTaxaComissao(0.05);
		Vendedor v2 = new Vendedor("123456710", "Ana Paula Padr�o", 1500.00);
		v2.setTaxaComissao(0.05);
		Vendedor v3 = new Vendedor("123456711", "Willian Bonner", 1350.00);
		v3.setTaxaComissao(0.05);
		//=====================================================================
		Cliente c1 = new Cliente("111111111", "Maria Joaquina", 5000.00);
		Cliente c2 = new Cliente("222222222", "Isadora Pereira", 5000.00);
		Cliente c3 = new Cliente("333333333", "Carmem L�cia", 5000.00);
		//=====================================================================
		Produto p1 = new Produto(UUID.randomUUID().toString(), "Macarr�o");
		p1.setUnidadeMedida(UnidadeMedida.UNIDADE);
		p1.setPreco(1.25);
		p1.setQtdEstoque(150.0);
		System.out.println(">> P1 Quantidade Estoque. "+p1.getQtdEstoque());
		//=====================================================================
		Produto p2 = new Produto(UUID.randomUUID().toString(), "Feij�o Tio Jo�o");
		p2.setUnidadeMedida(UnidadeMedida.QUILO);
		p2.setPreco(240.0);
		p2.setQtdEstoque(20.0);
		//=====================================================================		
		Produto p3 = new Produto(UUID.randomUUID().toString(), "A�ucar Mascavo");
		p3.setUnidadeMedida(UnidadeMedida.QUILO);
		p3.setPreco(10.40);
		p3.setQtdEstoque(320.0);
		//=====================================================================		
		Pedido ped1 = new Pedido(UUID.randomUUID().toString(), DateUtil.getDateTime());
		ped1.setCliente(c1);
		ped1.setVendedor(v1);		
		ped1.addItem(new ItemPedido(1, 2.0, p1));
		ped1.addItem(new ItemPedido(2, 10.0, p2));
		ped1.addItem(new ItemPedido(3, 15.0, p3));
		
		
		System.out.println(">> P1 Limite Cred. "+ped1.getCliente().getLimitCred());
		System.out.println(">> P1 Limite Disp. "+ped1.getCliente().getLimitDisp());
		System.out.println(">> P1 Quantidade Estoque. "+p1.getQtdEstoque());
		
		
		//=====================================================================
		
		Pedido ped2 = new Pedido(UUID.randomUUID().toString(), DateUtil.getDateTime());
		ped2.setCliente(c2);
		ped2.setVendedor(v2);		
		ped2.addItem(new ItemPedido(1, 5.0, p1));
		ped2.addItem(new ItemPedido(2, 11.0, p2));
		ped2.addItem(new ItemPedido(3, 2.0, p3));
		
		
		System.out.println(">> P2 Limite Cred. "+ped2.getCliente().getLimitCred());
		System.out.println(">> P2 Limite Disp. "+ped2.getCliente().getLimitDisp());
		System.out.println(">> P2 Quantidade Estoque. "+p1.getQtdEstoque());
		
		
		//=====================================================================
		
		Pedido ped3 = new Pedido(UUID.randomUUID().toString(), DateUtil.getDateTime());
		ped3.setCliente(c3);
		ped3.setVendedor(v3);		
		ped3.addItem(new ItemPedido(1, 5.0, p1));
		ped3.addItem(new ItemPedido(2, 11.0, p2));
		ped3.addItem(new ItemPedido(3, 2.0, p3));
		
		
		System.out.println(">> P2 Limite Cred. "+ped3.getCliente().getLimitCred());
		System.out.println(">> P2 Limite Disp. "+ped3.getCliente().getLimitDisp());
		System.out.println(">> P2 Quantidade Estoque. "+p1.getQtdEstoque());
		
		
		// Calcuar comiss�es
		System.out.println("###### CALCULAR COMISS�ES ######");
		ped1.imprimirItemsPedido();
		ped1.printValorTotal();
		System.out.println("Comiss�o V1: "+v1.getCommissao());
		
		System.out.println();
		ped2.imprimirItemsPedido();
		ped2.printValorTotal();
		System.out.println("Comiss�o V2: "+v2.getCommissao());
		
		System.out.println();
		ped3.imprimirItemsPedido();
		ped3.printValorTotal();
		System.out.println("Comiss�o V3: "+v3.getCommissao());
		
		
		
	}

}
