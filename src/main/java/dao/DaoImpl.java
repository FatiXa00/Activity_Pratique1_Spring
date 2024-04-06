package dao;

import org.springframework.stereotype.Component;

/* au demarrage a chaque spring trouve une classe qui
precede une anotation component il va l'instancier avec nom "dao"*/
@Component("dao")
public class DaoImpl implements IDao{
    @Override
    public double getData()
    {
        System.out.println("version base de données");
        double temp=Math.random()*44;
        return temp;

    }
}
