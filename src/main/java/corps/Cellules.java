package corps;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import outil.Point;

public class Cellules {

	public void ajoute(int i, int j, Cellule cellule) {
		if (cellule.estVivante()) {
			cellules.put(new Point(i, j), cellule);
		}
	}

	public Cellule cellule(int i, int j) {
		if (!cellules.containsKey(new Point(i, j))) {
			return Cellule.morte();
		}
		return cellules.get(new Point(i, j));
	}

	public List<Cellule> voisines(int i, int j) {
		List<Cellule> resultat = Lists.newArrayList();
		for (int iCourant = -1; iCourant < 2; iCourant++) {
			for (int jCourant = -1; jCourant < 2; jCourant++) {
				if (iCourant != 0 || jCourant != 0) {
					resultat.add(cellule(i + iCourant, j + jCourant));
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
