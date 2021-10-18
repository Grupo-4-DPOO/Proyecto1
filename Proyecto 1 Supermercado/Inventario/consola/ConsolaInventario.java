package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Inventario;

public class ConsolaInventario {
	private Inventario inventario;

	public ConsolaInventario() throws IOException {
		inventario = new Inventario();
		ejecutarOpcion();
	}

	public void ejecutarOpcion() throws IOException 
	{
		System.out.println("Bienvenido al Inventario ");
		Scanner reader = new Scanner(System.in);

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();

				System.out.println("Por favor, elija una opci�n");
				int opcion_seleccionada = reader.nextInt();
				reader.nextLine();
				if (opcion_seleccionada == 1)
				{
					System.out.println("ingrese la ruta del archivo: ");
					String ruta1 = reader.nextLine();
					inventario.cargarproductos(ruta1);


				}
				else if (opcion_seleccionada == 2)
				{
					inventario.exportarproductos();
				}
				else if (opcion_seleccionada == 3)
				{
					System.out.println("ingrese el id del producto: ");
					String rta = reader.nextLine();
					int rut2 = Integer.parseInt(rta);
					System.out.println(inventario.consultarproducto(rut2));
				}	
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public static void main(String[] args) throws IOException 
	{
		ConsolaInventario  consola = new ConsolaInventario();
		System.out.println("Inicio de ejecuci�n de la aplicaci�n");
	}

	public void mostrarMenu()
	{	
		System.out.println("\nOpciones de la aplicaci�n\n");
		System.out.println("1. Cargar lote");
		System.out.println("2. Exportar Lote");
		System.out.println("3.  Consultar producto");
		System.out.println("0.  Salir");

	}
}
