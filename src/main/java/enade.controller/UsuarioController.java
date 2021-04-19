/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.UsuarioDao;
import enade.model.Usuario;
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
@ManagedBean(name = "UsuarioBean")
@ViewScoped
public class UsuarioController implements Serializable {

    private Usuario usuario = new Usuario();
    UsuarioDao usuarioDao;
    private List usuarios = new ArrayList();
    
    public UsuarioController(){
        usuarioDao =  new UsuarioDao();
        usuarios = usuarioDao.buscarTodos();
    }

    public void record(ActionEvent actionEvent) {
        usuarioDao.atualizar(this.getUsuario());
        setUsuarios(usuarioDao.buscarTodos());
        setUsuario(new Usuario());
    }

    public void exclude(ActionEvent actionEvent) {
        usuarioDao.remover(getUsuario().getIdUsuario());
        setUsuarios(usuarioDao.buscarTodos());
        setUsuario(new Usuario());
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
