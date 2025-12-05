/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisaaran.sistema_experto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jpl7.Query;
import org.jpl7.Term;

import luisaaran.sistema_experto.entidades.Enfermedad;

/**
 *
 * @author luisAran
 */
public class PrologQueryExecutor {
    public static void createDynamicFact(String fact){
        Query q = new Query(fact);
        if(q.hasSolution()){
            System.out.println("Hecho agregado: " + fact);
        }else{
            System.out.println("Error al agregar el hecho: " + fact);
        }
    }
    public static List<Enfermedad> obtenerEnfermedades(String fact){
        List<Enfermedad> enfermedades = new ArrayList<>();
        Query q = new Query(fact);
        while(q.hasMoreSolutions()){
            Map<String, Term> sol = q.nextSolution();
            Enfermedad enfermedad = new Enfermedad();
            Integer id = null;
            Term idTerm = sol.get("IdEnfermedad");
            if(idTerm != null){
                try{
                    id = Integer.parseInt(idTerm.toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            String nombre = null;
            Term nomTerm = sol.get("Nom");
            if(nomTerm != null){
                nombre = nomTerm.toString();
            }
            enfermedad.setId(id);
            enfermedad.setNombre(nombre);
            enfermedades.add(enfermedad);
        }
        return enfermedades;
    }
    public static List<Enfermedad> obtenerEnfermedadesPorCategoria(String rule){
        List<Enfermedad> enfermedades = new ArrayList<>();
        Query q = new Query(rule);
        while(q.hasMoreSolutions()){
            Map<String, Term> sol = q.nextSolution();
            Enfermedad enfermedad = new Enfermedad();
            Integer id = null;
            Term idTerm = sol.get("IdEnfermedad");
            if(idTerm != null){
                try{
                    id = Integer.parseInt(idTerm.toString());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            String nombre = null;
            Term nomTerm = sol.get("Nom");
            if(nomTerm != null){
                nombre = nomTerm.toString();
            }
            enfermedad.setId(id);
            enfermedad.setNombre(nombre);
            enfermedades.add(enfermedad);
        }
        return enfermedades;
    }
}
