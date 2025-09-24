package main;

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
        tarefa.setTitulo("Estudar para a prova de Java");
        tarefa.setDescricao("Estudar os conceitos de OOP e Collections");
        tarefa.setPrazo(new Date()); // definir a data de prazo
        tarefa.setStatus("Pendente");
        tarefa.setCurso("Sistemas de Informação");

        // adicionar tarefa
        tarefaView.adicionarTarefa(tarefa);

        // mostrar todas as tarefas
        tarefaView.mostrarTarefas();
    }
}
