package org.example.dao;

import org.example.model.Vehiculos;
import java.sql.SQLException;
import java.util.List;

public interface VehiculosDAO {
    void crear(Vehiculos vehiculos) throws SQLException;

    Vehiculos leer(int VehiculoID) throws SQLException;

    void actualizar(Vehiculos vehiculos) throws SQLException;

    void eliminar(int VehiculoID) throws SQLException;

    List<Vehiculos> listar() throws SQLException;
}

