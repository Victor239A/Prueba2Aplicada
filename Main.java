import control.TiendaFecher;

public class Main {
    public static void main(String[] args) {
        try {
           
            String urlApi = "https://jsonplaceholder.typicode.com/posts/99";
            String json = TiendaFecher.obtenerProductos(urlApi);

        
            String clave = "";
            String valor = "";
            boolean dentroClave = false;
            boolean dentroValor = false;
            boolean leyendoClave = false;
            boolean leyendoValor = false;

            for (int i = 0; i < json.length(); i++) {
                char c = json.charAt(i);

              
                if (c == '"' && !dentroClave && !leyendoValor) {
                    dentroClave = true;
                    clave = "";
                } else if (c == '"' && dentroClave) {
                    dentroClave = false;
                    leyendoClave = true;
                }
                
                else if (c == '"' && leyendoClave && !dentroValor) {
                    dentroValor = true;
                    valor = "";
                } else if (c == '"' && dentroValor) {
                    dentroValor = false;
                    leyendoValor = true;
                } else {
                    if (dentroClave) {
                        clave += c;
                    }
                    if (dentroValor) {
                        valor += c;
                    }
                }

             
                if (leyendoClave && leyendoValor) {
                    System.out.println(clave + " = " + valor);
                    leyendoClave = false;
                    leyendoValor = false;
                }
            }

           
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
