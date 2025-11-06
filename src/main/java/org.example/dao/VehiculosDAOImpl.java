package org.example.dao;

import org.example.model.Vehiculos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculosDAOImpl implements VehiculosDAO {
    private final Connection connection;
    // Constructor que recibe la conexión como parámetro
    public VehiculosDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Vehiculos vehiculos) {
        String sql = "INSERT INTO Vehiculos (VehiculoID, ClienteID, marca, modelo, Placa, Color, Tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, vehiculos.getVehiculoID());
            statement.setInt(2, vehiculos.getClienteID());
            statement.setString(3, vehiculos.getMarca());
            statement.setString(4, vehiculos.getModelo());
            statement.setString(5, vehiculos.getPlaca());
            statement.setString(6, vehiculos.getColor());
            statement.setString(7, vehiculos.getTipo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Vehiculos leer(int VehiculoID) {
        String sql = "SELECT * FROM Vehiculos WHERE VehiculoID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, VehiculoID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Vehiculos(
                        resultSet.getInt("VehiculoID"),
                        resultSet.getInt( "clienteID"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("Placa"),
                        resultSet.getString("Color"),
                        resultSet.getString("Tipo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Vehiculos vehiculos) {
        String sql = "UPDATE Vehiculos SET clienteID = ?, marca = ?, modelo = ?, Placa = ?, Color = ?, Tipo = ? WHERE VehiculoID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, vehiculos.getClienteID());
            statement.setString(2, vehiculos.getMarca());
            statement.setString(3, vehiculos.getModelo());
            statement.setString(4, vehiculos.getPlaca());
            statement.setString(5, vehiculos.getColor());
            statement.setString(6, vehiculos.getTipo());
            statement.setInt(7, vehiculos.getVehiculoID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int VehiculoID) {
        String sql = "DELETE FROM Vehiculos WHERE VehiculoID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, VehiculoID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehiculos> listar() {
        List<Vehiculos> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculos";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                vehiculos.add(new Vehiculos(
                        resultSet.getInt("VehiculoID"),
                        resultSet.getInt("clienteID"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("Placa"),
                        resultSet.getString("Color"),
                        resultSet.getString("Tipo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }
}
