import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class HashTreeMapa extends AbstractoHash {
    TreeMap<String, ArrayList<String>> map; 

    public void HashMap(){
        map = new TreeMap<String, ArrayList<String>>();

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
 
    public  void remplazar(String remplaza){
        ArrayList temp = map.get(tipo);
        for(int i = 0 ; i< temp.size()-1; i++){
            String a = temp.get(i);
            if(a == remplaza){
                temp.set(i, remplaza);
            }
        }
        map.replace(tipo, temp);
    }

    public  int contar(String tipo){
        ArrayList temp = map.get(tipo);
        int x = temp.size();
        return x;
    }

    public String buscar(String Ryan){//Buscando al String Ryan

        String respuesta = "No se encontro";
        
        Set<String> k = map.keySet();
        ArrayList keys = k.toArray();

        for(int i = 0; i < keys.size()-1; i++){

            String key= keys.get(i);
            ArrayList<E> temp = map.get(key);

            for(int k = 0; k < temp.size()-1; k++){
                
                if(temp.get(i) == Ryan){

                    respuesta = "El producto pertene a la categoria: " + key.get(i);

                }

            }
        }

        return respuesta;
    }
    
    public void recorrer(){
        
    }
    
    public void recorrerTipo(){
        
        Set<String> keys = map.keySet();

        for(int i = 0; i < keys.size()-1; i++){

            String key= keys.get(i);
            Arraylist temp = map.get(key);

            for(int k = 0; k < temp.size()-1; k++){
                
                System.out.println(key + ": " + temp.get(k));

            }
        }
    }

    public Set keySeto(){

        Set<String> keys = map.keySet();

        return keys;

    }


}
