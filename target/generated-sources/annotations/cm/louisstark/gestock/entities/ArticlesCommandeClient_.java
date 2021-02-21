package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.ArticleStock;
import cm.louisstark.gestock.entities.CommandeClient;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T19:17:54")
@StaticMetamodel(ArticlesCommandeClient.class)
public class ArticlesCommandeClient_ { 

    public static volatile SingularAttribute<ArticlesCommandeClient, ArticleStock> idArticlestock;
    public static volatile SingularAttribute<ArticlesCommandeClient, Integer> qte;
    public static volatile SingularAttribute<ArticlesCommandeClient, Long> idArticleCommandeclient;
    public static volatile SingularAttribute<ArticlesCommandeClient, CommandeClient> idCommande;

}