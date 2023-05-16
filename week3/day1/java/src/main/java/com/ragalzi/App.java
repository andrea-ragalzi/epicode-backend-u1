package com.ragalzi;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try {
            DbConnection dbConnection = new DbConnection();
            Cliente cliente = new Cliente("Andrea", "Ragalzi", LocalDate.parse("1994-12-05"), "Piemonte");
            // dbConnection.insericiCliente(cliente);
            dbConnection.leggiCliente(4011);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
