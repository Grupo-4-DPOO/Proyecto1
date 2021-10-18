package modelo;

public class Lote {
	private String fechavencimiento;
	private	float preciocompra;
	private	float precioventa;
	private	int	unidades;
	private ProductoInv productos;
	
	public Lote(String fechavencimiento, float preciocompra, int unidades, float precioventa, ProductoInv productos) {
		this.fechavencimiento = fechavencimiento;
		this.preciocompra = preciocompra;
		this.precioventa = precioventa;
		this.unidades = unidades;
		this.productos = productos;
		agregarProductos();
	}
	
	//public void AgregarproductoAlmacenadio() {
	//	this.precioc	
	
	public void agregarProductos() {
		productos.setPrecio(precioventa);
		int actual= productos.getUnidades();
		productos.setUnidades(actual+unidades);
	}
	
	public String getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(String fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	public float getPreciocompra() {
		return preciocompra;
	}
	public void setPreciocompra(float preciocompra) {
		this.preciocompra = preciocompra;
	}
	public float getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(float precioventa) {
		this.precioventa = precioventa;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
}
