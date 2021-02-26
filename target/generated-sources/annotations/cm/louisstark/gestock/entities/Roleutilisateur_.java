package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Roleprivilege;
import cm.louisstark.gestock.entities.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(Roleutilisateur.class)
public class Roleutilisateur_ { 

    public static volatile SingularAttribute<Roleutilisateur, Integer> idrole;
    public static volatile SingularAttribute<Roleutilisateur, String> coderole;
    public static volatile SingularAttribute<Roleutilisateur, String> nomrole;
    public static volatile ListAttribute<Roleutilisateur, Roleprivilege> roleprivilegeList;
    public static volatile ListAttribute<Roleutilisateur, Utilisateur> utilisateurList;

}