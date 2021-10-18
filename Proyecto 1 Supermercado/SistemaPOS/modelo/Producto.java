package modelo;

public class Producto {
	private String nombre;
	private float precio;
	private float cantidad;
	private int idproducto;
	private String marca;
	private String unidadmed;
	private float preciounidad;
	private String categoria;
	private boolean congelado;
	private boolean refrigerado;
	private int disponibles;
	
	
	public Producto(String nombre,float precio, float cantidad, int idproducto, String marca, String unidadmed, boolean congelado, boolean refrigerado,  int disponibles) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.idproducto = idproducto;
		this.marca = marca;
		this.unidadmed = unidadmed;
		this.preciounidad = this.precio/this.cantidad;
		this.categoria = "";
		this.congelado = congelado;
		this.refrigerado = refrigerado;
		this.disponibles = disponibles;
	}
	
	
	public void agregardisponibles() {
		disponibles+=1;
	}
	
	public void eliminardisponibles() {
		disponibles-=1;
	}
	
	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public boolean isCongelado() {
		return congelado;
	}




	public void setCongelado(boolean congelado) {
		this.congelado = congelado;
	}




	public boolean isRefrigerado() {
		return refrigerado;
	}




	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}




	public int getDisponibles() {
		return disponibles;
	}




	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}




	public void agregarCategoria(String nombre) {
		categoria+=nombre + " , ";
		
	}
	public float getPreciounidad() {
		return preciounidad;
	}



	public void setPreciounidad(float preciounidad) {
		this.preciounidad = preciounidad;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	
}
