package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.OperationStock;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(ArticlesCommandeClient.class)
public class ArticlesCommandeClient_ { 

    public static volatile SingularAttribute<ArticlesCommandeClient, Integer> qte;
    public static volatile SingularAttribute<ArticlesCommandeClient, Article> idArticle;
    public static volatile SingularAttribute<ArticlesCommandeClient, OperationStock> idOperation;
    public static volatile SingularAttribute<ArticlesCommandeClient, Long> idArticleCommandeclient;
    public static volatile SingularAttribute<ArticlesCommandeClient, Double> montant;
    public static volatile SingularAttribute<ArticlesCommandeClient, CommandeClient> idCommande;

}