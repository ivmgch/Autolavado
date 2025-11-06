package org.example.model;

public class Vehiculos {
    private int VehiculoID;
    private int ClienteID;
    private String marca;
    private String modelo;
    private String Placa;
    private String Color;
    private String Tipo;

    public Vehiculos(int vehiculoID, int clienteID, String marca, String modelo, String placa, String color, String tipo) {
        VehiculoID = vehiculoID;
        ClienteID = clienteID;
        this.marca = marca;
        this.modelo = modelo;
        Placa = placa;
        Color = color;
        Tipo = tipo;
    }

    public int getVehiculoID() {
        return VehiculoID;
    }

    public void setVehiculoID(int vehiculoID) {
        VehiculoID = vehiculoID;
    }

    public int getClienteID() {
        return ClienteID;
    }

    public void setClienteID(int clienteID) {
        ClienteID = clienteID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "VehiculoID=" + VehiculoID +
                ", ClienteID=" + ClienteID +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", Placa='" + Placa + '\'' +
                ", Color='" + Color + '\'' +
                ", Tipo='" + Tipo + '\'' +
                '}';
    }
}
