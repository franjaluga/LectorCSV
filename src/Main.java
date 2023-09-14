import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        String nombreArchivo = "C:\\output\\entradas.csv";

        System.out.println(" INSERT INTO pacientes (Pac_Id, Pac_Nombres,Pac_Apellido_Paterno,Pac_Apellido_Materno,Pac_Edad,Prev_Id,Comu_Id)");
        System.out.println(" VALUES ");

        System.out.println( leerArchivo(nombreArchivo) );

        long endTime = System.nanoTime();
        System.out.println("Duración: " + (endTime-startTime)/1e6 + " ms");
    }

    public static String leerArchivo(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        // regex de digitos
        String regex = "\\d*";


        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;

            while( (linea = reader.readLine()) != null){
                sb.append("(");
                String lineaToArray [] = linea.split(";");

                for( int i = 0; i < lineaToArray.length; i++){
                    if( !lineaToArray[i].matches(regex) ){
                        lineaToArray[i] = "'" + lineaToArray[i] + "'";
                    }
                }

                linea = Arrays.toString( lineaToArray );
                linea = linea.replace("[","");
                linea = linea.replace("]","");

                sb.append( linea );
                sb.append(")");
                sb.append(",");
                sb.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}