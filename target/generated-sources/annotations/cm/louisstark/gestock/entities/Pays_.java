package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Ville;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(Pays.class)
public class Pays_ { 

    public static volatile SingularAttribute<Pays, Integer> idpays;
    public static volatile ListAttribute<Pays, Ville> villeList;
    public static volatile SingularAttribute<Pays, String> nom;

}