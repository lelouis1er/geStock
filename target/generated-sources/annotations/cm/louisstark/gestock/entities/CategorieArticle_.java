package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.TypeArticle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T19:17:54")
@StaticMetamodel(CategorieArticle.class)
public class CategorieArticle_ { 

    public static volatile SingularAttribute<CategorieArticle, Integer> idCategorie;
    public static volatile SingularAttribute<CategorieArticle, String> description;
    public static volatile SingularAttribute<CategorieArticle, String> nom;
    public static volatile ListAttribute<CategorieArticle, TypeArticle> typeArticleList;

}