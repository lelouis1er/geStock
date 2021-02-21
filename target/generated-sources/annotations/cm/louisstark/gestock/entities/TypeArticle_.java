package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.CategorieArticle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T19:17:54")
@StaticMetamodel(TypeArticle.class)
public class TypeArticle_ { 

    public static volatile SingularAttribute<TypeArticle, Integer> idType;
    public static volatile ListAttribute<TypeArticle, Article> articleList;
    public static volatile SingularAttribute<TypeArticle, CategorieArticle> idCategorie;
    public static volatile SingularAttribute<TypeArticle, String> description;
    public static volatile SingularAttribute<TypeArticle, String> nom;

}