import java.util.ArrayList;
import java.util.Scanner;

public class Main{
  public static ArrayList<ArrayList<Tarea>> SCH = new ArrayList<ArrayList<Tarea>>();
  public static LeerArchivo a = new LeerArchivo();

  public static void main(String[] args) {

    String archivo = "";
    Scanner sc = new Scanner(System.in);

    System.out.println("Hola");
    System.out.println("Ingresa la ruta del archivo como es especificado el README, sin espacion vacios:");
    archivo = sc.next();

    //Inicio del Algoritmo
    ArrayList <Tarea> WAIT = new ArrayList(a.transform(archivo));
    Tarea t;
    int min = -1;
    boolean asignado;

    while(!WAIT.isEmpty()){
      ArrayList<Tarea> ti = new ArrayList();
      t = WAIT.get(0);
      WAIT.remove(0);
      asignado = false;

      for(int j = 0; j <= min; j++){
        boolean cumple = true;
        for (int k = 0; k < SCH.get(j).size(); k++){
          if(SCH.get(j).get(k).getEnd() <= t.getStart() || t.getEnd() <= SCH.get(j).get(k).getStart()){
            SCH.get(j).add(t);
            asignado = true;
            break;
          }
        }
        if(asignado == true){
          break;
        }
      }
      if(asignado == false){
        min = min + 1;
        ti.add(t);
        SCH.add(ti);
      }
    }

    //Imprimimos el resultado del Algoritmo por la terminal
    for (int m = 0; m < SCH.size(); m++){
      for (int l = 0; l < SCH.get(m).size(); l++){
        System.out.println(SCH.get(m).get(l).toString());
      }
      System.out.println(" ");
    }

    //Despedida con el usuario, confirmamos que fue exitoso el programa
    System.out.println("-----------------------------");
    System.out.println("!Terminamos! Nos vemos luego.");
    System.out.println("-----------------------------");
  }
}
