package modeleDuDomaine;

import outil.Fonction;

public enum EtatCellule {
	VIVANTE {
		@Override
		public void prendsPartALEvolution(Fonction siVivante) {
			siVivante.appelle();
		}

		@Override
		protected boolean capableDeSurvivre(int voisinesVivantes) {
			return voisinesVivantes >= 2 && voisinesVivantes <= 3;
		}
	},
	MORTE {
		@Override
		public void prendsPartALEvolution(Fonction siVivante) {
		}

		@Override
		protected boolean capableDeSurvivre(int voisinesVivantes) {
			return voisinesVivantes == 3;
		}
	};

	public abstract void prendsPartALEvolution(Fonction siVivante);

	public Cellule creeCelluleEvoluee(int nombreVoisinesVivantes) {
		if (capableDeSurvivre(nombreVoisinesVivantes)) {
			return Cellule.creeVivante();
		}
		return Cellule.creeMorte();
	}

	protected abstract boolean capableDeSurvivre(int voisinesVivantes);
}
