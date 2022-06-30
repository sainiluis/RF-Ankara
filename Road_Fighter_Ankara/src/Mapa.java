import java.util.ArrayList;



public class Mapa {
	private int disenio;
	private double limiteIzquierdo;
	private double limiteDerecho;
	private int puntosOtorgados;
	private double longitud;
	private int dificultad;
	private ArrayList<AutomovilJugador> listaJugadores;
	private ArrayList<Obstaculo> listaObstaculos;
	private ArrayList<AutomovilBot> listaBots;
	private int segmentos;
	private double longitudSegmento = 5;

	public Mapa(int disenio, double limiteIzquierdo, double limiteDerecho, int puntosOtorgados, double longitud,
			int dificultad, ArrayList<AutomovilJugador> listaJugadores) {
		super();
		this.disenio = disenio;
		this.limiteIzquierdo = limiteIzquierdo;
		this.limiteDerecho = limiteDerecho;
		this.puntosOtorgados = puntosOtorgados;
		this.longitud = longitud;
		this.dificultad = dificultad;
		this.listaJugadores = listaJugadores;
		this.segmentos = (int) (longitud / longitudSegmento);

		setearObstaculos();
		setearAutosBot();
	}

	public double getLimiteIzquierdo() {
		return limiteIzquierdo;
	}

	public double getLimiteDerecho() {
		return limiteDerecho;
	}

	public int getDificultad() {
		return dificultad;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setearObstaculos() {
		for (int i = 1; i <= segmentos; i++) {

			double x = Math.random() * (limiteDerecho - limiteIzquierdo) + limiteIzquierdo;
			double y = i * longitudSegmento - 2; // aparece al menos un obstaculo por segmento
			//listaObstaculos.add(new Obstaculo(1, new Punto(x, y)));
		}
	}

	public void setearAutosBot() {

		for (int i = 1; i <= segmentos; i++) {

			double x = Math.random() * (limiteDerecho - limiteIzquierdo) + limiteIzquierdo;
			double y = i * longitudSegmento; // aparece al menos un bot por segmento
			listaBots.add(new AutomovilBot(1, new Punto(x, y)));
		}
	}
}