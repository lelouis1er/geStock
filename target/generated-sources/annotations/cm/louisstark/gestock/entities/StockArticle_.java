package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.Etagere;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(StockArticle.class)
public class StockArticle_ { 

    public static volatile SingularAttribute<StockArticle, Long> idArticlestock;
    public static volatile SingularAttribute<StockArticle, Article> idArticle;
    public static volatile SingularAttribute<StockArticle, Etagere> idEtagere;
    public static volatile SingularAttribute<StockArticle, Integer> qteStock;

}