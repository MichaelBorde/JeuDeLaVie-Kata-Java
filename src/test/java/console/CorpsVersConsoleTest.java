package console;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import corps.Corps;

public class CorpsVersConsoleTest {

	@Before
	public void avant() {
		corps = new Corps();
		console = mock(Console.class);
		corpsVersConsole = new CorpsVersConsole();
		corpsVersConsole.console = console;
	}

	@Test
	public void peutEcrireDansLaConsoleUnCorpsSimple() {
		corps.ajouteCellule(0, 0, true);

		corpsVersConsole.ecris(corps);

		verify(console).ecris("x");
	}

	@Test
	public void peutEcrireDansLaConsoleUnCorpsAvecPlusieursCellulesSurLaMemeHauteur() {
		corps.ajouteCellule(0, 0, true);
		corps.ajouteCellule(1, 0, true);

		corpsVersConsole.ecris(corps);

//		verify(console).ecris("xx");
	}

	private Corps corps;
	private Console console;
	private CorpsVersConsole corpsVersConsole;
}
