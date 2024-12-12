package org.example;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private int annee;
    private List<Matiere> matieres;

    public Etudiant(int annee) {
        this.annee = annee;
        this.matieres = new ArrayList<>();
    }

    public void ajouterMatiere(Matiere matiere) {
        matieres.add(matiere);
    }

    public float calculeMoyenneGenerale() {
        if (matieres.isEmpty()) return 0;  // Retourne 0 si aucune matière
        float sommeMoyennes = 0;
        for (Matiere matiere : matieres) {
            sommeMoyennes += matiere.calculeMoyenne();
        }
        return sommeMoyennes / matieres.size();
    }
}
