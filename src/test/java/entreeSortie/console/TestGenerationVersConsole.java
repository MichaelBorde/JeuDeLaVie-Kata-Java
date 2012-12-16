package entreeSortie.console;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import modeleDuDomaine.Generation;
import outil.Point;

public class TestGenerationVersConsole {

	@Before
	public void avant() {
		console = mock(Console.class);
		generationVersConsole = new GenerationVersConsole(console);
	}

	@Test
	public void peutEcrireDansLaConsoleUnGenerationSimple() {
		Generation generation = new Generation(new Point(0, 0));

		generationVersConsole.ecris(generation, 10);

		verify(console).ecris("x.........");
	}

	@Test
	public void peutEcrireDansLaConsoleUnGenerationAvecPlusieursCellulesSurLaMemeHauteur() {
		Generation generation = new Generation(new Point(0, 0), new Point(1, 0));

		generationVersConsole.ecris(generation, 10);

		verify(console).ecris("xx........");
	}

	@Test
	public void ilEstPossibleDeSpecifierUneTailleDeGrille() {
		Generation generation = new Generation();
		generationVersConsole = new GenerationVersConsole(console);

		generationVersConsole.ecris(generation, 3);

		verify(console, times(3)).ecris("...");
	}

	private Console console;
	private GenerationVersConsole generationVersConsole;
}
