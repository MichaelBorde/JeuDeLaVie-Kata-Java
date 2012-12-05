package outil;

import static org.fest.assertions.Assertions.*;

import org.junit.Test;

public class TestPoint {

	@Test
	public void deuxPointsDifferentsOntUnHashcodeDifferent() {
		Point point = new Point(1, 3);
		Point autrePoint = new Point(4, 9);

		assertThat(point.hashCode()).isNotEqualTo(autrePoint.hashCode());
	}

	@Test
	public void deuxPointsEgauxLeSontVraiment() {
		Point point = new Point(1, 3);
		Point autrePoint = new Point(1, 3);

		assertThat(point).isEqualTo(autrePoint);
	}

	@Test
	public void deuxPointsDifferentsLeSontVraiment() {
		Point point = new Point(1, 3);
		Point autrePoint = new Point(2, 3);
		Point autrePointEncore = new Point(1, 4);

		assertThat(point).isNotEqualTo(autrePoint);
		assertThat(point).isNotEqualTo(autrePointEncore);
	}
}
