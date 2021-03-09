package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.AchatArticle;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(OperationStock.class)
public class OperationStock_ { 

    public static volatile ListAttribute<OperationStock, ArticlesCommandeClient> articlesCommandeClientList;
    public static volatile SingularAttribute<OperationStock, Integer> qte;
    public static volatile SingularAttribute<OperationStock, Article> idArticle;
    public static volatile ListAttribute<OperationStock, AchatArticle> achatArticleList;
    public static volatile ListAttribute<OperationStock, ArticleLiv> articleLivList;
    public static volatile SingularAttribute<OperationStock, Long> idOperation;
    public static volatile SingularAttribute<OperationStock, String> description;
    public static volatile SingularAttribute<OperationStock, Boolean> entree;

}