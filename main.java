package com.mycompany.trabalho;

import model.Disciplina;
import model.Nota;
import model.Tarefa;
import model.Trabalho;
import model.Usuario;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TarefaView tarefaView = new TarefaView();

        // criar uma nova tarefa
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("estudo dirigido de provas");
        tarefa.setDescricao("estudar os conceitos base estabelecidos");
        tarefa.setPrazo(new Date()); // definir a data de prazo
        tarefa.setStatus("Pendente");
        tarefa.setCurso("Sistemas de Informação");

        // adicionar tarefa
        tarefaView.adicionarTarefa(tarefa);

        // mostrar todas as tarefas
        tarefaView.mostrarTarefas();
    }
}
