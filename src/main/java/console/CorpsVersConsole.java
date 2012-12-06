package console;

import com.google.inject.Inject;

import corps.Corps;
import outil.Point;

public class CorpsVersConsole {

	@Inject
	public CorpsVersConsole(Console console) {
		this.console = console;
	}

	public void ecris(Corps corps, int taille) {
		for (int j = 0; j < taille; j++) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < taille; i++) {
				builder.append(corps.cellule(new Point(i, j)).estVivante() ? "x" : ".");
			}
			console.ecris(builder.toString());
		}
	}

	private Console console;
}
