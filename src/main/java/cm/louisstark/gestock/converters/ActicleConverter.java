/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.converters;

import cm.louisstark.gestock.entities.Article;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Louis Stark
 */
@FacesConverter (value = "articleConverter")
public class ActicleConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ValueExpression ve = context.getApplication()
                .getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{superConverter}", SuperConverter.class);
        SuperConverter sc = (SuperConverter) ve.getValue(context.getELContext());
        return sc.find_article_InList(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null) {
            Long id = ((Article) o).getIdArticle();
            if (id != null) {
                return id.toString();
            }
        }
        return "";
    }
    
}
