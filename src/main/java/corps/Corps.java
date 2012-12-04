package corps;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import outil.Point;
import outil.Rectangle;

public class Corps {

	public void ajouteCellule(int i, int j, boolean vivante) {
		cellules.ajoute(i, j, new Cellule(vivante));
	}

	public Corps suivant() {
		Corps suivant = new Corps();
		for (Point position : cellules.positions()) {
			Cellule evolution = celluleEvoluee(position.x, position.y);
			suivant.ajouteCellule(position.x, position.y, evolution.estVivante());
		}
		return suivant;
	}

	private Cellule celluleEvoluee(int i, int j) {
		Cellule cellule = cellule(i, j).cloneToi();
		return cellule.evolue(nombreVoisinesVivantes(i, j));
	}

	private int nombreVoisinesVivantes(int i, int j) {
		return Lists.newArrayList(Iterables.filter(cellules.voisines(i, j), new Predicate<Cellule>() {
			@Override
			public boolean apply(Cellule cellule) {
				return cellule.estVivante();
			}
		})).size();
	}

	public Cellule cellule(int i, int j) {
		return cellules.cellule(i, j);
	}

	public Rectangle boite() {
		if(cellules.positions().size() == 0){
			return new Rectangle(0, 0, 0, 0);
		}
		return boiteNonVide();
	}

	private Rectangle boiteNonVide() {
		Integer iMin = null;
		Integer iMax = null;
		Integer jMin = null;
		Integer jMax = null;
		for (Point position : cellules.positions()) {
			iMin = iMin == null || position.x() < iMin ? position.x() : iMin;
			iMax = iMax == null || position.x() > iMax ? position.x() : iMax;
			jMin = jMin == null || position.y() < jMin ? position.y() : jMin;
			jMax = jMax == null || position.y() > jMax ? position.y() : jMax;
		}
		return new Rectangle(iMin, jMin, iMax - iMin + 1, jMax - jMin + 1);
	}

	private Cellules cellules = new Cellules();
}
