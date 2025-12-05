/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luisaaran.sistema_experto;

import java.util.ArrayList;
import java.util.List;

import luisaaran.sistema_experto.entidades.Categoria;
import luisaaran.sistema_experto.entidades.Enfermedad;
import luisaaran.sistema_experto.entidades.Sintoma;

/**
 *
 * @author luisaAran
 */
public class Experto {
    public List<Enfermedad> diagnosticarEnfermedad(List<Sintoma> sintomas) throws IllegalArgumentException{
        List<Enfermedad> enfermedades = new ArrayList<>();
        StringBuilder regla = new StringBuilder();
        regla.append("identificar_enfermedad(")
       .append(formatearSintomasParaProlog(sintomas)).append(",")
       .append("Id").append(",")
       .append("Nom").append(").");
       enfermedades = PrologQueryExecutor.obtenerEnfermedades(regla.toString());
       if(enfermedades.isEmpty()){
        throw new IllegalArgumentException("No se pudo diagnosticar ninguna enfermedad con los síntomas proporcionados.");
       } 
       return enfermedades;
    }
    public List<Enfermedad> obtenerEnfermedadesPorCategoria(Categoria categoria){
        List<Enfermedad> enfermedades = new ArrayList<>();
        StringBuilder regla = new StringBuilder();
        regla.append("enfermedades_por_categoria(")
        .append(normalizarCadena(categoria.getNombre())) .append(",")
        .append("Nom").append(",")
        .append("Id").append(").");
        enfermedades = PrologQueryExecutor.obtenerEnfermedades(regla.toString());
        if(enfermedades.isEmpty()){
            throw new IllegalArgumentException("No se encontraron enfermedades para la categoría proporcionada.");
           }
        return enfermedades;
    }
    public List<Enfermedad> obtenerEnfermedadesCronicas(){
        List<Enfermedad> enfermedades = new ArrayList<>();
        StringBuilder regla = new StringBuilder();
        regla.append("enfermedades_cronicas(")
       .append("Id").append(",")
       .append("Nom").append(").");
       enfermedades = PrologQueryExecutor.obtenerEnfermedades(regla.toString());
       return enfermedades;
    }
    public String formatearSintomasParaProlog(List<Sintoma> sintomas){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (sintomas != null) {
            for (int i = 0; i < sintomas.size(); i++) {
                Sintoma sintoma = sintomas.get(i);
                String nombre = sintoma != null ? normalizarCadena(sintoma.getNombre()) : "";
                if (nombre.isEmpty()) {
                    continue;
                }
                if (sb.length() > 1) {
                    sb.append(',');
                }
                sb.append(nombre);
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private String normalizarCadena(String nombre){
        if (nombre == null) {
            return "";
        }
        String limpio = nombre.trim().toLowerCase().replace('-', ' ');
        while (limpio.contains("  ")) {
            limpio = limpio.replace("  ", " ");
        }
        limpio = limpio.replace(' ', '_');

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limpio.length(); i++) {
            char c = limpio.charAt(i);
            if (Character.isLetterOrDigit(c) || c == '_') {
                sb.append(c);
            }
        }
        int len = sb.length();
        if (len > 0 && sb.charAt(len - 1) == '_') {
            sb.deleteCharAt(len - 1);
        }
        return sb.toString();
    }
}
