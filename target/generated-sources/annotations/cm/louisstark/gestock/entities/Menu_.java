package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.entities.Privilegesutilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T08:04:21")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile ListAttribute<Menu, Menu> menuList;
    public static volatile SingularAttribute<Menu, String> ressource;
    public static volatile ListAttribute<Menu, Privilegesutilisateur> privilegesutilisateurList;
    public static volatile SingularAttribute<Menu, Integer> idmenu;
    public static volatile SingularAttribute<Menu, String> nom;
    public static volatile SingularAttribute<Menu, Menu> menIdmenu;

}