import java.util.Set;
import java.util.ArrayList;

/******************************************************************
interfa.java
Autor: Carol Arevalo y Jose Miguel Gonzalez
Última modificación: xxx

interfaz   
******************************************************************/

public interface InterfaceHash{

    public abstract void crear(String tipo, ArrayList<String> lista);
    public abstract void agregar(String tipo, String agregado);
    public abstract void quitar(String tipo, String quita);
    public abstract void remplazar(String remplaza, String nuevoValor);
    public abstract int contar(String tipo);
    public abstract String buscar(String Ryan);
    public abstract void recorrerTipo(); //muestralos productos por categoria 
    public abstract void recorrer(); //muestra los porductos en el orden en que fueron agregados
    public abstract Set keySeto();
    public abstract String GivoKey(String peticion);

}