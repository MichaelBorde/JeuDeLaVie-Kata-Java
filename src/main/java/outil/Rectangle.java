package outil;

import com.google.common.base.Objects;

public class Rectangle {

	public Rectangle(int xOrigine, int yOrigine, int hauteur, int largeur) {
		this.xOrigine = xOrigine;
		this.yOrigine = yOrigine;
		this.hauteur = hauteur;
		this.largeur = largeur;
	}

	public int getxOrigine() {
		return xOrigine;
	}

	public int getyOrigine() {
		return yOrigine;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Rectangle rectangle = (Rectangle) o;

		if (hauteur != rectangle.hauteur) return false;
		if (largeur != rectangle.largeur) return false;
		if (xOrigine != rectangle.xOrigine) return false;
		if (yOrigine != rectangle.yOrigine) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = xOrigine;
		result = 31 * result + yOrigine;
		result = 31 * result + hauteur;
		result = 31 * result + largeur;
		return result;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(xOrigine).addValue(yOrigine).addValue(hauteur).addValue
				(largeur).toString();
	}

	private final int xOrigine;
	private final int yOrigine;
	private final int hauteur;
	private final int largeur;
}
