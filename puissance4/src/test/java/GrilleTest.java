import fr.octo.puissance4.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GrilleTest {

    @Test
    public void doit_mettre_le_pion_rouge_en_bas_de_la_grille_si_le_pion_est_mis_dans_une_colonne_vide() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        assertEquals(CouleurPion.Rouge, grille.couleurCase(0, 0));
    }

    @Test
    public void doit_mettre_le_pion_jaune_en_bas_de_la_grille_si_le_pion_est_mis_dans_une_colonne_vide() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Jaune);
        assertEquals(CouleurPion.Jaune, grille.couleurCase(0, 0));
    }

    @Test
    public void doit_laiser_la_case_au_dessus_du_pion_inserer_vide() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        assertEquals(CouleurPion.Vide, grille.couleurCase(0, 1));
    }

    @Test
    public void doit_mettre_le_pion_au_dessus_d_un_autre_pion() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        assertEquals(CouleurPion.Rouge, grille.couleurCase(0, 1));
    }

    @Test
    public void doit_mettre_un_maximum_de_poins_dans_une_colonne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Jaune);
        assertEquals(CouleurPion.Jaune, grille.couleurCase(0, 5));
    }

    @Test(expected = ColonnePleineException.class)
    public void ne_doit_pas_mettre_plus_que_le_maximum_de_pions_dans_une_colonne() throws ColonnePleineException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Rouge);
        grille.insererPion(0, CouleurPion.Jaune);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ne_doit_pas_inserer_une_couleur_vide_dans_une_colonne() throws ColonnePleineException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Vide);
    }

    @Test(expected = CaseInexistanteException.class)
    public void ne_peut_pas_renvoyer_une_couleur_de_pion_qui_depasse_la_taille_maximal_dans_une_colonne() throws CaseInexistanteException {
        Grille grille = new Grille();
        grille.couleurCase(0, 6);
    }

    @Test
    public void doit_inserer_dans_la_premiere_colonne_et_la_deuxieme_doit_rester_vide() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(0, CouleurPion.Rouge);
        assertEquals(CouleurPion.Vide, grille.couleurCase(1, 0));
    }

    @Test
    public void doit_inserer_sur_la_deuxieme_colonne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(1, CouleurPion.Rouge);
        assertEquals(CouleurPion.Rouge, grille.couleurCase(1, 0));
    }

    @Test
    public void doit_inserer_sur_la_derniere_colonne() throws ColonnePleineException, CaseInexistanteException {
        Grille grille = new Grille();
        grille.insererPion(6, CouleurPion.Jaune);
        assertEquals(CouleurPion.Jaune, grille.couleurCase(6, 0));
    }

    @Test(expected = ColonneInexistanteException.class)
    public void ne_doit_pas_inserer_au_dela_de_la_derniere_colonne() throws ColonnePleineException {
        Grille grille = new Grille();
        grille.insererPion(7, CouleurPion.Jaune);
    }

    @Test(expected = ColonneInexistanteException.class)
    public void ne_doit_pas_inserer_avant_la_premiere_colonne() throws ColonnePleineException {
        Grille grille = new Grille();
        grille.insererPion(-1, CouleurPion.Jaune);
    }

    @Test(expected = CaseInexistanteException.class)
    public void ne_doit_pas_renvoyer_une_case_avant_la_premiere_colonne() throws CaseInexistanteException {
        Grille grille = new Grille();
        grille.couleurCase(-1, 0);
    }

    @Test(expected = CaseInexistanteException.class)
    public void ne_doit_pas_renvoyer_une_case_apres_la_derniere_colonne() throws CaseInexistanteException {
        Grille grille = new Grille();
        grille.couleurCase(7, 0);
    }

    @Test(expected = CaseInexistanteException.class)
    public void ne_doit_pas_renvoyer_une_case_avant_la_premiere_ligne() throws CaseInexistanteException {
        Grille grille = new Grille();
        grille.couleurCase(0, -1);
    }

}
