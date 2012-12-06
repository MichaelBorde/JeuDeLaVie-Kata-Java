package corps;

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
		for (int iCourant = -1; iCourant < 2; iCourant++) {
			for (int jCourant = -1; jCourant < 2; jCourant++) {
				if (iCourant != 0 || jCourant != 0) {
					resultat.add(cellule(new Point(position.x() + iCourant, position.y() + jCourant)));
				}
			}
		}
		return resultat;
	}

	public Set<Point> positions() {
		return cellules.keySet();
	}

	public static List<Point> positionsVoisines(Point point) {
		List<Point> resultat = Lists.newArrayList();
		for (int iCourant = -1; iCourant < 2; iCourant++) {
			for (int jCourant = -1; jCourant < 2; jCourant++) {
				if (iCourant != 0 || jCourant != 0) {
					resultat.add(new Point(point.x() + iCourant, point.y() + jCourant));
				}
			}
		}
		return resultat;
	}

	private Map<Point, Cellule> cellules = Maps.newHashMap();
}
