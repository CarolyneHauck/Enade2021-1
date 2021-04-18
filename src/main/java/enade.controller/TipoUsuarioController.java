/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.TipoUsuarioDao;;
import enade.model.TipoUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author carolyne.carreira
 */
@ManagedBean(name = "TipoUsuarioBean")
@ViewScoped
public class TipoUsuarioController implements Serializable {

    private TipoUsuario tipoUsuario = new TipoUsuario();
    TipoUsuarioDao tipoUsuarioDao;
    private List tipoUsuarios = new ArrayList();
    
    public TipoUsuarioController(){
        tipoUsuarioDao =  new TipoUsuarioDao();
        tipoUsuarios = tipoUsuarioDao.buscarTodos();
    }
    
    public void record(ActionEvent actionEvent) {
        tipoUsuarioDao.atualizar(this.getTipoUsuario());
        setTipoUsuarios(tipoUsuarioDao.buscarTodos());
        setTipoUsuario(new TipoUsuario());
    }

    public void exclude(ActionEvent actionEvent) {
        tipoUsuarioDao.remover(getTipoUsuario().getIdtipoUsuario());
        setTipoUsuarios(tipoUsuarioDao.buscarTodos());
        setTipoUsuario(new TipoUsuario());
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<TipoUsuario> getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(List<TipoUsuario> tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

}
