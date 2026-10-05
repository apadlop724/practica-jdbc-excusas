/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // Ajusta según tu configuración local de MySQL / MariaDB (puerto habitualmente 3306)
    private static final String URL = "jdbc:mysql://localhost:3306/excusa_entrega";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Coloca aquí la contraseña de tu MySQL (en XAMPP suele estar vacía)

    /**
     * Obtiene una conexión activa a la base de datos practica_excusas.
     * @return Objeto Connection activo.
     * @throws SQLException Si ocurre algún error en la conexión.
     */
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
