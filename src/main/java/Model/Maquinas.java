package Model;

public class Maquinas implements Comparable{
    int codigoMaquina;
    String nombreMaquina;
    String ubicacionMaquina;

    public Maquinas() {
    }

    public Maquinas(int codigoMaquina, String nombreMaquina, String ubicacionMaquina) {
        this.codigoMaquina = codigoMaquina;
        this.nombreMaquina = nombreMaquina;
        this.ubicacionMaquina = ubicacionMaquina;
    }

    public int getCodigoMaquina() {
        return codigoMaquina;
    }

    public void setCodigoMaquina(int codigoMaquina) {
        this.codigoMaquina = codigoMaquina;
    }

    public String getNombreMaquina() {
        return nombreMaquina;
    }

    public void setNombreMaquina(String nombreMaquina) {
        this.nombreMaquina = nombreMaquina;
    }

    public String getUbicacionMaquina() {
        return ubicacionMaquina;
    }

    public void setUbicacionMaquina(String ubicacionMaquina) {
        this.ubicacionMaquina = ubicacionMaquina;
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigoMaquina +
                ", nombre='" + nombreMaquina + '\'' +
                ", ciudad='" + ubicacionMaquina + '\'' +
                '}';
    }
}
