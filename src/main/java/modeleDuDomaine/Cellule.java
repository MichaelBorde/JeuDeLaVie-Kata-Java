package modeleDuDomaine;

public class Cellule {

	public static Cellule creeVivante() {
		return new Cellule(true);
	}

	public static Cellule creeMorte() {
		return new Cellule(false);
	}

	Cellule(boolean vivante) {
		this.vivante = vivante;
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

	private final boolean vivante;
}
