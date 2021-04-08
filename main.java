
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
        AbstractoHash coleccion= null;

        if(tipo==1){
            coleccion = new HashMapa();
            
        }else if(tipo==2){
            coleccion = new HashTreeMapa();

        }else if(tipo==3){
            coleccion = new LinkedHashMapa();
        }
        return coleccion;
        
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
                    String aa = componentes[1];

                    if(a.equals("Mueble de terraza |")){

                        inventario.agregar("Mueble", aa);

                    } else if(a.equals("Sillones de masaje |")){

                        inventario.agregar("Sillones", aa);

                    } else if(a.equals("Bebidas |")){

                        inventario.agregar("Bebidas", aa);
                        
                    } else if(a.equals("Condimentos |")){

                        inventario.agregar("Condimento", aa);
                        
                    } else if(a.equals("Frutas |")){

                        inventario.agregar("Frutas", aa);

                    } else if(a.equals("Carnes |")){

                        inventario.agregar("Carnes", aa);
                        
                    } else if(a.equals("Lacteos |")){

                        inventario.agregar("Lacteos", aa);
                        
                    }
                }
            }
            cont = temp;

        }catch(Exception e){
            
            System.out.println("No se ha encontrado el archivo solicitado");
        }

        Scanner scan = new Scanner(System.in);//hola mi amor 
        
        int op;
            
        System.out.println("\n\n-----------.M.E.N.U.-----------");
        System.out.println("1. HashMap");//NO SE SI JALA
        System.out.println("2. TreeMap");//NO SE SI JALA
        System.out.println("3. LinkedHashMap\n\n");//NO SE SI JALA
        op = scan.nextInt();

        int op1 = -1;
        int opcion1= -1;

        //SE CREA COLECCION---------------------------------------------------------------------------------


        ArrayList<String> Muebles2 = new ArrayList<String>();
        ArrayList<String> Sillones2 = new ArrayList<String>();
        ArrayList<String> Bebidas2 = new ArrayList<String>();
        ArrayList<String> Condimentos2 = new ArrayList<String>();
        ArrayList<String> Carne2 = new ArrayList<String>();
        ArrayList<String> Frutas2 = new ArrayList<String>();
        ArrayList<String> Lacteos2 = new ArrayList<String>();

        AbstractoHash coleccion = trabajar(op);
        coleccion.crear("Mueble", Muebles2);
        coleccion.crear("Sillones", Sillones2);
        coleccion.crear("Bebidas", Bebidas2);
        coleccion.crear("Condimento", Condimentos2);
        coleccion.crear("Carnes", Carne2);
        coleccion.crear("Frutas", Frutas2);
        coleccion.crear("Lacteos", Lacteos2);


        //Aqui empieza nuestro menu y opciones para pedir que tipo de Map quiere usar.
        //**************************************************************************************************** */
        while (opcion1 != 5) {
            
            
            //PARA HASHMAP

            System.out.println("1. Ingresa un producto a la coleccion");//NO SE SI JALA
            System.out.println("2. Categoria de producto");//NO SE SI JALA
            System.out.println("3. Informacion de coleccion");//NO SE SI JALA
            System.out.println("4. Informacion del inventario");//NO SE SI JALA
            System.out.println("5. Salir\n\n");//NO SE SI JALA

            String pedir = scan.next();

            try {

                op1 = Integer.parseInt(pedir);
                opcion1 = op1;

                if (op1 == 1) {//PARA INGRESAR UN PRODUCTO
            
                    System.out.println("Ingrese la categoria del producto que quiere agregar.");
                    String categoria = scan.next();

                    try{

                        System.out.println("Ingrese el nuevo producto.");
                        scan.nextLine();
                        String NuevoProducto =scan.nextLine();
                        String respuesta = inventario.buscar(NuevoProducto);
                        
                        if(respuesta.equals("")){

                            System.out.println("El producto no existe");
                            
                        } else{
                            
                            coleccion.agregar(categoria, NuevoProducto);
                            System.out.println("Se ha agregado un nuevo producto a la coleccion\n");
                        
                        }

                    }catch(Exception E){

                        System.out.println("La categoria no existe. ");

                    }



                }else if(op1 == 2){//PARA MOSTRAR CATEGORIA DE PRODCUTO_______________________--//si deberia de funcionar
                    
                    System.out.println("Ingrese el nombre del producto del que quiere saber la categoria.");
                    String categoria = scan.next();

                    if(!inventario.GivoKey(categoria).equals(null)){

                        System.out.println("La categoria del producto " + inventario.GivoKey(categoria)+ "\n");

                    }else{

                        System.out.println("La categoria no existe :(");

                    }

                } else if(op1 == 3){//PARA PEDIR INFO DE LA COLECCION 

                    int op2 = -1;
                    int opcion2 = -1;
                    while (opcion2 != 3) {
            
                        System.out.println("1. Mostrar articulos en la coleccion" );//NO SE SI JALA
                        System.out.println("2. Mostrar articulos en la coleccion por tipo" );//NO SE SI JALA
                        System.out.println("3. Salir\n\n");//NO SE SI JALA
                        try {
                            op2 = scan.nextInt();
                            opcion2 = op;
            
                            if (op2 == 1) {
            
                                coleccion.recorrer();
            
                            } else if(op2 == 2){
            
                                coleccion.recorrerTipo();
            
                            } else if(op2 == 3){
                                
                                opcion2 = 3;

                            } else{
            
                                System.out.println("La opcion que has ingresado no es valida");
                            }
                            
                        }catch (Exception e){
                            //TODO: handle exception
                            System.out.println("Debes ingresar un valor numerico como opcion");
                        }
                    }
                    
                } else if(op1 == 4){//MOSTRAR INFO DE INVENTARIO

                    int op2 = -1;
                    int opcion2 = -1;
                    while (opcion2 != 3) {
            
                        System.out.println("1. Mostrar articulos en el inventario y su cantidad" );//SI JALA
                        System.out.println("2. Mostrar articulos en el inventario por tipo" );//SI JALA
                        System.out.println("3. Salir\n\n");//NO SE SI JALA
                        try {
                            op2 = scan.nextInt();
                            opcion2 = op;
            
                            if (op2 == 1) {
            
                                inventario.recorrer();
            
                            } else if(op2 == 2){
            
                                inventario.recorrerTipo();
            
                            } else if(op2 == 3){
                                
                                opcion2 = 3;

                            } else{
            
                                System.out.println("La opcion que has ingresado no es valida");
                            }
                            
                        }catch (Exception e){
                            //TODO: handle exception
                            System.out.println("Debes ingresar un valor numerico como opcion");
                        }
                    }

                } else if(op1 == 5){

                    System.out.println("Adios UwU");
                    opcion1 = 5;
                    
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