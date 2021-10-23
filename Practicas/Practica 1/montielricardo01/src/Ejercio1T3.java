/**
 * Para compilar el programa debemos de estar dentro de la carpeta montielricardo03,
 * es decir a la altura de la carpteta src y de nuestro build
 * ahi abriremos la terminal y ejecutaremos el comando "ant run".
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class Ejercio1T3{

	public static void main(String[] args) {
		
		// Creamos el Scanner	
		Scanner obtenerNumero = new Scanner(System.in);
		// Variable que introducira el usuario
		int numero;
		// Variable que regresaremos cuando se realice la operacion en el for
		double resultado = 0;
		// Boolean para que no termine el programa hasta que sea admitido un valor numerico
		boolean sigue;

		do{
			try{
				sigue = false;
				System.out.println("Ingresa un numero: ");
  				numero = obtenerNumero.nextInt();

  				if(numero < 0){
  					System.out.println("El numero no puede ser negativo");
  					sigue = true;
  				}else{
  					// Se realiza la operacion solicitada de la tarea
  					for (int i = 0; i <= numero ; i++) {
					resultado = resultado + (Math.pow(2 , i));
					}
					// Imprimimos el resultado de la operacion
					System.out.println("El resultado de la operacion es: " + resultado);
				}				
			}
			//Utilizamos la Exepcion InputMismatchException para que no sean adminitad cadenas, solo numeros
			catch(InputMismatchException e){
				System.out.println("Favor de ingresar un valor numerico entero");
				obtenerNumero.next();
				sigue = true;
			}
		}while(sigue);
	}
}