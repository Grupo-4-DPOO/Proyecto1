package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Inventario {
	private ArrayList<Lote> lote;
	private ArrayList<ProductoInv> producto;

	public Inventario() {
		this.lote = new ArrayList<Lote>();
		this.producto = new ArrayList<ProductoInv>();
	}
	
	public String consultarproducto(int idproducto) {
		String rta = "Producto no encontrado";
		for(int i= 0;i<producto.size();i++) {
			if(producto.get(i).getCodigobarras() == idproducto) {
				rta =  producto.get(i).toString();
			}
		}
		return rta;
	}
	public void cargarproductos(String archivoProductos) throws IOException
	{
		// "Abrir" el archivo de Ingredientes y leerlo linea por linea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader (archivoProductos));
		String linea = br.readLine();   // Leer la linea con el primer ProductoMenu en el archivo   
		// Un ProductoMenu tiene la forma: nombre;precioBase
		while (linea != null) // Cuando se llegue al final del archivo, linea tendra el valor null
		{
			// Separar los valores que estan en la linea por el caracter ';'
			String[] partes = linea.split(";");
			ProductoInv encontrado = null;
			for(ProductoInv productos: producto) {
				if (productos.getCodigobarras() == Integer.parseInt(partes[4])) {
					encontrado = productos;
					break;
				}
			}
			if ( encontrado == null) 
			{
				

				// si es almacenado o si es fresco
				if(partes[0].equals("almacenado")) {
					//int precio, String marca, float cantidad, int codigobarras, int unidades, String nombre, String unidadmed, boolean refrigerado,  boolean congelado)
					int precio = Integer.parseInt(partes[1]);
					String marca = partes[2];
					float cantidad = Float.parseFloat(partes[3]);
					int codigobarras = Integer.parseInt(partes[4]);
					int unidades = Integer.parseInt(partes[5]);
					String nombre = partes[6];
					String unidadmed = partes[7];

					if(partes[10].equals("noempacado")) {
						ProductosAlmacenados productoa = new ProductosAlmacenados(precio, marca, cantidad, codigobarras, 0, nombre, unidadmed);
						encontrado = productoa;
					}
					else {
						ProductosAlmacenados productoa = new ProductosAlmacenados(precio, marca, cantidad, codigobarras, precio, 0, nombre, unidadmed);
						encontrado = productoa;
					}
				}
				else {
					//int precio, String marca, float cantidad, int codigobarras, int unidades, String nombre, String unidadmed, boolean refrigerado,  boolean congelado)
					int precio = Integer.parseInt(partes[1]);
					String marca = partes[2];
					float cantidad = Float.parseFloat(partes[3]);
					int codigobarras = Integer.parseInt(partes[4]);
					int unidades = Integer.parseInt(partes[5]);
					String nombre = partes[6];
					String unidadmed = partes[7];
					boolean refrigerado = false;
					boolean congelado = false;
					if(partes[8].equals("true")) {
						refrigerado = true;
					}
					if(partes[9].equals("true")) {
						congelado = true;
					}

					if(partes[10].equals("noempacado")) {
						ProductosFrescos productoa = new ProductosFrescos(precio, marca, cantidad, codigobarras, refrigerado, congelado, 0, nombre, unidadmed);
						encontrado = productoa;
					}
					else {
						ProductosFrescos productoa = new ProductosFrescos(precio, marca, cantidad, codigobarras, refrigerado, congelado, precio,  0, nombre, unidadmed);
						encontrado = productoa;
					}
				}
				producto.add(encontrado);
			}
			//String fechavencimiento, float preciocompra, int unidades, float precioventa, ProductoInv productos
			String fechavencimiento = partes[11];
			float preciocompra = Float.parseFloat(partes[12]);
			int unidades = Integer.parseInt(partes[13]);
			float precioventa = Float.parseFloat(partes[1]);
			System.out.println("entro");
			Lote loten= new Lote(fechavencimiento, preciocompra, unidades, precioventa, encontrado);
			lote.add(loten);			
			linea = br.readLine(); // leer la proxima linea en el archivo con un nuevo ProductoMenu 
		}

		br.close();
	}
	public void exportarproductos() throws IOException {
		String ruta = "Data/archivoPOS.csv";
		FileWriter  writer = new FileWriter(ruta);
		for (ProductoInv productos: producto) {
			//String nombre,float precio, float cantidad, int idproducto, String marca, String unidadmed, boolean congelado, boolean refrigerado,  int disponibles
			String nombre = productos.getNombre()+";";
			String precio = Float.toString(productos.getPrecio())+";";
			System.out.println(precio);
			String cantidad = Float.toString(productos.getCantidad())+";";
			String idproducto = Integer.toString(productos.getCodigobarras())+";";
			String marca = productos.getMarca()+";";
			String unidadmed = productos.getUnidadmed()+";";
			String congelado = "false;";
			String refrigerado = "false;";
			if(productos.isCongelado() == true){
				congelado = "true;";
			}
			if(productos.isRefrigerado() == true){
				refrigerado = "true;";
			}
			String unidades = Integer.toString(productos.getUnidades())+";";
			String rta = nombre + precio + cantidad + idproducto + marca + unidadmed + congelado + refrigerado + unidades;
			writer.append(rta);
		}
		writer.flush();
		writer.close();
	}
}
