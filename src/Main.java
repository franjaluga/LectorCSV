import java.io.*;

public class Main {
    public static void main(String[] args) {

        String nombreArchivo = "C:\\output\\entrada.csv";

        System.out.println(" INSERT INTO pacientes (Pac_Id, Pac_Nombres,Pac_Apellido_Pat,Pac_Apellido_Mat,Edad,Prev_Id,Comu_Id)");
        System.out.println(" VALUES");

        System.out.println( leerArchivo(nombreArchivo) );
    }

    public static String leerArchivo(String nombre){
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String linea;
            while( (linea = reader.readLine()) != null){
                sb.append("(");
                sb.append(linea);
                sb.append(")");
                sb.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}