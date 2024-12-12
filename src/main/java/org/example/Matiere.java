package org.example;
import java.util.ArrayList;
import java.util.List;

public class Matiere {
    private String code;
    private String nom;
    private List<Evaluation> evaluations;

    public Matiere(String code, String nom) {
        this.code = code;
        this.nom = nom;
        this.evaluations = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void ajouterEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }

    public float calculeMoyenne() {
        if (evaluations.isEmpty()) return 0;  // Retourne 0 si aucune évaluation
        float somme = 0;
        for (Evaluation eval : evaluations) {
            somme += eval.getNote();
        }
        return somme / evaluations.size();
    }
}
