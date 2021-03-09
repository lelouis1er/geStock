package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Mouchard;
import cm.louisstark.gestock.entities.Restrictionprivilege;
import cm.louisstark.gestock.entities.Roleutilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile ListAttribute<Utilisateur, Mouchard> mouchardList;
    public static volatile SingularAttribute<Utilisateur, Date> datedesactivation;
    public static volatile SingularAttribute<Utilisateur, Date> dateactivation;
    public static volatile SingularAttribute<Utilisateur, String> description;
    public static volatile SingularAttribute<Utilisateur, String> photo;
    public static volatile SingularAttribute<Utilisateur, Boolean> actif;
    public static volatile SingularAttribute<Utilisateur, String> login;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, Employes> idEmploye;
    public static volatile SingularAttribute<Utilisateur, Integer> idutilisateur;
    public static volatile SingularAttribute<Utilisateur, String> password;
    public static volatile SingularAttribute<Utilisateur, Roleutilisateur> idrole;
    public static volatile ListAttribute<Utilisateur, Restrictionprivilege> restrictionprivilegeList;
    public static volatile SingularAttribute<Utilisateur, Boolean> deleted;
    public static volatile SingularAttribute<Utilisateur, Date> datecreation;
    public static volatile SingularAttribute<Utilisateur, Date> datedelete;

}