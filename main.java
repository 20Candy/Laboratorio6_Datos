
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Set;

class main{
    
    //metodo elegir  hashmap
    public static AbstractoHash trabajar(int tipo){
        AbstractoHash inventario= null;
        if(tipo==1){
            inventario = new HashMapa();
            
        }else if(tipo==2){
            inventario = new HashTreeMapa();
    
        }else if(tipo==3){
            inventario = new LinkedHashMapa();
        }
        return inventario;
        
    }

    public static void main(String [] args){

        //INVENTARIO--------------------------------------------------------------------------
        String direccion = "inventario.txt";

        String cont = "";

        HashMapa inventario = new HashMapa();

        ArrayList<String> Muebles = new ArrayList<String>();
        ArrayList<String> SillonesM = new ArrayList<String>();
        ArrayList<String> Bebidas = new ArrayList<String>();
        ArrayList<String> Condimentos = new ArrayList<String>();
        ArrayList<String> Carne = new ArrayList<String>();
        ArrayList<String> Frutas = new ArrayList<String>();
        ArrayList<String> Lacteos = new ArrayList<String>();

        inventario.crear("Mueble", Muebles);
        inventario.crear("Sillones", SillonesM);
        inventario.crear("Bebidas", Bebidas);
        inventario.crear("Condimento", Condimentos);
        inventario.crear("Carnes", Carne);
        inventario.crear("Frutas", Frutas);
        inventario.crear("Lacteos", Lacteos);

        
        try{

            BufferedReader bufer = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
 
            
            while((bfRead = bufer.readLine()) != null){
                //el ciclo se hace mientras bfRead tenga un dato

                temp = bfRead;

                String[] componentes = temp.split("\t");

                for (int i = 0; i < componentes.length; i++){
                    String a = componentes[i];
                    if(a.equals("Mueble de terraza |")){

                        inventario.agregar("Muebles", a);

                    } else if(a.equals("Sillones de masaje |")){

                        inventario.agregar("Sillones", a);

                    } else if(a.equals("Bebidas |")){

                        inventario.agregar("Bebidas", a);
                        
                    } else if(a.equals("Condimentos |")){

                        inventario.agregar("Condimento", a);
                        
                    } else if(a.equals("Frutas |")){

                        inventario.agregar("Frutas", a);

                    } else if(a.equals("Carnes |")){

                        inventario.agregar("Carnes", a);
                        
                    } else if(a.equals("Lacteos |")){

                        inventario.agregar("Lacteos", a);
                        
                    }
                }
            }
            cont = temp;

        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo solicitado");
        }

        


        System.out.println(cont);

        leerTxt leerTxt = new leerTxt();

        String info = leerTxt.leerTxt(direccion);

        Scanner scan = new Scanner(System.in);//hola mi amor 
        
        int op;
        int opcion; 
            
        op = scan.nextInt();
        opcion = op;

        //Aqui empieza nuestro menu y opciones para pedir que tipo de Map quiere usar.
        //**************************************************************************************************** */
        while (opcion != 4) {
            
            System.out.println("\n\n-----------.M.E.N.U.-----------");
            System.out.println("1. HashMap");//NO SE SI JALA
            System.out.println("2. TreeMap");//NO SE SI JALA
            System.out.println("3. LinkedHashMap");//NO SE SI JALA
            System.out.println("4. Salir\n\n");//NO SE SI JALA

            
            op = scan.nextInt();
            opcion = op;
            
            AbstractoHash coleccion = trabajar(op);

            //PARA HASHMAP

            System.out.println("1. Ingresa un producto a la coleccion");//NO SE SI JALA
            System.out.println("2. Categoria de producto");//NO SE SI JALA
            System.out.println("3. Informacion de coleccion");//NO SE SI JALA
            System.out.println("4. Informacion del inventario");//NO SE SI JALA
            System.out.println("5. Salir\n\n");//NO SE SI JALA

            int op1;
            int opcion1;

            try {
                op1 = scan.nextInt();
                opcion1 = op1;

                if (op1 == 1) {//PARA INGRESAR UN PRODUCTO
                    System.out.println("Ingrese la categoria del prodcuto que quiere agregar.");
                    String categoria = scan.next();

                    //Verificar que exista la categoria---------------------------------------
                    //Set<String> keys = inventario.keySet();
                    
                    try{

                        System.out.println("Ingrese el nuevo producto.");
                        String NuevoProducto = scan.next();
                        inventario.agregar(categoria, NuevoProducto);

                    }catch(Exception E){

                        System.out.println("La categoria no existe.");

                    }

                    //Si existe que guarde los productos de la categoria en temp
                    /*
                    int contador=0;
                    for(int i = 0; i < keys.size()-1; i++){
                        if(keys.get(i) == categoria){
                            ArrayList<E> temp = inventario.get(key);
                        }else{
                            contador++;
                        }
                    }

                    if(contador==keys.size()){
                        System.out.println("Categoria no disponible")

                    }else{
                        System.out.println("Ingrese el nombre del prodcuto");
                        String nombre = scan.next();

                        //Verifica que exista el producto
                        int contador2=0;
                        for(int k = 0; i < temp.size()-1; k++){
                            if(temp.get(i) == nombre){
                                
                                //agregarlo de coleccion
                                coleccion.agregar(categoria,nombre)
                                
                            }else{
                                contador2++;
                            }
                        }

                        if(contador2==temp.size()){
                            System.out.println("Producto no disponible")
                        }
                    }*/

                }else if(op1 == 2){//PARA MOSTRAR CATEGORIA DE PRODCUTO_______________________--
                    
                    System.out.println("Ingrese el nombre del producto del que quiere saber la categoria.");
                    String categoria = scan.next();

                    //Verificar que exista la categoria---------------------------------------
                    //Set<String> keys = inventario.keySet();
                    if(!inventario.GivoKey(categoria).equals(null)){

                        System.out.println("La categoria del producto ");

                    }else{

                        System.out.println("La categoria no existe :(");

                    }

                } else if(op1 == 3){//PARA PEDIR INFO DE LA COLECCION 

                    while (opcion1 != 3) {
            
                        System.out.println("1. Mostrar articulos en la coleccion" );//NO SE SI JALA
                        System.out.println("2. Mostrar articulos en la coleccion por tipo" );//NO SE SI JALA
                        System.out.println("3. Salir\n\n");//NO SE SI JALA
                        try {
                            op1 = scan.nextInt();
                            opcion1 = op;
            
                            if (op1 == 1) {
            
            
                            } else if(op1 == 2){
            
                                
            
                            } else if(op1 == 3){
                                
                                opcion1 = 3;

                            } else{
            
                                System.out.println("La opcion que has ingresado no es valida");
                            }
                            
                        }catch (Exception e){
                            //TODO: handle exception
                            System.out.println("Debes ingresar un valor numerico como opcion");
                        }
                    }
                    
                } else if(op1 == 3){//MOSTRAR INFO DE INVENTARIO

                    while (opcion1 != 3) {
            
                        System.out.println("1. Mostrar articulos del inventario" );//NO SE SI JALA
                        System.out.println("2.  Mostrar articulos del inventario por tipo" );//NO SE SI JALA
                        System.out.println("3. Salir\n\n");//NO SE SI JALA
                        try {
                            op1 = scan.nextInt();
                            opcion1 = op;
            
                            if (op1 == 1) {
            
            
                            } else if(op1 == 2){
            
                                
            
                            } else if(op1 == 3){
                                
                                opcion1 = 3;

                            } else{
            
                                System.out.println("La opcion que has ingresado no es valida");
                            }
                            
                        }catch (Exception e){
                            //TODO: handle exception
                            System.out.println("Debes ingresar un valor numerico como opcion");
                        }
                    }

                    
                } else if(op1 == 4){

                    System.out.println("Adios UwU");
                    opcion1 = 4;
                    
                } else{

                    System.out.println("La opcion que has ingresado no es valida");
                }
                
            }catch (Exception e){
                //TODO: handle exception
                System.out.println("Debes ingresar un valor numerico como opcion");
        
            }
            
        }
    }
    
}