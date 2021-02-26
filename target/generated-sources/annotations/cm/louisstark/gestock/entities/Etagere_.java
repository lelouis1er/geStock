package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Magasin;
import cm.louisstark.gestock.entities.StockArticle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(Etagere.class)
public class Etagere_ { 

    public static volatile SingularAttribute<Etagere, Integer> idEtagere;
    public static volatile SingularAttribute<Etagere, Magasin> idMagasin;
    public static volatile SingularAttribute<Etagere, String> descrption;
    public static volatile ListAttribute<Etagere, StockArticle> stockArticleList;
    public static volatile SingularAttribute<Etagere, Integer> numRange;
    public static volatile SingularAttribute<Etagere, String> nom;

}