
public class Sala {

	private String nombre, creador;
	private int numMinimoJugadores, numMaximoJugadores, cantidadJugadores;
	private boolean estado;

	public Sala(String nombre, String creador, int numMinimoJugadores, int numMaximoJugadores, int cantidadJugadores,
			boolean estado) {
		this.nombre = nombre;
		this.creador = creador;
		this.numMinimoJugadores = numMinimoJugadores;
		this.numMaximoJugadores = numMaximoJugadores;
		this.cantidadJugadores = cantidadJugadores;
		this.estado = estado;
	}
}