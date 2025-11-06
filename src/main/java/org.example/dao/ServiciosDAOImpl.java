package org.example.dao;

import org.example.model.Servicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiciosDAOImpl implements ServiciosDAO {
    private final Connection connection;

    // Constructor que recibe la conexión como parámetro
    public ServiciosDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Servicios servicios) {
        String sql = "INSERT INTO Servicios (ServicioID, nombre, precio) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, servicios.getServicioID());
            statement.setString(2, servicios.getNombre());
            statement.setDouble(3, servicios.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Servicios leer(int servicioID) {
        String sql = "SELECT * FROM Servicios WHERE servicioID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, servicioID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Servicios(
                        resultSet.getInt( "servicioID"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Servicios servicios) {
        String sql = "UPDATE Servicios SET nombre = ?, precio = ? WHERE ServicioID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, servicios.getNombre());
            statement.setDouble(2, servicios.getPrecio());
            statement.setInt(3, servicios.getServicioID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int ServicioID) {
        String sql = "DELETE FROM Servicios WHERE ServicioID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ServicioID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Servicios> listar() {
        List<Servicios> servicios = new ArrayList<>();
        String sql = "SELECT * FROM Servicios";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                servicios.add(new Servicios(
                        resultSet.getInt("ServicioID"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicios;
    }
}