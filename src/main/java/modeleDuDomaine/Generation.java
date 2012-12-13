package modeleDuDomaine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import outil.Fonction;
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
		final List<Point> cellulesSuivantes = Lists.newArrayList();
		Set<Point> celluleEtVoisines = celluleEtVoisines();
		for (final Point position : celluleEtVoisines) {
			Cellule cellule = celluleA(position);
			Cellule evolution = cellule.evolue(voisinesAutour(position));
			evolution.prendsPartALEvolution(new Fonction() {
				@Override
				public void appelle() {
					cellulesSuivantes.add(position);
				}
			});
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
