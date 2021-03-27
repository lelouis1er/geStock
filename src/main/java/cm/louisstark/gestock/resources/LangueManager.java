/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.resources;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "langueManager")
@SessionScoped
public class LangueManager implements Serializable {

    private Object locale = Locale.FRENCH;
    private static final Map<String, Object> langues;
    private static String langue = "";

    static {
        langues = new LinkedHashMap<>();
        langues.put("Français", Locale.FRENCH);
        langues.put("English", Locale.ENGLISH);
    }

    @PostConstruct
    private void init() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String lang = request.getParameter("lang");

            if (lang != null) {
                setLocale(lang);
            } else {
                if (locale != null) {
                    setLocale(locale.toString());
                }
            }

        } catch (Exception e) {
        }
    }

    public void changer_de_langue(ValueChangeEvent event) {
        String lang = event.getNewValue().toString();
        setLocale(lang);
    }

    public LangueManager() {
    }

    public Object getLocale() {
        return locale;
    }

    public void setLocale(String local) {
        try {
            for (Map.Entry<String, Object> entrySet : langues.entrySet()) {
                Object value = entrySet.getValue();
                Object key = entrySet.getKey();
                if (value.toString().equals(local)) {
                    this.locale = value;
                    LangueManager.langue = (String) key;
                    break;
                }
            }
            FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) this.locale);
        } catch (Exception e) {
        }
    }

    public void change_to_en() {
        this.locale = Locale.ENGLISH;
    }

    public Map<String, Object> getLangues() {
        return langues;
    }

    public String getLangue() {
        return langue;
    }

}
