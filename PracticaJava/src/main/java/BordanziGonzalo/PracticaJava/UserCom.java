package BordanziGonzalo.PracticaJava;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UserCom {

	private static CSVManage csvManager;
	private static fileManage fileManager;

	
	private static void parsearArchivoCSV(Scanner teclado) {
		// TODO Auto-generated method stub
		String outputFile;
		System.out.print("Ingrese el nombre del archivo de salida CSV \n");
		outputFile = teclado.next();
		try{
			csvManager.generateCSV(outputFile);
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
			csvManager = new CSVManage();
			fileManager = new fileManage();
			try {
				csvManager.parseCSV(fileManager,file);
				a = 1;
			} catch (IOException e) {
				e.printStackTrace();
				System.out.print("Se encontro una exepcion de IO, la ruta del archivo es incorrecta\n");
				a = 0;
			}
				
		}
		
		try {
			mongoManage mongoBase = new mongoManage("mydb");
			csvManager.exportToMongo(mongoBase);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		

		a=1;
		String ingreso;
		System.out.print("Presione 1 para continuar\n");
		ingreso = teclado.next();
		try{
			a = Integer.parseInt(ingreso);
		}catch(NumberFormatException e){
			a=0;
		}
		if (a==1){
			parsearArchivoCSV(teclado);
		}
		System.out.print("Saliendo del programa. muchas gracias.");
		
	}


}
;