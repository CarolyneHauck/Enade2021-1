/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import enade.model.TipoQuestao;
import enade.util.PersistenceUtil;

/**
 *
 * @author carolyne.carreira
 */
public class TipoQuestaoDAO {

    public static TipoQuestaoDAO tipoQuestaoDAO;

    public static TipoQuestaoDAO getInstance() {
        if (tipoQuestaoDAO == null) {
            tipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return tipoQuestaoDAO;
    }

    public TipoQuestao buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from TipoQuestao t where t.idtipoQuestao =:id ");
        query.setParameter("id", codigo);

        List<TipoQuestao> tipoQuestao = query.getResultList();
        if (tipoQuestao != null && tipoQuestao.size() > 0) {
            return tipoQuestao.get(0);
        }

        return null;
    }

    public List<TipoQuestao> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TipoQuestao t");
        return query.getResultList();
    }

    public void remover(TipoQuestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoQuestao)) {
            tipoQuestao = em.merge(tipoQuestao);
        }
        em.remove(tipoQuestao);
        em.getTransaction().commit();
    }

    public TipoQuestao atualizar(TipoQuestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoQuestao = em.merge(tipoQuestao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return tipoQuestao;
    }

    public void persistir(TipoQuestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(tipoQuestao);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from TipoQuestao");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
