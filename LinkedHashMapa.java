import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashMap;

class LinkedHashMapa extends AbstractoHash{
    
    LinkedHashMap<String, ArrayList<String>> map; 

    public void LinkedHashMapa(){
        map = new LinkedHashMap<String, ArrayList<String>>();

    }

    public void crear(String tipo, ArrayList<String> lista){
        map.put(tipo, lista);
    }

    public  void agregar(String tipo, String agregado){
        ArrayList temp = map.get(tipo);
        temp.add(agregado);
        map.replace(tipo, temp);
    }
    
    public  void quitar(String tipo, String quita){
        ArrayList temp = map.get(tipo);
        temp.remove(quita);
        map.replace(tipo, temp);
    }

    public  void remplazar(String remplaza, String NuevoValor){
        
        String llave = GivoKey(remplaza);

        ArrayList<String> contenido = map.get(llave);

        for(int i = 0; i < contenido.size()-1; i++){

            if(contenido.get(i).equals(remplaza) == true){

                contenido.set(i, NuevoValor);

            }

        }

    }

    public  int contar(String tipo){
        ArrayList temp = map.get(tipo);
        int x = temp.size();
        return x;
    }

    public String buscar(String Ryan){//Buscando al String Ryan (se ingresa el nombre y se regresa la categoria)

        String respuesta = "No se encontro";
        
        String clase = GivoKey(Ryan);

        if(!clase.equals(null) == true){

            respuesta = "La categoria es " + clase;

            return respuesta;

        }

        return respuesta;

    }

    public void recorrer(){

    }
    
    public void recorrerTipo(){
        
        Set<String> keys = map.keySet();

        ArrayList<String> contenido = new ArrayList<String>();

        for(String key: map.keySet()){
            
            contenido = map.get(key);

            for(int i = 0; i < contenido.size()-1; i++){

                System.out.println("Categoria: " + key + "\nProducto: " + contenido.get(i));

            }

        }
    }

    public Set<String> keySeto(){

        Set<String> keys = map.keySet();

        return keys;

    }
    public String GivoKey(String peticion){

        String respuesta = null;
        ArrayList<String> contenido = new ArrayList<String>();

        for(String key: map.keySet()){
            
            contenido = map.get(key);

            for(int i = 0; i < contenido.size()-1; i++){

                if(peticion.equals(contenido.get(i)) == true){

                    respuesta = contenido.get(i);
                    return respuesta;

                }

            }

        }

        return respuesta;
    }
}