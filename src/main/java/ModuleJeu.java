import com.google.inject.Binder;
import com.google.inject.Module;

import entreeSortie.console.Console;
import entreeSortie.console.ConsoleJava;

public class ModuleJeu implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(Console.class).to(ConsoleJava.class);
	}
}
