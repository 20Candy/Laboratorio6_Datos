
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class leerTxt{
    public String leerTxt(String direccion){

        String cont = "";

        try{

            BufferedReader bufer = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
 
            
            while((bfRead = bufer.readLine()) != null){
                //el ciclo se hace mientras bfRead tenga un dato

                temp = temp + "," +bfRead;
            }

            cont = temp;

        }catch(Exception e){
            System.out.println("No se ha encontrado el archivo solicitado");
        }

        return cont;
    }
}