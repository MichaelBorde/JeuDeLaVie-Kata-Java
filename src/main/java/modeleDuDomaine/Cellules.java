package modeleDuDomaine;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import outil.Point;

public class Cellules {

	public void ajoute(Point position, Cellule cellule) {
		if (cellule.estVivante()) {
			cellules.put(position, cellule);
		}
	}

	public Cellule cellule(Point position) {
		if (!cellules.containsKey(position)) {
			return Cellule.morte();
		}
		return cellules.get(position);
	}

	public List<Cellule> voisines(Point position) {
		List<Cellule> resultat = Lists.newArrayList();
		for (Point positionVoisine : position.pointsAutour()) {
			resultat.add(cellule(positionVoisine));
		}
		return resultat;
	}

	public Set<Point> positionsVivantes() {
		return cellules.keySet();
	}


	private final Map<Point, Cellule> cellules = Maps.newHashMap();
}
