package Model;

import java.io.Serializable;

public class Fichero implements Serializable {
    int id;
    String nombre;
    String fechaHoraModif;
    long tamanioFich;
    String sha1;
    String md5;
    public Fichero() {
    }

    public Fichero(int id, String nombre, String fechaHoraModif, long tamanioFich, String sha1, String md5) {
        this.id = id;
        this.nombre = nombre;
        this.fechaHoraModif = fechaHoraModif;
        this.tamanioFich = tamanioFich;
        this.sha1 = sha1;
        this.md5 = md5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaHoraModif() {
        return fechaHoraModif;
    }

    public void setFechaHoraModif(String fechaHoraModif) {
        this.fechaHoraModif = fechaHoraModif;
    }

    public long getTamanioFich() {
        return tamanioFich;
    }

    public void setTamanioFich(long tamanioFich) {
        this.tamanioFich = tamanioFich;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "Fichero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaHoraModif='" + fechaHoraModif + '\'' +
                ", tamanioFich=" + tamanioFich +
                ", sha1='" + sha1 + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
