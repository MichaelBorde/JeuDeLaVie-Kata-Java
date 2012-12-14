package modeleDuDomaine;

import java.util.List;

import outil.Fonction;

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

	public Cellule evolue(List<Cellule> cellules) {
		return etat.creeCelluleEvoluee(cellules);
	}

	public void prendsPartALEvolution(Fonction siVivante) {
		etat.prendsPartALEvolution(siVivante);
	}

	public List<Cellule> ajouteToiAuxVivantes(List<Cellule> vivantes) {
		return etat.ajouteAuxVivantes(this, vivantes);
	}

	private final EtatCellule etat;
}
