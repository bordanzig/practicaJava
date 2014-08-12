package BordanziGonzalo.PracticaJava;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UserCom {

	private static CSVManage manager;
	
	public static void procesarConsulta (String[] arr){
		CSVQuery consulta = new CSVQuery(arr);
		Integer clicks = manager.getKeyValue(consulta.getParametersC());
		Integer prints = manager.getKeyValue(consulta.getParametersP());
		
		System.out.print("La cantidad de clicks es: " + clicks + "\n");
		System.out.print("La cantidad de prints es: " + prints + "\n");
	}
	
	private static void realizarConsulta(Scanner scanner) {
		System.out.print("Ingrese los valores de consulta, separados por coma, de la siguiente manera:\n");
		System.out.print("ad_placement,format_iab,gender,age,scholarity,marital,income,connection,browser,so,interests_id,type\n");
		String consulta;
		consulta=scanner.next();
		
		String[] attr = consulta.split(",");
		if (attr.length != 11){
			System.out.print("Error en el ingreso de datos");
		}
		else {
			procesarConsulta(attr);
		}
	}
	
	private static void parsearArchivoCSV(Scanner teclado) {
		// TODO Auto-generated method stub
		String outputFile;
		System.out.print("Ingrese el nombre del archivo de salida CSV \n");
		outputFile = teclado.next();
		try{
			manager.generateCSV(outputFile);
		}catch(IOException io) {
			System.out.print("Se encontro una exepcion de IO\n");
		}
		
	}
	
	
	
	/*
	 * MAIN 
	 */
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		int a = 0;
		
		while (a==0){
			System.out.print("Ingrese la ruta del archivo CSV con los datos: \n");
			String file;
			file = teclado.next();
		
			manager = new CSVManage(file);
			try{
				manager.parseCSV();
				a = 1;
			}
			catch(IOException io) {
				System.out.print("Se encontro una exepcion de IO, la ruta del archivo es incorrecta\n");
				a = 0;
			}
		}
		
		try {
			mongoManage mongoBase = new mongoManage("mydb");
			manager.exportToMongo(mongoBase);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		

		a=1;
		String ingreso;
		while (a != 0){
			System.out.print("Ingrese 1 si desea realizar una consulta \n2 Para generar un archivo de salida \nCualquier tecla para salir \n");
			ingreso = teclado.next();
			try{
				a = Integer.parseInt(ingreso);
			}catch(NumberFormatException e){
				a=0;
			}
			if (a==1){
				realizarConsulta(teclado);
			}else{
				if (a==2){
					parsearArchivoCSV(teclado);
				}
				else{
					a=0;
				}
			}
		System.out.print("Saliendo del programa. muchas gracias.");
		
		}
	}


}
