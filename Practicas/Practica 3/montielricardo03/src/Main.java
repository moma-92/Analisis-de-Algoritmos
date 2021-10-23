import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main{

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int opcion = -1;
    boolean sigue;

    System.out.println("¡HOLA!");
    do{
      try{
        sigue = false;
        System.out.println("Ingresa un numero entre 1 y 20 para definir el tamaño del arreglo");
        opcion = sc.nextInt();
        if(opcion < 0){
          System.out.println("El numero ingresado no puede ser negativo");
          System.out.println("Ingresa de nuevo un numero");
          sigue = true;
        }else if(opcion == 0){
          System.out.println("El numero ingresado no puede ser 0");
          System.out.println("Ingresa de nuevo un numero");
          sigue = true;
        }else if(opcion > 20){
          System.out.println("El numero ingresado no puede ser mayor a 20");
          System.out.println("Ingresa de nuevo un numero");
          sigue = true;
        }
      }catch(InputMismatchException e) {
        System.out.println("Favor de ingresar un valor numerico entero");
        sc.next();
        sigue = true;
      }
    }while(sigue);

    int[] b = new int[opcion];
    b = ConstructorArreglo(opcion*50);
    int m = Clave(b);
    System.out.println("La clave pseudoaleatoria que seria el peor de los casos es: " + m);
    int l = ExponentialSearch(b, m);
    if(l == -1){
      System.out.println("La clave no se encuentra en el arreglo");
    }else{
      System.out.println("La clave se encuentra en la posicion " + l + " del arreglo");
    }
  }

  // Algoritmo BusquedaBinaria
  public static int BusquedaBinaria(int[] arr, int low, int high, int key){
    if(low > high){
      return -1;
    }else{
      int mid = low + high / 2;
      if(arr[mid] == key){
        return mid;
      }else if(arr[mid] > key){
        return BusquedaBinaria(arr, key, low, mid-1);
      }else{
        return BusquedaBinaria(arr, key, mid+1, high);
      }
    }
  }

  // Algoritmo Busqueda Exponencial
  public static int ExponentialSearch(int[] arr, int key){
    int n = arr.length-1;
    int inf = 0;
    int sup = 1;
    int claveExtremo;

    while(sup <= n){
      claveExtremo = arr[sup];
      if(key == claveExtremo){
        return sup;
      }else if(key < claveExtremo){
        return BusquedaBinaria(arr, key, inf, sup-1);
      }else{
        if(sup == n){
          return -1;
        }else{
          inf = sup;
          sup = sup*2;
        }
      }
    }
    return BusquedaBinaria(arr, key, inf, n);
  }

  // Constructor para los arreglos
  public static int[] ConstructorArreglo(int n) {

    String nombreA = "Archivo.txt";
    int[] arreglo;
    arreglo = new int[n];
    String[] str = new String[arreglo.length];
    arreglo[0] = (int) (Math.random()*5)+1;

    for (int i = 1; i < n; i++){
      arreglo[i] = (int) (Math.random()*5) + arreglo[i-1];
      str[i] = String.valueOf(arreglo[i]);
    }
    try {
      File file = new File(nombreA);
      if (file.createNewFile()) {
        System.out.println("El arreglo se guardo en el archivo: " + file.getName());
      }else{
        System.out.println("Se sobreescribira el archivo que tiene el mismo nombre");
      }
    }catch (Exception e) {
      e.printStackTrace();
    }
    try{
      FileWriter writer = new FileWriter(nombreA);
      for (int j = 0; j < n; j++) {
        str[j] = String.valueOf(arreglo[j]);
        writer.write(str[j] + '\n');
      }
      writer.close();
      System.out.println("Se guardo con exito el arreglo en el Archivo");
    }catch(Exception e){
      e.printStackTrace();
    }
    return arreglo;
  }

  //Generamos la clave pseudoaleatoria
  public static int Clave(int[] arr){
    return (arr[arr.length-2] + (int) (Math.random()*5));
  }
}
