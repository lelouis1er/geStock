/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Louis Stark
 */
@ManagedBean(name = "appController")
@SessionScoped
public class AppController extends SuperController {

    protected Boolean dark_mode = false;

    
    ///////////////////////////////  GETTERS AND SETTERS  ///////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean getDark_mode() {
        return dark_mode;
    }

    public void setDark_mode(Boolean dark_mode) {
        this.dark_mode = dark_mode;
    }

    @Override
    public void define_create_update_delete_details(Object o) {
    }
    
    
}
