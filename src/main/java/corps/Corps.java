package corps;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import outil.Point;

public class Corps {

	public Corps(Point... points) {
		this(Arrays.asList(points));
	}

	public Corps(List<Point> points) {
		for (Point point : points) {
			cellules.ajoute(point, new Cellule(true));
		}
	}

	public Corps suivant() {
		List<Point> cellulesSuivantes = Lists.newArrayList();
		Set<Point> celluleEtVoisines = celluleEtVoisines();
		for (Point position : celluleEtVoisines) {
			Cellule evolution = celluleEvoluee(position);
			if (evolution.estVivante()) {
				cellulesSuivantes.add(position);
			}
		}
		return new Corps(cellulesSuivantes);
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
