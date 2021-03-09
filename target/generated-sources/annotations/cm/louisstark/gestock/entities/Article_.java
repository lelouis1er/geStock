package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.AchatArticle;
import cm.louisstark.gestock.entities.ArticleCommande;
import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.OperationStock;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.entities.StockArticle;
import cm.louisstark.gestock.entities.TypeArticle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile ListAttribute<Article, ArticlesCommandeClient> articlesCommandeClientList;
    public static volatile SingularAttribute<Article, Long> idArticle;
    public static volatile SingularAttribute<Article, Societe> idSociete;
    public static volatile SingularAttribute<Article, TypeArticle> idType;
    public static volatile SingularAttribute<Article, String> codeArticle;
    public static volatile SingularAttribute<Article, Double> prixVente;
    public static volatile ListAttribute<Article, StockArticle> stockArticleList;
    public static volatile SingularAttribute<Article, String> nom;
    public static volatile SingularAttribute<Article, Integer> qteAlert;
    public static volatile SingularAttribute<Article, String> carateristiques;
    public static volatile ListAttribute<Article, AchatArticle> achatArticleList;
    public static volatile ListAttribute<Article, OperationStock> operationStockList;
    public static volatile ListAttribute<Article, ArticleCommande> articleCommandeList;

}