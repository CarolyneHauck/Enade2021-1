/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import enade.model.Usuario;
import enade.util.PersistenceUtil;
import javax.persistence.NoResultException;

import enade.dao.TipoUsuarioDao;
import enade.model.TipoUsuario;


/**
 *
 * @author carolyne.carreira
 */
public class UsuarioDao {

    public static UsuarioDao usuarioDao;

    public static UsuarioDao getInstance() {
        if (usuarioDao == null) {
            usuarioDao = new UsuarioDao();
        }
        return usuarioDao;
    }

    public Usuario getUsuario(String nomeUsuario, String senhaUsuario) {
      EntityManager em = PersistenceUtil.getEntityManager();
      try {
        Usuario usuario = (Usuario) em.createQuery("SELECT u from Usuario u where u.nomeUsuario =:name and u.senhaUsuario =:senha").setParameter("name", nomeUsuario).setParameter("senha", senhaUsuario).getSingleResult();

        return usuario;

      } catch (NoResultException e) {
            return null;
      }
    }

    public Usuario getUsuarioProfessor(String nomeUsuario){
      EntityManager em = PersistenceUtil.getEntityManager();
      try {
        Usuario usuario = (Usuario) em.createQuery("SELECT u from Usuario u where u.nomeUsuario =:name and u.TipoUsuario_idtipoUsuario = 1").setParameter("name", nomeUsuario).getSingleResult();

        return usuario;

      } catch (NoResultException e) {
            return null;
      }
    }

    public Usuario buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from Usuario t where t.idUsuario =:id ");
        query.setParameter("id", codigo);

        List<Usuario> usuario = query.getResultList();
        if (usuario != null && usuario.size() > 0) {
            return usuario.get(0);
        }

        return null;
    }

    public List<Usuario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Usuario t");
        return query.getResultList();
    }

    public void remover(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(usuario)) {
            usuario = em.merge(usuario);
        }
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public Usuario atualizar(Usuario usuario) {
        if (usuario.getTipoUsuarioidtipoUsuario() == null)
        {
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setIdtipoUsuario(2);
            tipoUsuario.setNomeTipoUsuario("Aluno");

            usuario.setTipoUsuarioidtipoUsuario(tipoUsuario);

            System.out.println(usuario);
        }
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            usuario = em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return usuario;
    }

    public void persistir(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Usuario");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
