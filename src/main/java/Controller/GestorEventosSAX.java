package Controller;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.PrintStream;

public class GestorEventosSAX extends DefaultHandler {

    private final PrintStream ps;
    private int cuentaSeg;
    private String textoEN;
    private String textoES;
    private String idioma;
    private boolean enSegmento;
    private String idiomaOrigen;
    private final static int MAX_SEGMENTOS = 5;

    public GestorEventosSAX(PrintStream ps) {
        this.ps = ps;
        this.cuentaSeg = 0;
        this.idioma = null;
        this.enSegmento = false;
        this.idiomaOrigen = null;
    }


    @Override
    public void startDocument() {
        cuentaSeg = 0;
    }

    @Override
    // Método que salta cuando se está analizando el comiento de un elemento (etiqueta de apertura)
    public void startElement(String uri, String nombreLocal, String nombreCualif, Attributes atributos) {

        if (nombreLocal.equals("header")) {
            this.idiomaOrigen = atributos.getValue("srclang");
        } else if (nombreLocal.equals("tu")) {
            this.textoEN = null;
            this.textoES = null;
        } else if (nombreLocal.equals("tuv")) {
            this.idioma = atributos.getValue("xml:lang");
        } else if (nombreLocal.equals("seg")) {  // Idioma está en variable idioma
            this.enSegmento = true;
        }
        if (cuentaSeg > MAX_SEGMENTOS) {
            System.exit(0);
        }
    }

    @Override
    // Método que salta cuando se está analizando un contenido (texto)
    public void characters(char[] cars, int inicio, int longitud) {
        String texto = new String(cars, inicio, longitud);
        if (texto.trim().length() == 0) {
            return;
        }
        if (this.enSegmento) {
            if (this.idioma.equals("en")) {
                this.textoEN = texto;
            } else if (this.idioma.equals("es")) {
                this.textoES = texto;
            }
        }
    }

    // Se escribe todo, una vez recopilado
    @Override
    // Método que salta cuando se está analizando el cierre de un elemento (etiqueta de cierre)
    public void endElement(String uri, String nombreLocal, String nombreCualif) {
        if (nombreLocal.equals("tu")) {
            System.out.println("[" + this.cuentaSeg + "]");
            System.out.println(((this.idiomaOrigen.equals("en")) ? "*" : "") + "en=>" + this.textoEN);
            System.out.println(((this.idiomaOrigen.equals("es")) ? "*" : "") + "es=>" + this.textoES);
            cuentaSeg++;
        } else if (nombreLocal.equals("seg")) {
            this.enSegmento = false;
        }
    }


}
