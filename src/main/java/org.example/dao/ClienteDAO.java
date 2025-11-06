package org.example.dao;

import org.example.model.Cliente;
import java.sql.SQLException; // Importar
import java.util.List;

public interface ClienteDAO {
    void crear(Cliente cliente) throws SQLException;

    Cliente leer(int clienteId) throws SQLException;

    void actualizar(Cliente cliente) throws SQLException;

    void eliminar(int clienteId) throws SQLException;

    List<Cliente> listar() throws SQLException;
}