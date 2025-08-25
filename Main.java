import control.TiendaFecher;
import vistas.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {


        try {
            new vistas.VentanaPrincipal();
            
            String urlApi ="https://jsonplaceholder.typicode.com/posts";
            String respuesta = TiendaFecher.obtenerProductos(urlApi);
            System.out.println("Respuesta de la API:");
            System.out.println(respuesta);

        } catch (Exception e) {
            

        }
    }
}
