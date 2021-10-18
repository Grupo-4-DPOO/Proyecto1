package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Producto;
import modelo.SistemaPOS;

public class ConsolaPOS {
	private SistemaPOS sistema;
	
	public ConsolaPOS() throws IOException {
		sistema = new SistemaPOS();
		ejecutarOpcion();
	}
	
	public void ejecutarOpcion() throws IOException 
	{
		System.out.println("Bienvenido al Supermercado ");
		Scanner reader = new Scanner(System.in);

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				
				System.out.println("Por favor, elija una opción");
				int opcion_seleccionada = reader.nextInt();
				reader.nextLine();
				if (opcion_seleccionada == 1)
				{
					//Funcion Cargar Datos
					System.out.println("ingrese la ruta del archivo: ");
					String ruta1 = reader.nextLine();
					cargarproductos(ruta1);
					
					
				}
				else if (opcion_seleccionada == 2)
				{
					//iniciar Compra
					System.out.println("ingrese la cedula: ");
					String ruta1 = reader.nextLine();
					int cedula = Integer.parseInt(ruta1);
					sistema.iniciarCompra(cedula);
				}
				else if (opcion_seleccionada == 3)
				{
					//Agregar Producto
					System.out.println("ingrese id producto: ");
					String ruta1 = reader.nextLine();
					int id = Integer.parseInt(ruta1);
					sistema.agregarProductoCompra(id);
				}
				else if (opcion_seleccionada == 4)
				{
					//Agregar Producto por peso
					System.out.println("ingrese id producto: ");
					String ruta1 = reader.nextLine();
					int id = Integer.parseInt(ruta1);
					System.out.println("ingrese el peso del producto: ");
					String ruta2 = reader.nextLine();
					int peso = Integer.parseInt(ruta2);
					sistema.agregarProductosPeso(id, peso);
				}
				else if (opcion_seleccionada == 5)
				{
					//Eliminar producto del carrito
					System.out.println("ingrese id producto: ");
					String ruta1 = reader.nextLine();
					int id = Integer.parseInt(ruta1);
					sistema.elimiarProductoCompra(id);
				}
				
				else if (opcion_seleccionada == 6)
				{
					//Eliminar produto del carrito por peso
					System.out.println("ingrese id producto: ");
					String ruta1 = reader.nextLine();
					int id = Integer.parseInt(ruta1);
					System.out.println("ingrese peso del producto: ");
					String ruta2 = reader.nextLine();
					int peso = Integer.parseInt(ruta2);
					sistema.eliminarProductosPeso(id, peso);
				}	
				
				else if (opcion_seleccionada == 7)
				{
					//Finalizar compra
					sistema.finalizarCompra();
				}
				else if (opcion_seleccionada == 8)
				{
					//Agregar nuevo cliente" int cedula, String nombre, int telefono, String email, String sexo, String estadocivil, String situalab
					System.out.println("ingrese cedula: ");
					String ruta1 = reader.nextLine();
					int cedula = Integer.parseInt(ruta1);
					System.out.println("ingrese nombre: ");
					String nombre = reader.nextLine();
					System.out.println("ingrese el telefonoo: ");
					String ruta2 = reader.nextLine();
					int telefono = Integer.parseInt(ruta2);
					System.out.println("ingrese email: ");
					String email = reader.nextLine();
					System.out.println("ingrese el sexo: ");
					String sexo = reader.nextLine();;
					System.out.println("ingrese el estadocivil: ");
					String estadocivil = reader.nextLine();
					System.out.println("ingrese el estado laboral: ");
					String situalab = reader.nextLine();
					sistema.agregarClienteNuevo(cedula, nombre, telefono, email, sexo, estadocivil, situalab);
					
				}
				else
				{
					System.out.println("Por favor seleccione una opciÃ³n vÃ¡lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los nÃºmeros de las opciones.");
			}
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		ConsolaPOS  consola = new ConsolaPOS();
		System.out.println("Inicio de ejecución de la aplicación");
	}
	
	public void mostrarMenu()
	{	
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar");
		System.out.println("2. iniciar Compra");
		System.out.println("3. Agregar Producto");
		System.out.println("4. Agregar Producto por peso");
		System.out.println("5. Eliminar producto del carrito");
		System.out.println("6. Eliminar produto del carrito por peso");
		System.out.println("7. Finalizar compra");
		System.out.println("8. Agregar nuevo cliente");
	}
	
	public void cargarproductos(String archivoProductos) throws IOException
	{
		ArrayList<Producto> productos = new ArrayList<Producto>();
		// "Abrir" el archivo de Ingredientes y leerlo linea por linea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader (archivoProductos));
		String linea = br.readLine();   // Leer la linea con el primer ProductoMenu en el archivo   
		// Un ProductoMenu tiene la forma: nombre;precioBase
		while (linea != null) // Cuando se llegue al final del archivo, linea tendra el valor null
		{
			// Separar los valores que estan en la linea por el caracter ';'
			String[] partes = linea.split(";");
			boolean booleancongelado = false;
			boolean booleanrefrigerado = false;
			if (partes[6]=="true") {
				booleancongelado = true;
			}
			if (partes[7]=="true") {
				booleanrefrigerado = true;
			}
			Producto nuevoproducto = new Producto(partes[0], Float.parseFloat(partes[1]), Float.parseFloat(partes[2]), Integer.parseInt(partes[3]), partes[4], partes[5], booleancongelado,  booleanrefrigerado, Integer.parseInt(partes[8]));   // Creacion de un objeto ingredientesu con su nombre y precio base
			sistema.agregarProducto(nuevoproducto);

			linea = br.readLine(); // leer la proxima linea en el archivo con un nuevo ProductoMenu 
		}

		br.close();
	}

}
