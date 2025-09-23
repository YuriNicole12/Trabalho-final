//Diciplina 
package com.mycompany.trabalho;

public class Diciplina {
    private int idDiciplina;
    private String nome;
    private int idProfessor;
    
    public Diciplina () {}
    
    public Diciplina(int idDIciplina, String nome, int idProfessor) {
        this.idDiciplina = idDiciplina;
        this.nome = nome;
        this.idProfessor = idProfessor;
    }
    public int getidDisciplina() { return idDiciplina; }
    public void setidDisciplina(int idDisciplina) { this.idDiciplina = idDisciplina; }
    public String getnome () {return nome; }
    public void setnome (String nome) { this.nome = nome; }
    public int getidProfessor () { return idProfessor; }
    public void setidProfessor (int idProfessor) {this.idProfessor = idProfessor; }
   
}
