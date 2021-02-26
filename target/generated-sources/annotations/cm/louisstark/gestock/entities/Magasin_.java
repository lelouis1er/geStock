package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Etagere;
import cm.louisstark.gestock.entities.Societe;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(Magasin.class)
public class Magasin_ { 

    public static volatile SingularAttribute<Magasin, String> code;
    public static volatile SingularAttribute<Magasin, Societe> idSociete;
    public static volatile SingularAttribute<Magasin, Integer> idMagasin;
    public static volatile SingularAttribute<Magasin, String> description;
    public static volatile ListAttribute<Magasin, Etagere> etagereList;
    public static volatile SingularAttribute<Magasin, String> intitule;

}