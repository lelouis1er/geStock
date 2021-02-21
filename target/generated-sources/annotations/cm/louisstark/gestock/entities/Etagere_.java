package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.ArticleStock;
import cm.louisstark.gestock.entities.Magasin;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T08:04:21")
@StaticMetamodel(Etagere.class)
public class Etagere_ { 

    public static volatile SingularAttribute<Etagere, Integer> idEtagere;
    public static volatile SingularAttribute<Etagere, Magasin> idMagasin;
    public static volatile SingularAttribute<Etagere, String> descrption;
    public static volatile SingularAttribute<Etagere, Integer> numRange;
    public static volatile SingularAttribute<Etagere, String> nom;
    public static volatile ListAttribute<Etagere, ArticleStock> articleStockList;

}