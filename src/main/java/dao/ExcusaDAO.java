/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;


import modelo.ExcusaEntrega;
import java.util.List;

public interface ExcusaDAO {
    List<ExcusaEntrega> obtenerConsulta1_DramaDesc();
    List<ExcusaEntrega> obtenerConsulta2_MascotasYRetraso();
    List<ExcusaEntrega> obtenerConsulta3_SinFechaYCondiciones();
    List<ExcusaEntrega> obtenerConsulta4_Avanzada();
}
