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
		for (int iCourant = -1; iCourant < 2; iCourant++) {
			for (int jCourant = -1; jCourant < 2; jCourant++) {
				if (iCourant != 0 || jCourant != 0) {
					resultat.add(new Point(x + iCourant, y + jCourant));
				}
			}
		}
		return resultat;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	private final int x;
	private final int y;
}
