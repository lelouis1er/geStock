package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.ArticleCommande;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.ArticleStock;
import cm.louisstark.gestock.entities.TypeArticle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T16:51:03")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, String> carateristiques;
    public static volatile SingularAttribute<Article, Long> idArticle;
    public static volatile SingularAttribute<Article, TypeArticle> idType;
    public static volatile SingularAttribute<Article, String> codeArticle;
    public static volatile ListAttribute<Article, ArticleLiv> articleLivList;
    public static volatile ListAttribute<Article, ArticleCommande> articleCommandeList;
    public static volatile SingularAttribute<Article, Double> prixVente;
    public static volatile SingularAttribute<Article, String> nom;
    public static volatile SingularAttribute<Article, Integer> qteAlert;
    public static volatile ListAttribute<Article, ArticleStock> articleStockList;

}