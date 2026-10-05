/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicajdbc;

import dao.ExcusaDAO;
import dao.ExcusaDAOImpl;
import modelo.ExcusaEntrega;

import java.util.List;

public class PracticaJDBC {

    public static void main(String[] args) {
        
        ExcusaDAO dao = new ExcusaDAOImpl();

        System.out.println("=== CONSULTA 1: Todas las excusas ordenadas por Drama (DESC) ===");
        imprimirLista(dao.obtenerConsulta1_DramaDesc());

        System.out.println("\n=== CONSULTA 2: Excusas de perro/gato con retraso entre 2 y 6 días ===");
        imprimirLista(dao.obtenerConsulta2_MascotasYRetraso());

        System.out.println("\n=== CONSULTA 3: Sin fecha de entrega Y (Credibilidad < 4 O Drama >= 9) ===");
        imprimirLista(dao.obtenerConsulta3_SinFechaYCondiciones());

        System.out.println("\n=== CONSULTA 4: Consulta Avanzada con Grupos OR / AND ===");
        imprimirLista(dao.obtenerConsulta4_Avanzada());
    }

    private static void imprimirLista(List<ExcusaEntrega> lista) {
        if (lista.isEmpty()) {
            System.out.println("No se encontraron registros.");
        } else {
            lista.forEach(System.out::println);
           
        }
    }
    
    }

