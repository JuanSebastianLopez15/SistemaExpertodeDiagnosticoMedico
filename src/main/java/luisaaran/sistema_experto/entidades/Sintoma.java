package luisaaran.sistema_experto.entidades;
/**
 * @author luisaAran
 */
public class Sintoma {
	private String nombre;

	public Sintoma() {}

	public Sintoma(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
