package modelo;

import java.util.ArrayList;

public class Cajero {
	private SistemaPOS sistema;
	private Compra compra;
	private Cliente cliente;
	
	public Cajero (SistemaPOS sistema) {
		this.cliente = null;
		this.compra = null;
		this.sistema = sistema;
	}
	public void iniciarCompra(int cedula) {
		compra = new Compra(cedula);
		cliente = sistema.encontrarCliente(cedula);		
	}
	public void finalizarCompra() {
		Factura factura = new Factura(compra.getProductos().size(), compra.getValortotal(), compra.getPuntosacum(), compra.getIdcliente(), compra.getProductos());
	cliente.agregarFactura(factura);
	cliente.SumarPuntos(compra.getPuntosacum());
	sistema.agregarFactura(factura);
	sistema.registrarVenta(compra.getValortotal());
	this.cliente = null;
	this.compra = null;
	System.out.println(factura.getResumen());
	}
	public void agregarProductoCompra(int idproducto) {
		Producto elemento = sistema.encontrarProductoAVender(idproducto);
		if (elemento != null) {
			compra.agregarProducto(elemento);
			elemento.eliminardisponibles();
		}
	}
	
	public void agregarProductosPeso(int idproducto, float peso) {
		Producto elemento = sistema.encontrarProductoAVender(idproducto);
		if (elemento != null) {
			compra.agregarProductoPeso(elemento, peso);
			elemento.eliminardisponibles();
		}	
	}
	
	public void eliminarProductosPeso(int idproducto, float peso) {
		Producto elemento = sistema.encontrarProductoAVender(idproducto);
		if (elemento != null) {
			boolean rta = compra.eliminarProductoPeso(elemento, peso);
			if (rta == true) {
				elemento.eliminardisponibles();
			}
		}	
	}
	public void elimiarProductoCompra(int idproducto) {
		Producto elemento = sistema. encontrarProductoAElminar(idproducto);
		if (elemento != null) {
			boolean rta = compra.eliminarProducto(elemento);
			if (rta == true) {
			elemento.agregardisponibles();
			}
		}
	}
}
