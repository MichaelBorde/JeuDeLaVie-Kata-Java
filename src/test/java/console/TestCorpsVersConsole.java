package console;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import corps.Corps;

public class TestCorpsVersConsole {

	@Before
	public void avant() {
		corps = new Corps();
		console = mock(Console.class);
		corpsVersConsole = new CorpsVersConsole(console);
	}

	@Test
	public void peutEcrireDansLaConsoleUnCorpsSimple() {
		corps.ajouteCellule(0, 0, true);

		corpsVersConsole.ecris(corps, 10);

		verify(console).ecris("x.........");
	}

	@Test
	public void peutEcrireDansLaConsoleUnCorpsAvecPlusieursCellulesSurLaMemeHauteur() {
		corps.ajouteCellule(0, 0, true);
		corps.ajouteCellule(1, 0, true);

		corpsVersConsole.ecris(corps, 10);

		verify(console).ecris("xx........");
	}

	@Test
	public void ilEstPossibleDeSpecifierUneTailleDeGrille() {
		corpsVersConsole = new CorpsVersConsole(console);

		corpsVersConsole.ecris(corps, 3);

		verify(console, times(3)).ecris("...");
	}

	private Corps corps;
	private Console console;
	private CorpsVersConsole corpsVersConsole;
}
