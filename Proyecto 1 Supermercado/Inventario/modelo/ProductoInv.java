package modelo;

public class ProductoInv {
	private String nombre;
	private float precio;
	private String marca;
	private float cantidad;
	private	int	codigobarras;
	private int unidades;
	private String unidadmed;
	private	boolean refrigerado;
	private boolean congelado;
	
	public ProductoInv(int precio, String marca, float cantidad, int codigobarras, int unidades, String nombre, String unidadmed, boolean refrigerado,  boolean congelado) {
		this.precio = precio;
		this.marca = marca;
		this.cantidad = cantidad;
		this.codigobarras = codigobarras;
		this.unidades = unidades;
		this.nombre = nombre;
		this.unidadmed = unidadmed;
		this.congelado = congelado;
		this.refrigerado = refrigerado;
	}
	
	
	@Override
	public String toString() {
		return "ProductoInv [nombre=" + nombre + ", precio=" + precio + ", marca=" + marca + ", cantidad=" + cantidad
				+ ", codigobarras=" + codigobarras + ", unidades=" + unidades + ", unidadmed=" + unidadmed
				+ ", refrigerado=" + refrigerado + ", congelado=" + congelado + "]";
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}


	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}


	public boolean isCongelado() {
		return congelado;
	}


	public void setCongelado(boolean congelado) {
		this.congelado = congelado;
	}


	public String getUnidadmed() {
		return unidadmed;
	}


	public void setUnidadmed(String unidadmed) {
		this.unidadmed = unidadmed;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public int getCodigobarras() {
		return codigobarras;
	}
	public void setCodigobarras(int codigobarras) {
		this.codigobarras = codigobarras;
	}
	
}
