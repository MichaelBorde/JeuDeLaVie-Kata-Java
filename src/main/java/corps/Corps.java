package corps;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import outil.Point;

public class Corps {

	public void ajouteCellule(Point position, boolean vivante) {
		cellules.ajoute(position, new Cellule(vivante));
	}

	public Corps suivant() {
		Corps suivant = new Corps();
		List<Point> celluleEtVoisines = celluleEtVoisines();
		for (Point position : celluleEtVoisines) {
			Cellule evolution = celluleEvoluee(position);
			suivant.ajouteCellule(position, evolution.estVivante());
		}

		return suivant;
	}

	private List<Point> celluleEtVoisines() {
		List<Point> celluleEtVoisines = Lists.newArrayList();
		for (Point position : cellules.positions()) {
			celluleEtVoisines.addAll(Cellules.positionsVoisines(position));
			celluleEtVoisines.add(position);
		}
		return celluleEtVoisines;
	}

	private Cellule celluleEvoluee(Point position) {
		Cellule cellule = cellule(position).cloneToi();
		return cellule.evolue(nombreVoisinesVivantes(position));
	}

	private int nombreVoisinesVivantes(Point position) {
		return Lists.newArrayList(Iterables.filter(cellules.voisines(position), new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.estVivante();
			}
		})).size();
	}

	public Cellule cellule(Point position) {
		return cellules.cellule(position);
	}

	private Cellules cellules = new Cellules();
}
