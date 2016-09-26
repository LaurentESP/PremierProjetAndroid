package laurentesp.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SOEOSSA on 26/09/2016.
 */

public class Client {
    private String nom;
    private String prenom;
    private List<Compte> comptes;


    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        comptes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String nomComplet() {
        return nom + " " + prenom;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", comptes=" + comptes +
                '}';
    }
}
