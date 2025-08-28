package control;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TiendaFecher {

    

public static String obtenerProductos (String urlApi){
        //Crea un String con más opciones
    StringBuilder resultado=new StringBuilder();

    //Objeto para crear una conexión HTTP
    HttpURLConnection conexion=null;

    try {
        //Convierte un String a una URL
        URL url=new URL(urlApi);

        //Configuración para la conexión HTTP
        conexion=(HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");;
        conexion.setConnectTimeout(5000);
        conexion.setReadTimeout(5000);
        conexion.connect();
        
        int code =conexion.getResponseCode();
        System.out.println(code);

        try(BufferedReader br =new BufferedReader(
            new InputStreamReader(conexion.getInputStream(),
            StandardCharsets.UTF_8))
            ){
                String linea;
                while((linea=br.readLine()) !=null){
                    resultado.append(linea).append("\n");
                }
            }

    } catch (Exception e) {
       System.out.println("Error"+e);
    }

    finally{
        if (conexion!=null) conexion.disconnect();
    }

    return resultado.toString();
    
}}