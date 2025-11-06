package org.example.model;

public class Servicios {

    private int ServicioID;
    private String nombre;
    private double precio;

    public Servicios(int servicioID, String nombre, double precio) {
        ServicioID = servicioID;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getServicioID() {
        return ServicioID;
    }

    public void setServicioID(int servicioID) {
        ServicioID = servicioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicios{" +
                "ServicioID=" + ServicioID +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
