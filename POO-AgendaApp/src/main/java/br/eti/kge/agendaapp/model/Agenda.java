/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.kge.agendaapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sesidevb
 */
public class Agenda {
    
    private String proprietario;
    private List<Contato> listaContatos = new ArrayList<>();

    public Agenda(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public List<Contato> getListaContatos() {
        return listaContatos;
    }

    public void setListaContatos(List<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }
    
    /**
     * Adiciona um contato na agenda
     * @param c
     */
    public void adicionaContato(Contato c) {
        listaContatos.add(c);
    }
    
    /**
     * Altera um contato em uma posição específica
     * @param index do contato.
     * @param c contato atualizado.
     */
    public void alteraContato(int index, Contato c) {
        listaContatos.set(index, c);
    }
    
    /**
     * Exclui um contato em uma posição específica.
     * @param index Posição a ser excluida.
     */
    public void excluiContato(int index) {
        listaContatos.remove(index);
    }
    
    /**
     * Lista os contatos cadastrados na agenda.
     * @return
     */
    public String listarContatos() {
        String relatorio = "Relatorio Agenda \n";
        relatorio += "-".repeat(20) + "\n";
        relatorio += "Proprietario: " + this.proprietario + "\n";
        
        for(Contato c : this.listaContatos) {
            relatorio += c.toString();
            relatorio += "\n"; // Quebra de linha
        }
        return relatorio;
    }
    
    /**
     * Filtra contatos com base em um filtro.
     * @param filtro String contendo nome ou parte do nome para filtrar.
     * @return listaFiltrados
     */
    public List<Contato> filtrarContato(String filtro) {
        List<Contato> listaFiltrados = new ArrayList<>();
        for(Contato c : this.listaContatos) {
            if (c.getNome().contains(filtro)) {
                listaFiltrados.add(c);
            }
        }
        return listaFiltrados;
    }
    
    public Contato getContato(int index) {
        return this.listaContatos.get(index);
    }
    
    public int buscaNome (String auxName) {
        int busca = 0;
        boolean encontrado = false;
        
        if (listaContatos.isEmpty()) return -1; //se a lista estiver vazia ele quebra
        
        while (busca < listaContatos.size() && !encontrado) {
            
            if (listaContatos.get(busca).getNome().equals(auxName)) {
                // Contato encontrado!!!
                encontrado = true;
            } else {
                busca ++;
            }
        }
        
        if (!encontrado) return -1; //se não encontrar ele quebra
                
        return busca;
    }
    
}
