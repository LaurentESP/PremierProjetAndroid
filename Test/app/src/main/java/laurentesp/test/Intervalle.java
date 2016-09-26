package laurentesp.test;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by SOEOSSA on 26/09/2016.
 */

public class Intervalle {
    private int inf;
    private int sup;


    public Intervalle(int inf, int sup) {

            // Check if the user has reversed the inf and the sup during the call of the object
            if (inf < sup) {
                this.inf = inf;
                this.sup = sup;
            } else {
                this.inf = sup;
                this.sup = inf;
            }

    }

    public int getBorneInf() {
        return inf;
    }

    public int getBorneSup() {
        return sup;
    }

    public boolean contient(int x) {
        if ((x >= inf) && (x <= sup)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contient(Intervalle i) {
        if ((i.getBorneInf() >= inf) && (i.getBorneSup() <= sup)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean estDisjointDe(Intervalle i) {
        if ((i.getBorneSup() < inf) || (i.getBorneInf() > sup)){
            return true;
        } else {
            return false;
        }
    }

    public boolean intersecte(Intervalle i) {
        return !(this.estDisjointDe(i));
    }

    public Intervalle intersection(Intervalle i) {
        if (this.intersecte(i)) {
            Intervalle intervInter = new Intervalle(0,1);
            intervInter.inf = max(inf,i.getBorneInf());
            intervInter.sup = min(sup,i.getBorneSup());
            return intervInter;
        } else {
            return null;
        }
    }

    public Intervalle union(Intervalle i) {
        if (this.intersecte(i)) {
            Intervalle intervUnion = new Intervalle(0,1);
            intervUnion.inf= min(inf,i.getBorneInf());
            intervUnion.sup= max(sup,i.getBorneSup());
            return intervUnion;
        } else {
            return null;
        }
    }

    public boolean equals(Intervalle i) {
        if ((inf == i.getBorneInf()) && (sup == i.getBorneSup())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "["+ Integer.toString(inf) + ", " + Integer.toString(sup) + "]";
    }
}
