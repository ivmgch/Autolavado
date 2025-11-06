package org.example.dao;


import org.example.model.RegistrosLavado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrosLavadoDAOImpl implements RegistrosLavadoDAO {
    private final Connection connection;
    // Constructor que recibe la conexión como parámetro
    public RegistrosLavadoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void crear(RegistrosLavado registrosLavado) {
        String sql = "INSERT INTO RegistrosLavado (RegistroID, VehiculoID, ServicioID, FechadeLavado, HoradeInicio, HoraFin, PrecioTotal) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registrosLavado.getRegistroID());
            statement.setInt(2, registrosLavado.getVehiculoID());
            statement.setInt(3, registrosLavado.getServicioID());
            statement.setString(4, registrosLavado.getFechaLavado());
            statement.setString(5, registrosLavado.getHoradeInicio());
            statement.setString(6, registrosLavado.getHoradeFin());
            statement.setDouble(7, registrosLavado.getPrecioTotal());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RegistrosLavado leer(int registroID) {
        String sql = "SELECT * FROM RegistrosLavado WHERE RegistroID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registroID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new RegistrosLavado(
                        resultSet.getInt( "registroID"),
                        resultSet.getInt("vehiculoID"),
                        resultSet.getInt("servicioID"),
                        resultSet.getString("fechadeLavado"),
                        resultSet.getString("horadeInicio"),
                        resultSet.getString("horaFin"),
                        resultSet.getDouble("precioTotal")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizar(RegistrosLavado registrosLavado) {
        String sql = "UPDATE RegistrosLavado SET VehiculoID = ?, ServicioID = ?, FechadeLavado = ?, HoradeInicio = ?, HoraFin = ?, PrecioTotal = ? WHERE RegistroID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registrosLavado.getVehiculoID());
            statement.setInt(2, registrosLavado.getServicioID());
            statement.setString(3, registrosLavado.getFechaLavado());
            statement.setString(4, registrosLavado.getHoradeInicio());
            statement.setString(5, registrosLavado.getHoradeFin());
            statement.setDouble(6, registrosLavado.getPrecioTotal());
            statement.setInt(7, registrosLavado.getRegistroID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int registroID) {
        String sql = "DELETE FROM RegistrosLavado WHERE RegistroID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registroID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RegistrosLavado> listar() {
        List<RegistrosLavado> registrosLavados = new ArrayList<>();
        String sql = "SELECT * FROM RegistrosLavado";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                registrosLavados.add(new RegistrosLavado(
                        resultSet.getInt("RegistroID"),
                        resultSet.getInt("VehiculoID"),
                        resultSet.getInt("ServicioID"),
                        resultSet.getString("FechadeLavado"),
                        resultSet.getString("HoradeInicio"),
                        resultSet.getString("HoraFin"),
                        resultSet.getDouble("PrecioTotal")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosLavados;
    }

}
