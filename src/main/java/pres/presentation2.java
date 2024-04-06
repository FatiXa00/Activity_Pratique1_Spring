package pres;


import Metier.IMetier;
import dao.IDao;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presentation2 {

    public static void main(String[] args) throws Exception {
        /*
        instanciation dynamique
        faut: 1/ connaitre le nom de la classe
        2/ charger la classe en memoire
        3/ instancier la classe
         */
        Scanner scan =new Scanner(new File("config.txt"));
        String daoClassName=scan.nextLine();
        Class cDao=Class.forName(daoClassName);//si classe existe : chargement de bytecode en memoire , sinon generation d'une exception
        //instancier la classe
        //MewInstance retourne type object
        //Exception: classcastException si on fais appel a une classe qui n'implemente pas l'interface IDao {cast vers une class qui n'herite pas de cette interface}
        IDao dao = (IDao) cDao.newInstance();
        System.out.println(dao.getData());

        //Pour Metier
        String MetierClassName=scan.nextLine();
        Class cMetier=Class.forName(MetierClassName);
        IMetier metier = (IMetier) cMetier.newInstance();

        Method method=cMetier.getMethod("setDao",IDao.class);//pour faire appel a une method dynamique
        //metier.setDao(dao);
        method.invoke(metier,dao);//pour executer la methode sur l'objet metier en transmettant l'objet dao comme parametre


        System.out.println("Resultat=>"+metier.calcul());
    }
}
