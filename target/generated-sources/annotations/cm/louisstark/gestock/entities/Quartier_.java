package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Ville;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T19:17:54")
@StaticMetamodel(Quartier.class)
public class Quartier_ { 

    public static volatile SingularAttribute<Quartier, Ville> idville;
    public static volatile ListAttribute<Quartier, Adresse> adresseList;
    public static volatile SingularAttribute<Quartier, Integer> idquartier;
    public static volatile SingularAttribute<Quartier, String> nom;

}