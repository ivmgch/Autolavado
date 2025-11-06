package org.example.dao;

import org.example.model.Servicios;
import java.sql.SQLException;
import java.util.List;

public interface ServiciosDAO {

    void crear(Servicios servicios) throws SQLException;

    Servicios leer(int serviciosID) throws SQLException;

    void actualizar(Servicios servicios) throws SQLException;

    void eliminar(int serviciosID) throws SQLException;

    List<Servicios> listar() throws SQLException;
}
