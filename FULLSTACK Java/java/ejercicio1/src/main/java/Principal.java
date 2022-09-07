import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal
{
    public static void main(String[] args) throws IOException {
        String nombre, apellido, hobbie, editor, sistemaoperativo;
        int edad;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese su nombre: ");
        nombre = br.readLine();
        System.out.print("Ingrese su apellido: ");
        apellido = br.readLine();
        System.out.print("Ingrese su edad: ");
        edad =Integer.parseInt(br.readLine());
        System.out.print("Ingrese su hobbie: ");
        hobbie = br.readLine();
        System.out.print("Ingrese su editor de preferencia: ");
        editor = br.readLine();
        System.out.print("Ingrese el sistema operativo que utiliza: ");
        sistemaoperativo = br.readLine();

        System.out.println("Su nombre es: " + nombre);
        System.out.println("Su apellido es: " + apellido);
        System.out.println("Su edad es: " + edad);
        System.out.println("Su hobbie es: " + hobbie);
        System.out.println("Su editor de preferencia es: " + editor);
        System.out.println("El sistema operativo que mas utiliza es: " + sistemaoperativo);

    }
}
