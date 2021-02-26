package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(Restrictionprivilege.class)
public class Restrictionprivilege_ { 

    public static volatile SingularAttribute<Restrictionprivilege, Boolean> cancreate;
    public static volatile SingularAttribute<Restrictionprivilege, Utilisateur> idutilisateur;
    public static volatile SingularAttribute<Restrictionprivilege, Integer> idrestriction;
    public static volatile SingularAttribute<Restrictionprivilege, Boolean> candelete;
    public static volatile SingularAttribute<Restrictionprivilege, Boolean> restrictup;
    public static volatile SingularAttribute<Restrictionprivilege, Privilegesutilisateur> idprivilege;
    public static volatile SingularAttribute<Restrictionprivilege, Boolean> canupdate;

}