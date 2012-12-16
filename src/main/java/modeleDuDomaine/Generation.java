package modeleDuDomaine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import outil.Point;

public class Generation {

	public Generation(Point... points) {
		this(Arrays.asList(points));
	}

	public Generation(List<Point> points) {
		cellules = creeCellulesPositionnees(points);
	}

	private Map<Point, Cellule> creeCellulesPositionnees(List<Point> points) {
		Map<Point, Cellule> resultat = Maps.newHashMap();
		for (Point point : points) {
			resultat.put(point, Cellule.creeVivante());
		}
		return resultat;
	}

	public Set<Point> positionsVivantes() {
		return cellules.keySet();
	}

	public Generation creeSuivante() {
		return new Generation(positionsVivantesSuivantes());
	}

	private List<Point> positionsVivantesSuivantes() {
		List<Point> positionsVivantesSuivantes = Lists.newArrayList();
		for (final Point position : celluleEtVoisines()) {
			positionsVivantesSuivantes.addAll(positionsVivantesSuivantesDepuis(position));
		}
		return positionsVivantesSuivantes;
	}

	private List<Point> positionsVivantesSuivantesDepuis(final Point position) {
		Cellule cellule = celluleA(position);
		Cellule evolution = cellule.evolue(voisinesAutour(position));
		List<Cellule> cellulesAjoutees = evolution.ajouteToiAuxVivantes(new ArrayList<Cellule>());
		return Lists.transform(cellulesAjoutees, new Function<Cellule, Point>() {
			@Override
			public Point apply(Cellule cellule) {
				return position;
			}
		});
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

	private final Map<Point, Cellule> cellules;
}
