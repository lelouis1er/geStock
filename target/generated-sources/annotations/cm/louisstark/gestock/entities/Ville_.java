package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Pays;
import cm.louisstark.gestock.entities.Quartier;
import cm.louisstark.gestock.entities.Region;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T08:04:21")
@StaticMetamodel(Ville.class)
public class Ville_ { 

    public static volatile ListAttribute<Ville, Quartier> quartierList;
    public static volatile SingularAttribute<Ville, Integer> idville;
    public static volatile SingularAttribute<Ville, Pays> idpays;
    public static volatile SingularAttribute<Ville, String> nom;
    public static volatile SingularAttribute<Ville, Region> idregion;

}