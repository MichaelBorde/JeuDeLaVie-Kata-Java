package modeleDuDomaine;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
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
		return Lists.newArrayList(Iterables.filter(voisines, new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.etat == EtatCellule.VIVANTE;
			}
		})).size();
	}

	public void prendsPartALEvolution(Fonction siVivante) {
		etat.prendsPartALEvolution(siVivante);
	}

	private final EtatCellule etat;
}
