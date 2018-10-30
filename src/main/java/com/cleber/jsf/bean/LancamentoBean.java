package com.cleber.jsf.bean;

import com.cleber.jsf.dao.GenericDAO;
import com.cleber.jsf.dto.Item;
import com.cleber.jsf.dto.Lancamento;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class LancamentoBean implements Serializable {

    private static final long serialVersionUID = -687991492884005033L;

    private Integer lancamentoOid;
    private Lancamento lancamento;
    private Item item = new Item();

    public Integer getLancamentoOid() {
        return lancamentoOid;
    }

    public void setLancamentoOid(Integer lancamentoOid) {
        this.lancamentoOid = lancamentoOid;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    /* Açoes */

    public void init() {

        if(lancamento == null && lancamentoOid != null){
            lancamento = new GenericDAO<>(Lancamento.class).buscarPorOid(lancamentoOid);
        }

        if(lancamento == null){
            lancamento = new Lancamento();
        }
    }

    public String salvar() {

        GenericDAO<Lancamento> dao = new GenericDAO<>(Lancamento.class);

        if(getLancamento().getOid() == 0){
            dao.adicionar(getLancamento());
        } else {
            dao.atualizar(getLancamento().getOid(), getLancamento());
        }

        return "";
    }

    public String adicionarItem() {

        lancamento.getItems().add(item);
        atualizarTotal();
        item = new Item();
        return "";
    }

    public String removerItem(Item item) {

        lancamento.getItems().remove(item);
        atualizarTotal();
        return "";
    }

    private void atualizarTotal() {

        double valorTotal = lancamento.getItems().stream().mapToDouble(Item::getValor).sum();
        lancamento.setValorTotal(valorTotal);

    }

}
