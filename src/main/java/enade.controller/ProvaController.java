/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.controller;

import enade.dao.ProvaDao;;
import enade.model.Prova;
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
@ManagedBean(name = "ProvaBean")
@ViewScoped
public class ProvaController implements Serializable {
    private Prova prova = new Prova();
    ProvaDao provaDao;
    private List provas = new ArrayList();
    
    public ProvaController(){
        provaDao =  new ProvaDao();
        provas = provaDao.buscarTodos();
    }
    
    public void record(ActionEvent actionEvent) {
        provaDao.atualizar(this.getProva());
        setProvas(provaDao.buscarTodos());
        setProva(new Prova());
    }

    public void exclude(ActionEvent actionEvent) {
        provaDao.remover(getProva().getIdProva());
        setProvas(provaDao.buscarTodos());
        setProva(new Prova());
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public List<Prova> getProvas() {
        return provas;
    }

    public void setProvas(List<Prova> provas) {
        this.provas = provas;
    }
}