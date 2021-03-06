/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.controller;

import enade.dao.QuestaoDao;
import enade.model.Questao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author carolyne.carreira
 */
@Named
@ViewScoped
public class QuestaoController implements Serializable {

    Questao questao = new Questao();
    List<Questao> questoes = new ArrayList<>();

    public QuestaoController() {
        questoes = QuestaoDao.getInstance().buscarTodas();
        questao = new Questao();
    }

    public void gravar(ActionEvent actionEvent) {
        QuestaoDao.getInstance().atualizar(questao);
        questoes = QuestaoDao.getInstance().buscarTodas();
        questao = new Questao();
    }

    public void remover(ActionEvent actionEvent) {
        QuestaoDao.getInstance().remover(questao);
        questoes = QuestaoDao.getInstance().buscarTodas();
        questao = new Questao();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public void onRowEdit(RowEditEvent event) {
        Questao q = (Questao) event.getObject();
        QuestaoDao.getInstance().atualizar(q);
        questoes = QuestaoDao.getInstance().buscarTodas();
        questao = new Questao();
        FacesMessage msg = new FacesMessage("Editado", q.getIdQuestao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<Questao> event) {
        FacesMessage msg = new FacesMessage("Cancelado", event.getObject().getIdQuestao().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}