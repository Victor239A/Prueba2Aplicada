import control.TiendaFecher;
import vistas.Dashboard;

public class Main {
    public static void main(String[] args) {

        String saludo = "Hola mundo";
        for(int i= 0; i<saludo.length(); i++){
            System.out.println(saludo.charAt(i));
        }

        try { 
            new vistas.Dashboard();
            
            String urlApi ="https://jsonplaceholder.typicode.com/posts";
            String respuesta = TiendaFecher.obtenerProductos(urlApi);
            System.out.println("Respuesta de la API:");
            System.out.println(respuesta);

          
        for(int i= 0; i<saludo.length(); i++){
        String letra = " " + respuesta.charAt(i);
            if(letra.equalsIgnoreCase("o")){
                System.out.println(respuesta.charAt(i));
            }
        }

        } catch (Exception e) {
            

        }
    }
}
