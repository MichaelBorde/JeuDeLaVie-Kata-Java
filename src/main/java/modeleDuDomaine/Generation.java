package modeleDuDomaine;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import outil.Point;

public class Generation {

	public Generation(Point... points) {
		this(Arrays.asList(points));
	}

	public Generation(List<Point> points) {
		for (Point point : points) {
			cellules.ajoute(point, new Cellule(true));
		}
	}

	public Generation creeSuivante() {
		List<Point> cellulesSuivantes = Lists.newArrayList();
		Set<Point> celluleEtVoisines = donneCelluleEtVoisines();
		for (Point position : celluleEtVoisines) {
			Cellule evolution = creeCelluleEvoluee(position);
			if (evolution.estVivante()) {
				cellulesSuivantes.add(position);
			}
		}
		return new Generation(cellulesSuivantes);
	}

	private Set<Point> donneCelluleEtVoisines() {
		Set<Point> celluleEtVoisines = Sets.newHashSet();
		for (Point position : cellules.positionsVivantes()) {
			celluleEtVoisines.addAll(position.pointsAutour());
			celluleEtVoisines.add(position);
		}
		return celluleEtVoisines;
	}

	private Cellule creeCelluleEvoluee(Point position) {
		Cellule cellule = donneCellule(position).cloneToi();
		return cellule.evolue(calculeNombreVoisinesVivantes(position));
	}

	private int calculeNombreVoisinesVivantes(Point position) {
		return Lists.newArrayList(Iterables.filter(cellules.voisines(position), new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.estVivante();
			}
		})).size();
	}

	public Cellule donneCellule(Point position) {
		return cellules.cellule(position);
	}

	private final Cellules cellules = new Cellules();
}
