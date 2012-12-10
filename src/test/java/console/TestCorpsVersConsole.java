package console;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import corps.Corps;
import outil.Point;

public class TestCorpsVersConsole {

	@Before
	public void avant() {
		console = mock(Console.class);
		corpsVersConsole = new CorpsVersConsole(console);
	}

	@Test
	public void peutEcrireDansLaConsoleUnCorpsSimple() {
		Corps corps = new Corps(new Point(0, 0));

		corpsVersConsole.ecris(corps, 10);

		verify(console).ecris("x.........");
	}

	@Test
	public void peutEcrireDansLaConsoleUnCorpsAvecPlusieursCellulesSurLaMemeHauteur() {
		Corps corps = new Corps(new Point(0, 0), new Point(1, 0));

		corpsVersConsole.ecris(corps, 10);

		verify(console).ecris("xx........");
	}

	@Test
	public void ilEstPossibleDeSpecifierUneTailleDeGrille() {
		Corps corps = new Corps();
		corpsVersConsole = new CorpsVersConsole(console);

		corpsVersConsole.ecris(corps, 3);

		verify(console, times(3)).ecris("...");
	}

	private Console console;
	private CorpsVersConsole corpsVersConsole;
}
