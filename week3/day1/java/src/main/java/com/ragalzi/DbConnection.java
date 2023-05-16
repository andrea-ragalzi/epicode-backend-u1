package com.ragalzi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
    String url = "jdbc:postgresql://localhost:5432/";
    String host = "localhost";
    String user = "root";
    String password = "root";
    String db_name = "andrea";
    Connection connection;
    Statement statement;

    public DbConnection() throws SQLException {
        connection = DriverManager.getConnection(url + db_name, user, password);
        statement = connection.createStatement();
        System.out.println("Connection established");
    }

    public void insericiCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (nome, cognome, data_nascita, regione_residenza) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCognome());
        stmt.setDate(3, Date.valueOf(cliente.getDataNascita()));
        stmt.setString(4, cliente.getRegioneResidenza());
        int rowsInserted = stmt.executeUpdate();
        System.out.println("Rows inserted: " + rowsInserted);
    }

    public void leggiCliente(int numero_cliente) throws SQLException {
        String query = "SELECT * FROM cliente WHERE numero_cliente = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, numero_cliente);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String cognome = resultSet.getString("cognome");
            Date dataNascita = resultSet.getDate("data_nascita");
            String regioneResidenza = resultSet.getString("regione_residenza");
            String clienteString = String.format("%s %s, nato il %s, residente in %s", nome, cognome, dataNascita, regioneResidenza);
            System.out.println(clienteString);
        }
        
    }

}
