package com.ragalzi;

import java.time.LocalDate;

public class Cliente {
    private Integer numeroCliente;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String regioneResidenza;

    public Cliente() {
    }

    public Cliente(String nome, String cognome, LocalDate dataNascita, String regioneResidenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.regioneResidenza = regioneResidenza;
    }

    public Integer getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Integer numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getRegioneResidenza() {
        return regioneResidenza;
    }

    public void setRegioneResidenza(String regioneResidenza) {
        this.regioneResidenza = regioneResidenza;
    }
}
