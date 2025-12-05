package luisaaran.sistema_experto.entidades;

import java.util.List;
/**
 * @author luisaAran
 */
public class Enfermedad {
    private int id;
    private String nombre;
    private List<Recomendacion> recomendaciones;
    private Categoria categoria;
    private List<Sintoma> sintoma;
    public Enfermedad(){}
    public Enfermedad(int id, String nombre, List<Recomendacion> recomendaciones, Categoria categoria, List<Sintoma> sintoma) {
        this.id = id;
        this.nombre = nombre;
        this.recomendaciones = recomendaciones;
        this.categoria = categoria;
        this.sintoma = sintoma;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRecomendaciones(List<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setSintoma(List<Sintoma> sintoma) {
        this.sintoma = sintoma;
    }
    
}
