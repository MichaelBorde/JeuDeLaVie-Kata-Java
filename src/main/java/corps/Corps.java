package corps;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import outil.Point;

public class Corps {

	public void ajouteCellule(int i, int j, boolean vivante) {
		cellules.ajoute(i, j, new Cellule(vivante));
	}

	public Corps suivant() {
		Corps suivant = new Corps();
		for (Point position : cellules.positions()) {
			Cellule evolution = celluleEvoluee(position.x, position.y);
			suivant.ajouteCellule(position.x, position.y, evolution.estVivante());
		}
		return suivant;
	}

	private Cellule celluleEvoluee(int i, int j) {
		Cellule cellule = cellule(i, j).cloneToi();
		return cellule.evolue(nombreVoisinesVivantes(i, j));
	}

	private int nombreVoisinesVivantes(int i, int j) {
		return Lists.newArrayList(Iterables.filter(cellules.voisines(i, j), new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.estVivante();
			}
		})).size();
	}

	public Cellule cellule(int i, int j) {
		return cellules.cellule(i, j);
	}

	private Cellules cellules = new Cellules();
}
