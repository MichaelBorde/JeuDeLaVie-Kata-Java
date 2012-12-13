package modeleDuDomaine;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import outil.Fonction;

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

	public Cellule evolue(List<Cellule> cellules) {
		return new Cellule(capableDeSurvivre(nombreVoisinesVivantes(cellules)));
	}

	private int nombreVoisinesVivantes(List<Cellule> voisines) {
		return Lists.newArrayList(Iterables.filter(voisines, new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.vivante;
			}
		})).size();
	}

	public void prendsPartALEvolution(Fonction enCasDeSurvie) {
		if (vivante) {
			enCasDeSurvie.appelle();
		}
	}

	private boolean capableDeSurvivre(int voisinesVivantes) {
		if (vivante) {
			return voisinesVivantes >= 2 && voisinesVivantes <= 3;
		}
		return voisinesVivantes == 3;
	}

	private final boolean vivante;
}
