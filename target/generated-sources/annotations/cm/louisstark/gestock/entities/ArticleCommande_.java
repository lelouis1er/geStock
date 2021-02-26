package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.Commande;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(ArticleCommande.class)
public class ArticleCommande_ { 

    public static volatile SingularAttribute<ArticleCommande, Integer> qte;
    public static volatile SingularAttribute<ArticleCommande, Article> idArticle;
    public static volatile SingularAttribute<ArticleCommande, Long> idArticleCommande;
    public static volatile SingularAttribute<ArticleCommande, Commande> idCommande;

}