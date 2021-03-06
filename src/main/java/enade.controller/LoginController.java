package enade.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import enade.dao.UsuarioDao;
import enade.model.Usuario;

import enade.dao.TipoUsuarioDao;
import enade.model.TipoUsuario;

@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginController {

  private UsuarioDao usuarioDao = new UsuarioDao();
  private Usuario usuario = new Usuario();

  private TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
  private TipoUsuario tipoUsuario = new TipoUsuario();

  public String envia() {

    usuario = usuarioDao.getUsuario(usuario.getNomeUsuario(), usuario.getSenhaUsuario());
    if (usuario == null) {
      usuario = new Usuario();
      FacesContext.getCurrentInstance().addMessage(
         null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário Aluno não encontrado!",
           "Erro no Login!"));
      return null;
    } 
    else 
    { 
      tipoUsuario.setIdtipoUsuario(1);

      if (usuario.getTipoUsuarioidtipoUsuario().toString().contains("1"))
      {
        return "/index.html";
      }
      else
      {
        return "/indexAluno.xhtml";
      }
    }
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}