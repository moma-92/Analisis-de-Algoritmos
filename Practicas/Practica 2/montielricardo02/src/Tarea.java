// Clase para obetener las description, identificador, start y end del programa
public class Tarea{

  private String descripcion = "";
  private String identificador = "";
  private int start;
  private int end;

  public Tarea(String[] s){
    descripcion = s[0];
    identificador = s[1];
    start = Integer.parseInt(s[2]);
    end = Integer.parseInt(s[3]);
  }

  public String getDescripcion(){
    return descripcion;
  }

  public String getIdentificador(){
    return identificador;
  }

  public int getStart(){
    return start;
  }

  public int getEnd(){
    return end;
  }

  public String toString(){
    return "["  + descripcion + ", " + identificador + ", " + start + ", " + end + "]";
  }
}
