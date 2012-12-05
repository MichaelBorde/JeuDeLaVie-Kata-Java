package console;

import com.google.inject.Inject;

import corps.Corps;

public class CorpsVersConsole {

	@Inject
	public CorpsVersConsole(Console console) {
		this.console = console;
	}

	public void ecris(Corps corps) {
		for (int j = 0; j < 10; j++) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 10; i++) {
				builder.append(corps.cellule(i, j).estVivante() ? "x" : ".");
			}
			console.ecris(builder.toString());
		}
	}

	private Console console;
}
