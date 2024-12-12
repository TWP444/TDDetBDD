import org.example.Etudiant;
import org.example.Evaluation;
import org.example.Matiere;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculMoyenneTest {

    @Test
    public void testCalculeMoyenneMatiere() {
        Matiere math = new Matiere("MAT101", "Mathématiques");
        math.ajouterEvaluation(new Evaluation(15.5f));
        math.ajouterEvaluation(new Evaluation(12.0f));
        math.ajouterEvaluation(new Evaluation(17.0f));

        float moyenne = math.calculeMoyenne();
        assertEquals(14.83, moyenne, 0.01); // Test avec une précision de 0.01
    }

    @Test
    public void testCalculeMoyenneGeneraleEtudiant() {
        Etudiant etudiant = new Etudiant(2024);

        Matiere math = new Matiere("MAT101", "Mathématiques");
        math.ajouterEvaluation(new Evaluation(15.0f));
        math.ajouterEvaluation(new Evaluation(10.0f));

        Matiere physique = new Matiere("PHY101", "Physique");
        physique.ajouterEvaluation(new Evaluation(12.0f));
        physique.ajouterEvaluation(new Evaluation(14.0f));

        etudiant.ajouterMatiere(math);
        etudiant.ajouterMatiere(physique);

        float moyenneGenerale = etudiant.calculeMoyenneGenerale();
        assertEquals(12.75, moyenneGenerale, 0.01); // Test avec une précision de 0.01
    }
}
