package modelo;

import java.util.ArrayList;

public class SistemaPOS {
	private Cajero cajero;
	private Caja caja;
	private ArrayList<Cliente> cliente;
	private ArrayList<Factura> factura;
	private ArrayList<Producto> producto;

	public SistemaPOS() {
		this.cajero= new Cajero(this);
		this.caja = new Caja();
		this.cliente = new ArrayList<Cliente>();
		this.factura = new ArrayList<Factura>();
		this.producto = new ArrayList<Producto>();
	}

	public Cliente encontrarCliente(int cedula) {
		for (int i=0; i<cliente.size(); i++) {
			if (cliente.get(i).getCedula() == cedula) {
				return cliente.get(i);
			}
		}
		System.out.println("No se encontro el cliente, registrese, se usara el cliente invitado");
		return new Cliente(cedula, null, cedula, null, null, null, null);
	}

	public void registrarVenta(double valortotal) {
		caja.ingresarVenta(valortotal);		
	}
	public void agregarFactura(Factura factura) {
		this.factura.add(factura);
	}
	public Producto encontrarProductoAVender(int idproducto) {
		Producto rta = null;
		for (int i=0; i<producto.size(); i++) {
			if (producto.get(i).getIdproducto() == idproducto && producto.get(i).getDisponibles()>0) {
				rta =  producto.get(i);
			}
		}
		return rta;
	}
	public Producto encontrarProductoAElminar(int idproducto) {
		Producto rta = null;
		for (int i=0; i<producto.size(); i++) {
			if (producto.get(i).getIdproducto() == idproducto) {
				rta =  producto.get(i);
			}
		}
		return rta;
		
	}
	public void agregarClienteNuevo(int cedula, String nombre, int telefono, String email, String sexo, String estadocivil, String situalab) {
		boolean presente = false;
		for (Cliente clientes:cliente) {
			if(clientes.getCedula() == cedula){
				presente = true;
				break;
			}
		}
		if(presente== false) {
			Cliente usuario = new Cliente(cedula, nombre, telefono, email, sexo, estadocivil, situalab);
			this.cliente.add(usuario);
		}
		else{
			System.out.println("El cliente ya se encuentra registrado");
		}
	}
	
	public void agregarProducto(Producto producto) {
		this.producto.add(producto);
	}
	
	
	public void iniciarCompra(int cedula) {
		cajero.iniciarCompra(cedula);
	}
	public void finalizarCompra() {
		cajero.finalizarCompra();
	}
	public void agregarProductoCompra(int idproducto) {
		cajero.agregarProductoCompra(idproducto);
	}
	
	public void agregarProductosPeso(int idproducto, float peso) {
		cajero.agregarProductosPeso(idproducto, peso);
	}
	
	public void eliminarProductosPeso(int idproducto, float peso) {
		cajero.eliminarProductosPeso(idproducto, peso);
	}
	public void elimiarProductoCompra(int idproducto) {
		cajero.elimiarProductoCompra(idproducto);
	}


	
	
	

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public ArrayList<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(ArrayList<Cliente> cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Factura> getFactura() {
		return factura;
	}

	public void setFactura(ArrayList<Factura> factura) {
		this.factura = factura;
	}

	public ArrayList<Producto> getProducto() {
		return producto;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}
	
}
