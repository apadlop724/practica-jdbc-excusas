/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import modelo.ExcusaEntrega;
import util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExcusaDAOImpl implements ExcusaDAO {

    // Helper para mapear cada fila del ResultSet a un objeto ExcusaEntrega
    private ExcusaEntrega mapearExcusa(ResultSet rs) throws SQLException {
        Date sqlDate = rs.getDate("fecha_entrega");
        return new ExcusaEntrega(
            rs.getInt("id"),
            rs.getString("alumno"),
            rs.getString("curso"),
            rs.getString("excusa"),
            rs.getInt("dias_retraso"),
            rs.getInt("credibilidad"),
            sqlDate != null ? sqlDate.toLocalDate() : null,
            rs.getBoolean("aprobada_por_profesor"),
            rs.getInt("nivel_drama")
        );
    }

    // 1. Consulta básica: Alumno, Excusa, Días de retraso, Drama (Ordenado por drama DESC)
    @Override
    public List<ExcusaEntrega> obtenerConsulta1_DramaDesc() {
        List<ExcusaEntrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega ORDER BY nivel_drama DESC";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearExcusa(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // 2. Consulta con LIKE y BETWEEN: perro/gato AND días entre 2 y 6
    @Override
    public List<ExcusaEntrega> obtenerConsulta2_MascotasYRetraso() {
        List<ExcusaEntrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega " +
                     "WHERE (excusa LIKE ? OR excusa LIKE ?) " +
                     "  AND dias_retraso BETWEEN ? AND ? " +
                     "ORDER BY dias_retraso DESC";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%perro%");
            ps.setString(2, "%gato%");
            ps.setInt(3, 2);
            ps.setInt(4, 6);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearExcusa(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // 3. Consulta con IS NULL: Sin fecha de entrega AND (credibilidad < 4 OR drama >= 9)
    @Override
    public List<ExcusaEntrega> obtenerConsulta3_SinFechaYCondiciones() {
        List<ExcusaEntrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega " +
                     "WHERE fecha_entrega IS NULL " +
                     "  AND (credibilidad < 4 OR nivel_drama >= 9)";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearExcusa(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // 4. Consulta avanzada: (Drama >= 8 AND Credibilidad <= 3) OR (Retraso BETWEEN 2 AND 5 AND excusa LIKE '%perro%')
    @Override
    public List<ExcusaEntrega> obtenerConsulta4_Avanzada() {
        List<ExcusaEntrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM excusa_entrega " +
                     "WHERE (nivel_drama >= 8 AND credibilidad <= 3) " +
                     "   OR (dias_retraso BETWEEN 2 AND 5 AND excusa LIKE '%perro%') " +
                     "ORDER BY nivel_drama DESC";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearExcusa(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
