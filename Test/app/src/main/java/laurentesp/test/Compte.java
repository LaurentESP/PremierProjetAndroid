package laurentesp.test;

/**
 * Created by SOEOSSA on 26/09/2016.
 */

public class Compte {
    public static int nbComptes = 0;
    private int numero;
    private double solde;
    private Client clientCompte;

    public Compte(Client clientCompte) {
        this.clientCompte = clientCompte;
        this.solde = 0;
        this.numero = nbComptes;
        nbComptes++;
    }

    public Compte(Client clientCompte, double depot) {
        this.clientCompte = clientCompte;
        this.solde = depot;
        nbComptes++;
    }

    public int getNumero() {
        return numero;
    }

    public Client getClientCompte() {
        return clientCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void credite(double montant) {
        solde += montant;
    }

    public void debite (double montant) {
        solde -= montant;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "numero=" + numero +
                ", solde=" + solde +
                ", clientCompte=" + clientCompte +
                '}';
    }
}
