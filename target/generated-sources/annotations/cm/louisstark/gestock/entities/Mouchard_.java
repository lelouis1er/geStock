package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T08:04:21")
@StaticMetamodel(Mouchard.class)
public class Mouchard_ { 

    public static volatile SingularAttribute<Mouchard, Utilisateur> idutilisateur;
    public static volatile SingularAttribute<Mouchard, Long> idMouchard;
    public static volatile SingularAttribute<Mouchard, Date> heureOperation;
    public static volatile SingularAttribute<Mouchard, String> description;
    public static volatile SingularAttribute<Mouchard, Date> dateOperation;

}