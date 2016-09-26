package laurentesp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SOEOSSA on 26/09/2016.
 */

public class Banque {
    private Map<String,Client> clientsBanque;
    private List<Compte> comptesBanque;

    public Banque() {
        //clientsBanque = new ArrayList<>();
        Map<String,Client> clientsBanque = new HashMap<>();
        comptesBanque = new ArrayList<>();
    }

    public Map<String,Client> getClientsBanque() {
        return clientsBanque;
    }

    public List<Compte> getComptesBanque() {
        return comptesBanque;
    }

    public Client getClient(String nom, String prenom){
        return clientsBanque.get("nom" + " "+ "prenom");
    }

    public Compte getCompte(Integer num){
        return comptesBanque.get(num);
    }

    public Client ajouteClient(Client client){
        clientsBanque.put(client.nomComplet(),client);
        return client;
    }

    public Client ajouteClient(String nom, String prenom) {
        Client nouveauClient = new Client(nom,prenom);
        clientsBanque.put(nom + " "+ prenom, nouveauClient);
        return nouveauClient;
    }

    public boolean supprimeClient(Client client) {
        if (clientsBanque.get(client.nomComplet())!=null){
            clientsBanque.remove(client.nomComplet());
            return true;
        } else {
            return false;
        }
    }

    public boolean supprimeClient(String nom, String prenom){
        String nomComplet = nom + " "+prenom;
        if (clientsBanque.get(nomComplet)!=null){
            clientsBanque.remove(nomComplet);
            return true;
        } else {
            return false;
        }
    }
    public Compte ouvreCompte (Client client){
        Compte nouveauCompte = new Compte(client);
        comptesBanque.add(nouveauCompte);
        return nouveauCompte;
    }

    public Compte ouvreCompte(Client client, double depot) {
        Compte nouveauCompte = new Compte(client, depot);
        comptesBanque.add(nouveauCompte);
        return nouveauCompte;
    }

    public Compte ouvreCompte(String nom, String prenom) {
        String nomComplet = nom + " " + prenom;
        Compte nouveauCompte = new Compte(clientsBanque.get(nomComplet));
        return nouveauCompte;
    }

    public Compte ouvreCompte(String nom, String prenom, double depot) {
        String nomComplet = nom + " " + prenom;
        Compte nouveauCompte = new Compte(clientsBanque.get(nomComplet), depot);
        return nouveauCompte;
    }

    public boolean fermeCompte(Integer num) {
        if (comptesBanque.get(num)!= null){
            comptesBanque.remove(num);
            return true;
        } else {
            return false;
        }
    }

    public boolean fermeCompte(Compte compte) {
        int numeroCompte = compte.getNumero();

        if (comptesBanque.get(numeroCompte)!= null){
            comptesBanque.remove(numeroCompte);
            return true;
        } else {
            return false;
        }
    }
}
