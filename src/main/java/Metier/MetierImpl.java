package Metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier{
    //Couplage faible
    //Pour faire injection des dependances au moment de
    // l'instanciation de metierImpl cherche moi un objet de type IDao, si trouvee ==> injecter dans la variable dao
    @Autowired
    // on peut faire injection via controlleur mieux
    private IDao dao;
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul()
    {
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
    //injecter dans la variable dao un objet d une classe qui implemente l interface IDao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
