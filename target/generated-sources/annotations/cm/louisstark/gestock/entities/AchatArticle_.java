package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Achats;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.OperationStock;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(AchatArticle.class)
public class AchatArticle_ { 

    public static volatile SingularAttribute<AchatArticle, Integer> qte;
    public static volatile SingularAttribute<AchatArticle, Article> idArticle;
    public static volatile SingularAttribute<AchatArticle, OperationStock> idOperation;
    public static volatile SingularAttribute<AchatArticle, Long> idAchatartice;
    public static volatile SingularAttribute<AchatArticle, Achats> idAchat;

}