package modeleDuDomaine;

import java.util.List;

import com.google.common.collect.Lists;

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
		return etat.creeCelluleEvoluee(nombreVoisinesVivantes(cellules));
	}

	private int nombreVoisinesVivantes(List<Cellule> voisines) {
		List<Cellule> vivantes = Lists.newArrayList();
		for (Cellule voisine : voisines) {
			vivantes = voisine.etat.ajouteToiAuxVivantes(this, vivantes);
		}
		return vivantes.size();
	}

	public void prendsPartALEvolution(Fonction siVivante) {
		etat.prendsPartALEvolution(siVivante);
	}

	private final EtatCellule etat;
}
