package fr.octo.puissance4;

public class App {
    private IEcran ecran;
    private Arbitre arbitre;
    private IClavier clavier;

    public App(IEcran ecran, Arbitre arbitre, IClavier clavier) {
        this.ecran = ecran;
        this.arbitre = arbitre;
        this.clavier = clavier;
    }

    public void demarrer() {
        String joueur = arbitre.aQuiLeTour() == CouleurPion.Jaune ? "Jaune" : "Rouge";
        ecran.ecrireJoueurCourrant(joueur);
        arbitre.accepterCoup(Integer.parseInt(clavier.lire()));
    }
}
