import java.io.*;
import java.util.ArrayList;

// Clase para leer el archivo que se nos da mediante la ruta dada
public class LeerArchivotxt{

  ArrayList<Tarea> tareas = new ArrayList();

  public ArrayList<Tarea> transform(String nombre){

    try {
        BufferedReader archivoLeer = new BufferedReader(new FileReader(nombre));
        String lineaLeida;

        System.out.println("---------------------");
        System.out.println("Leyendo el Archivo...");
        System.out.println("---------------------");
        System.out.println("");

        while((lineaLeida = archivoLeer.readLine()) != null){
          String[] tarea = new String[4];
          tarea = lineaLeida.split(",");
          tareas.add(new Tarea(tarea));
        }
      }

      catch (FileNotFoundException e){
        System.out.println("No se encontro el archivo");
        System.out.println(e.getMessage());
      }
      catch(Exception e){
        System.out.println("Error de lectura del archivo");
        System.out.println(e.getMessage());
      }
      return tareas;
  }
}
