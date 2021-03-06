package modeleDuDomaine;

import java.util.List;

public class Cellule {

	public static Cellule creeVivante() {
		return new Cellule(EtatCellule.VIVANTE);
	}

	public static Cellule creeMorte() {
		return new Cellule(EtatCellule.MORTE);
	}

	private Cellule(EtatCellule etat) {
		this.etat = etat;
	}

	public Cellule evolue(List<Cellule> voisines) {
		return etat.creeCelluleEvoluee(voisines);
	}

	public List<Cellule> ajouteToiAuxVivantes(List<Cellule> vivantes) {
		return etat.ajouteAuxVivantes(this, vivantes);
	}

	private final EtatCellule etat;
}
