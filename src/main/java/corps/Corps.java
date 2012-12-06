package corps;

import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import outil.Point;

public class Corps {

	public void ajouteCellule(Point position, boolean vivante) {
		cellules.ajoute(position, new Cellule(vivante));
	}

	public Corps suivant() {
		Corps suivant = new Corps();
		Set<Point> celluleEtVoisines = celluleEtVoisines();
		for (Point position : celluleEtVoisines) {
			Cellule evolution = celluleEvoluee(position);
			suivant.ajouteCellule(position, evolution.estVivante());
		}

		return suivant;
	}

	private Set<Point> celluleEtVoisines() {
		Set<Point> celluleEtVoisines = Sets.newHashSet();
		for (Point position : cellules.positionsVivantes()) {
			celluleEtVoisines.addAll(position.pointsAutour());
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

	private final Cellules cellules = new Cellules();
}
