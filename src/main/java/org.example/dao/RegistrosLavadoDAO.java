package org.example.dao;

import org.example.model.RegistrosLavado;
import java.sql.SQLException;
import java.util.List;

public interface RegistrosLavadoDAO {
    void crear(RegistrosLavado registrosLavado) throws SQLException;

    RegistrosLavado leer(int registroID) throws SQLException;

    void actualizar(RegistrosLavado registrosLavado) throws SQLException;

    void eliminar(int registroID) throws SQLException;

    List <RegistrosLavado> listar() throws SQLException;
}
