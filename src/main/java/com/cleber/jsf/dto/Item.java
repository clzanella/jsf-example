package com.cleber.jsf.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Item implements Serializable {

    private int oid;
    private String descricao;
    private double valor;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Column(length = 255)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(precision = 8, scale = 2)
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
