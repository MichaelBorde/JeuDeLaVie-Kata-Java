package outil;

import java.util.List;

import com.google.common.collect.Lists;

public class Point {

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public List<Point> pointsAutour() {
		List<Point> resultat = Lists.newArrayList();
		for (int decalageX = -1; decalageX < 2; decalageX++) {
			resultat.addAll(pointsVerticaux(decalageX));
		}
		resultat.remove(this);
		return resultat;
	}

	private List<Point> pointsVerticaux(int decalageX) {
		List<Point> resultat = Lists.newArrayList();
		for (int yCourant = -1; yCourant < 2; yCourant++) {
			resultat.add(new Point(x + decalageX, y + yCourant));
		}
		return resultat;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return 31 * x + y;
	}

	private final int x;
	private final int y;
}
