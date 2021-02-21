package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.entities.Restrictionprivilege;
import cm.louisstark.gestock.entities.Roleprivilege;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T19:17:54")
@StaticMetamodel(Privilegesutilisateur.class)
public class Privilegesutilisateur_ { 

    public static volatile ListAttribute<Privilegesutilisateur, Restrictionprivilege> restrictionprivilegeList;
    public static volatile SingularAttribute<Privilegesutilisateur, String> description;
    public static volatile SingularAttribute<Privilegesutilisateur, Menu> idmenu;
    public static volatile SingularAttribute<Privilegesutilisateur, String> nom;
    public static volatile SingularAttribute<Privilegesutilisateur, Integer> niveau;
    public static volatile SingularAttribute<Privilegesutilisateur, Integer> idprivilege;
    public static volatile ListAttribute<Privilegesutilisateur, Roleprivilege> roleprivilegeList;

}