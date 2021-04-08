import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class HashTreeMapa extends AbstractoHash {
    TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();; 

    public void crear(String tipo, ArrayList<String> lista){
        map.put(tipo, lista);
    }

    public  void agregar(String tipo, String agregado){
        ArrayList<String> temp = new ArrayList<String>();
        temp = this.map.get(tipo);
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

        for(int i = 0; i < contenido.size(); i++){

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

        String respuesta = "";
        
        String clase = GivoKey(Ryan);

        if(clase != null){

            respuesta = "La categoria es " + clase;

            return respuesta;

        }

        return respuesta;

    }

    public void recorrer(){
        Set<String> keys = map.keySet();

        ArrayList<String> contenido = new ArrayList<String>();

        for(String key: map.keySet()){
            
            contenido = map.get(key);

            ArrayList<String> PRO = contenido;
            
            int conta = 0;

            for(int i = 0; i < PRO.size(); i++){

                String elemento = PRO.get(i);

                for(int j = 0; j < PRO.size(); j++){

                    if(elemento.equals(PRO.get(j))){

                        conta++;

                    }

                }
                System.out.println("Producto: " + elemento + " cantidad: " + conta + " Categoria: " + key + "\n");
                conta = 0;
            }
            
        }
    }
    
    public void recorrerTipo(){
        
        Set<String> keys = map.keySet();

        ArrayList<String> contenido = new ArrayList<String>();

        for(String key: map.keySet()){
            
            contenido = map.get(key);

            System.out.println("--------------------------------------");
            System.out.println("Categoria: " + key);
            
            if(contenido.isEmpty() == true){

                System.out.println("No contiene nada. ");

            }else{
                for(int i = 0; i < contenido.size(); i++){

                    System.out.println(contenido.get(i));

                }
            }
            
            System.out.println("--------------------------------------");
            
        }
    }

    public Set<String> keySeto(){

        Set<String> keys = map.keySet();

        return keys;

    }
    public String GivoKey(String peticion){//Revisa si un nombre existe dentro una llave y le retorna el valor

        String respuesta = null;
        ArrayList<String> contenido = new ArrayList<String>();

        for(String key: map.keySet()){
            
            contenido = map.get(key);

            for(int i = 0; i < contenido.size()-1; i++){

                if(peticion.equals(contenido.get(i))){

                    respuesta = key;
                    return respuesta;

                }

            }

        }

        return respuesta;
    }
}