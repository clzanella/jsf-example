package com.cleber.jsf.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Lancamento implements Serializable {

    private int oid;
    private Date dataInicial;
    private Date dataFinal;
    private String observacao;
    private double valorTotal;

    private List<Item> items = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Column(name = "dt_inicial")
    @Temporal(TemporalType.DATE)
    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    @Column(name = "dt_final")
    @Temporal(TemporalType.DATE)
    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Column(length = 1000)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Column(name = "vl_total", precision = 8, scale = 2)
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinTable(name = "LancamentoItem", joinColumns = @JoinColumn(name = "oid_lancamento", referencedColumnName = "oid"), inverseJoinColumns = @JoinColumn(name = "oid_item", referencedColumnName = "oid"))
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
