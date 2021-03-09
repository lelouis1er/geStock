package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.OperationStock;
import cm.louisstark.gestock.entities.RetourArticleLiv;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(ArticleLiv.class)
public class ArticleLiv_ { 

    public static volatile SingularAttribute<ArticleLiv, Boolean> endomage;
    public static volatile SingularAttribute<ArticleLiv, Integer> qte;
    public static volatile SingularAttribute<ArticleLiv, OperationStock> idOperation;
    public static volatile SingularAttribute<ArticleLiv, Long> idArticleLiv;
    public static volatile SingularAttribute<ArticleLiv, Double> puAchat;
    public static volatile ListAttribute<ArticleLiv, RetourArticleLiv> retourArticleLivList;
    public static volatile SingularAttribute<ArticleLiv, Livraison> idLivraison;

}