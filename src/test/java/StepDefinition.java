import io.cucumber.java.en.*;
import org.example.Etudiant;
import org.example.Evaluation;
import org.example.Matiere;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class StepDefinition {

    private Matiere matiere;
    private List<Matiere> matieres = new ArrayList<>();
    private List<Etudiant> etudiants = new ArrayList<>();

    // US1
    @Given("une matière {string} avec le code {string}")
    public void une_matiere_avec_le_code(String nom, String code) {
        matiere = new Matiere(code, nom);
    }

    @When("je saisis les notes {double}, {double} et {double}")
    public void je_saisis_les_notes(double note1, double note2, double note3) {
        matiere.ajouterEvaluation(new Evaluation((float) note1));
        matiere.ajouterEvaluation(new Evaluation((float) note2));
        matiere.ajouterEvaluation(new Evaluation((float) note3));
    }

    @Then("la moyenne de la matière {string} est {double}")
    public void la_moyenne_de_la_matiere_est(String nom, double moyenneAttendue) {
        assertEquals(moyenneAttendue, matiere.calculeMoyenne(), 0.01);
    }

    // US2
    @Given("une matière {string} avec les notes {double} et {double}")
    public void une_matiere_avec_les_notes(String nom, double note1, double note2) {
        Matiere nouvelleMatiere = new Matiere(nom, nom);
        nouvelleMatiere.ajouterEvaluation(new Evaluation((float) note1));
        nouvelleMatiere.ajouterEvaluation(new Evaluation((float) note2));
        matieres.add(nouvelleMatiere);
    }

    @When("je consulte les moyennes de toutes les matières")
    public void je_consulte_les_moyennes_de_toutes_les_matieres() {
        // Les moyennes sont calculées dans les méthodes de la classe Matiere
    }

    @Then("la moyenne de {string} est {double}")
    public void la_moyenne_de_est(String nom, double moyenneAttendue) {
        Matiere matiereTrouvee = matieres.stream().filter(m -> m.getNom().equals(nom)).findFirst().orElse(null);
        assertNotNull(matiereTrouvee);
        assertEquals(moyenneAttendue, matiereTrouvee.calculeMoyenne(), 0.01);
    }

    // US3
    @Given("un étudiant {string} avec une moyenne générale de {double}")
    public void un_etudiant_avec_une_moyenne_generale_de(String nom, double moyenne) {
        Etudiant etudiant = new Etudiant(2024);
        // Simuler la moyenne en créant une matière avec une seule note correspondant à la moyenne générale
        Matiere matiereSimulee = new Matiere("SIM", "Simulation");
        matiereSimulee.ajouterEvaluation(new Evaluation((float) moyenne));
        etudiant.ajouterMatiere(matiereSimulee);
        etudiants.add(etudiant);
    }

    @When("je consulte le classement des étudiants")
    public void je_consulte_le_classement_des_etudiants() {
        etudiants.sort((e1, e2) -> Float.compare(e2.calculeMoyenneGenerale(), e1.calculeMoyenneGenerale()));
    }

    @Then("le {int}e étudiant est {string} avec une moyenne de {double}")
    public void le_ete_etudiant_est_avec_une_moyenne_de(int rang, String nom, double moyenneAttendue) {
        Etudiant etudiant = etudiants.get(rang - 1);
        assertEquals(moyenneAttendue, etudiant.calculeMoyenneGenerale(), 0.01);
    }
}
