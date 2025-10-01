/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Model;

/**
 *
 * @author aluno.saolucas
 */
public class Fornecedor {
     private int id;
    private String nomeRazao;
    private String nomeFantasia;
    private String telefone;
    private String email;
    
    public Fornecedor(){
        
    }
    public Fornecedor(int id, String nomeRazao, String nomeFantasia, String telefone, String email){
        this.id=id;
        this.nomeRazao=nomeRazao;
        this.nomeFantasia=nomeFantasia;
        this.telefone=telefone;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString(){
        return this.getNomeFantasia();
    }
}
