package modeleDuDomaine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import outil.Point;

public class Generation {

	public Generation(Point... points) {
		this(Arrays.asList(points));
	}

	public Generation(List<Point> points) {
		for (Point point : points) {
			cellules.put(point, new Cellule(true));
		}
	}

	public Set<Point> positionsVivantes() {
		return cellules.keySet();
	}

	public Generation creeSuivante() {
		List<Point> cellulesSuivantes = Lists.newArrayList();
		Set<Point> celluleEtVoisines = celluleEtVoisines();
		for (Point position : celluleEtVoisines) {
			Cellule evolution = creeCelluleEvoluee(position);
			if (evolution.estVivante()) {
				cellulesSuivantes.add(position);
			}
		}
		return new Generation(cellulesSuivantes);
	}

	private Set<Point> celluleEtVoisines() {
		Set<Point> celluleEtVoisines = Sets.newHashSet();
		for (Point position : positionsVivantes()) {
			celluleEtVoisines.addAll(position.pointsAutour());
			celluleEtVoisines.add(position);
		}
		return celluleEtVoisines;
	}

	private Cellule creeCelluleEvoluee(Point position) {
		Cellule cellule = celluleA(position);
		return cellule.evolue(nombreVoisinesVivantes(position));
	}

	private int nombreVoisinesVivantes(Point position) {
		return Lists.newArrayList(Iterables.filter(voisinesAutour(position), new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.estVivante();
			}
		})).size();
	}

	private Cellule celluleA(Point position) {
		if (!cellules.containsKey(position)) {
			return Cellule.creeMorte();
		}
		return cellules.get(position);
	}

	private List<Cellule> voisinesAutour(Point position) {
		List<Cellule> resultat = Lists.newArrayList();
		for (Point positionVoisine : position.pointsAutour()) {
			resultat.add(celluleA(positionVoisine));
		}
		return resultat;
	}

	private final Map<Point, Cellule> cellules = Maps.newHashMap();
}
