package fr.octo.puissance4;

public class EcranConsole implements IEcran {
    @Override
    public void ecrireJoueurCourrant(String joueur) {
        System.out.println(joueur);
    }
}
