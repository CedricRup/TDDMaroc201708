import fr.octo.puissance4.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnalyseurTest {


    @Test
    public void quatre_pions_rouges_consecutifs_dans_1ere_colonne_rouge_gagne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);

        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.Rouge, analyseur.gagnant(grille));
    }


    @Test
    public void quatre_pions_jaunes_consecutifs_dans_1ere_colonne_jaune_gagne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);

        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.Jaune, analyseur.gagnant(grille));
    }

    @Test
    public void trois_pions_jaunes_consecutifs_dans_1ere_colonne_pas_de_gagnant() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);

        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.PasDeGagnant, analyseur.gagnant(grille));
    }

    @Test
    public void quatre_pions_jaunes_non_consecutifs_dans_1ere_colonne_pas_de_gagnant() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);


        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.PasDeGagnant, analyseur.gagnant(grille));
    }


    @Test
    public void un_pion_rouge_quatre_pions_jaunes_jaune_qui_gagne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);


        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.Jaune, analyseur.gagnant(grille));
    }

    @Test
    public void deux_pion_rouge_quatre_pions_jaunes_jaune_qui_gagne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);


        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.Jaune, analyseur.gagnant(grille));
    }

    @Test
    public void trois_pions_rouges_trois_pions_jaunes_personne_ne_gagne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);


        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.PasDeGagnant, analyseur.gagnant(grille));
    }

    @Test
    public void quatre_pions_rouges_consecutifs_dans_2eme_colonne_rouge_gagne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(1, CouleurPion.Rouge);
        grille.insererPion(1, CouleurPion.Rouge);
        grille.insererPion(1, CouleurPion.Rouge);
        grille.insererPion(1, CouleurPion.Rouge);

        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.Rouge, analyseur.gagnant(grille));
    }

    @Test
    public void quatre_pions_jaunes_consecutifs_dans_derniere_colonne_jaune_gagne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(6, CouleurPion.Jaune);
        grille.insererPion(6, CouleurPion.Jaune);
        grille.insererPion(6, CouleurPion.Jaune);
        grille.insererPion(6, CouleurPion.Jaune);

        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.Jaune, analyseur.gagnant(grille));
    }


    @Test
    public void quatre_pions_jaunes_consecutifs_dans_la_premiere_colonne_et_trois_pions_dans_la_deuxieme() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(0, CouleurPion.Jaune);
        grille.insererPion(1, CouleurPion.Rouge);
        grille.insererPion(1, CouleurPion.Jaune);
        grille.insererPion(1, CouleurPion.Rouge);

        Analyseur analyseur = new Analyseur();
        assertEquals(CouleurGagnant.Jaune, analyseur.gagnant(grille));
    }


}
