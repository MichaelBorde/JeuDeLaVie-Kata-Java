package corps;

public class Cellule {

	public static Cellule vivante() {
		return new Cellule(true);
	}

	public static Cellule morte() {
		return new Cellule(false);
	}

	Cellule(boolean vivante) {
		this.vivante = vivante;
	}

	public Cellule cloneToi() {
		return new Cellule(vivante);
	}

	public boolean estVivante() {
		return vivante;
	}

	public Cellule evolue(int voisinesVivantes) {
		return new Cellule(capableDeSurvivre(voisinesVivantes));
	}

	private boolean capableDeSurvivre(int voisinesVivantes) {
		if (vivante) {
			return voisinesVivantes >= 2 && voisinesVivantes <= 3;
		}
		return voisinesVivantes == 3;
	}

	private boolean vivante;
}
