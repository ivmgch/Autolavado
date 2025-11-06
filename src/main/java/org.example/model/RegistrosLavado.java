package org.example.model;

public class RegistrosLavado {

    private int RegistroID;
    private int VehiculoID;
    private int ServicioID;
    private String FechaLavado;
    private String HoradeInicio;
    private String HoradeFin;
    private double PrecioTotal;

    public RegistrosLavado(int registroID, int vehiculoID, int servicioID, String fechaLavado, String horadeInicio, String horadeFin, double precioTotal) {
        RegistroID = registroID;
        VehiculoID = vehiculoID;
        ServicioID = servicioID;
        FechaLavado = fechaLavado;
        HoradeInicio = horadeInicio;
        HoradeFin = horadeFin;
        PrecioTotal = precioTotal;
    }

    public int getRegistroID() {
        return RegistroID;
    }

    public void setRegistroID(int registroID) {
        RegistroID = registroID;
    }

    public int getVehiculoID() {
        return VehiculoID;
    }

    public void setVehiculoID(int vehiculoID) {
        VehiculoID = vehiculoID;
    }

    public int getServicioID() {
        return ServicioID;
    }

    public void setServicioID(int servicioID) {
        ServicioID = servicioID;
    }

    public String getFechaLavado() {
        return FechaLavado;
    }

    public void setFechaLavado(String fechaLavado) {
        FechaLavado = fechaLavado;
    }

    public String getHoradeInicio() {
        return HoradeInicio;
    }

    public void setHoradeInicio(String horadeInicio) {
        HoradeInicio = horadeInicio;
    }

    public String getHoradeFin() {
        return HoradeFin;
    }

    public void setHoradeFin(String horadeFin) {
        HoradeFin = horadeFin;
    }

    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        PrecioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "RegistrosLavado{" +
                "RegistroID=" + RegistroID +
                ", VehiculoID=" + VehiculoID +
                ", ServicioID=" + ServicioID +
                ", FechaLavado='" + FechaLavado + '\'' +
                ", HoradeInicio='" + HoradeInicio + '\'' +
                ", HoradeFin='" + HoradeFin + '\'' +
                ", PrecioTotal=" + PrecioTotal +
                '}';
    }
}
