package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Roleutilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(Roleprivilege.class)
public class Roleprivilege_ { 

    public static volatile SingularAttribute<Roleprivilege, Integer> idroleprivilege;
    public static volatile SingularAttribute<Roleprivilege, Boolean> cancreate;
    public static volatile SingularAttribute<Roleprivilege, Roleutilisateur> idrole;
    public static volatile SingularAttribute<Roleprivilege, Boolean> candelete;
    public static volatile SingularAttribute<Roleprivilege, Privilegesutilisateur> idprivilege;
    public static volatile SingularAttribute<Roleprivilege, Boolean> canupdate;

}