package pres;

import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class presSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext context=
                new AnnotationConfigApplicationContext("dao","Metier"); // en specifiant les package qui va scanner
        IMetier metier=context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
