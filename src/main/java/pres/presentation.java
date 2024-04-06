package pres;

import Metier.MetierImpl;
import ext.DaoImpl2;

public class presentation {
    public static void main(String[] args) {

        /*/
        instanciation statique :
         */
        //DaoImpl dao=new DaoImpl();// creer un objet dao
       DaoImpl2 dao=new DaoImpl2();
        MetierImpl metier = new MetierImpl(dao);// creer un objet metier
        // le new a eliminer (new=couplage fort=> poubelle)
       // metier.setDao(dao);// associer les 2 objets crees
        System.out.println(metier.calcul());
    }
}