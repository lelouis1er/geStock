package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.AchatArticle;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.Etagere;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T08:04:21")
@StaticMetamodel(ArticleStock.class)
public class ArticleStock_ { 

    public static volatile SingularAttribute<ArticleStock, Long> idArticlestock;
    public static volatile ListAttribute<ArticleStock, ArticlesCommandeClient> articlesCommandeClientList;
    public static volatile ListAttribute<ArticleStock, AchatArticle> achatArticleList;
    public static volatile SingularAttribute<ArticleStock, Article> idArticle;
    public static volatile SingularAttribute<ArticleStock, Double> prixAchat;
    public static volatile SingularAttribute<ArticleStock, Etagere> idEtagere;
    public static volatile SingularAttribute<ArticleStock, ArticleLiv> idArticleLiv;
    public static volatile SingularAttribute<ArticleStock, String> description;
    public static volatile SingularAttribute<ArticleStock, Integer> qteStock;

}