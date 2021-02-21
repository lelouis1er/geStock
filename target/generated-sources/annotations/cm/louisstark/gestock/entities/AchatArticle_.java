package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Achats;
import cm.louisstark.gestock.entities.ArticleStock;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T16:51:03")
@StaticMetamodel(AchatArticle.class)
public class AchatArticle_ { 

    public static volatile SingularAttribute<AchatArticle, ArticleStock> idArticlestock;
    public static volatile SingularAttribute<AchatArticle, Integer> qte;
    public static volatile SingularAttribute<AchatArticle, Long> idAchatartice;
    public static volatile SingularAttribute<AchatArticle, Achats> idAchat;

}