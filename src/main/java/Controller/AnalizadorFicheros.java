package Controller;

import java.io.File;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.*;
import java.util.*;

public class AnalizadorFicheros {
    static File fichero;
    static File ficheroContenido;
    static String[] listado;
    static String dia, mes, year, hora, minuto, segundo;
    static Calendar c;
    static Date d;
    static long ms;
    String probar, ruta = "C:\\_Pruebas_Programacion";

    public static Object[][] analizarRuta(String ruta) {
        fichero = new File(ruta);
        listado = fichero.list();
        Object[][] infoFicheros = new Object[listado.length][6]; // 6 columnas: id, nombre, fecha, tamaño, SHA1, MD5
        int indice = 0;
        long tamanio;

        if (listado != null) {
            for (String s : listado) {
                ficheroContenido = new File(fichero.getAbsolutePath(), s);
                if (ficheroContenido.isFile()) {
                    ms = ficheroContenido.lastModified();
                    d = new Date(ms);
                    c = new GregorianCalendar();
                    c.setTime(d);
                    dia = Integer.toString(c.get(Calendar.DATE));
                    mes = Integer.toString(c.get(Calendar.MONTH));
                    year = Integer.toString(c.get(Calendar.YEAR));
                    hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                    minuto = Integer.toString(c.get(Calendar.MINUTE));
                    segundo = Integer.toString(c.get(Calendar.SECOND));

                    tamanio = ficheroContenido.length();
                    String sha1 = generarMD5oSHA1DeFichero(ficheroContenido.getAbsolutePath(), "SHA");
                    String md5 = generarMD5oSHA1DeFichero(ficheroContenido.getAbsolutePath(), "MD5");

                    infoFicheros[indice][0] = indice + 1; // ID
                    infoFicheros[indice][1] = s; // Nombre
                    infoFicheros[indice][2] = dia + "-" + mes + "-" + year + " " + hora + ":" + minuto + ":" + segundo; // Fecha
                    infoFicheros[indice][3] = tamanio; // Tamaño
                    infoFicheros[indice][4] = sha1; // SHA1
                    infoFicheros[indice][5] = md5; // MD5
                    indice++;
                }
            }
        }
        return infoFicheros;
    }
    private static String generarMD5oSHA1DeFichero(String file, String algoritmo){
        String hash = "";
        //declarar funciones resumen
        try{
            MessageDigest messageDigest = MessageDigest.getInstance(algoritmo);

            //leer fichero byte a byte

            try{
                InputStream archivo = new FileInputStream( file );
                byte[] buffer = new byte[1];
                int fin_archivo = -1;
                int caracter;

                caracter = archivo.read(buffer);

                while( caracter != fin_archivo ) {

                    messageDigest.update(buffer); // Pasa texto claro a la función resumen
                    caracter = archivo.read(buffer);
                }

                archivo.close();
                byte[] resumen = messageDigest.digest(); // Genera el resumen MD5

                //Pasar los resumenes a hexadecimal


                for (int i = 0; i < resumen.length; i++)
                {
                    hash += Integer.toHexString((resumen[i] >> 4) & 0xf);
                    hash += Integer.toHexString(resumen[i] & 0xf);
                }


            }
            //lectura de los datos del fichero
            catch(java.io.FileNotFoundException fnfe) {}
            catch(java.io.IOException ioe) {}

        }
        //declarar funciones resumen
        catch(java.security.NoSuchAlgorithmException nsae) {}
        return hash;

    }
    public static void main(String[] args) {//Solo para pruebas, borrar antes de enviar

        String rutaDeEjemplo = "C:\\_Pruebas_Programacion";
        Object[][] resultados = analizarRuta(rutaDeEjemplo);
        for (Object[] fila : resultados) {
            for (Object valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

}
