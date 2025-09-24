package Controller;

import Model.Nota;
import Model.Tarefa;
import java.util.ArrayList;

public class NotaController {
    private ArrayList<Nota> lista = new ArrayList<>();
    private int proximoId = 1;

    // FK: Tarefa deve existir e não pode ter outra Nota (1:1)
    public Nota adicionar(double valor, int idTarefa, TarefaController tarefas) {
        Tarefa t = tarefas.buscarPorId(idTarefa);
        if (t == null) return null;
        if (buscarPorTarefa(idTarefa) != null) return null; // já existe nota p/ essa tarefa

        Nota n = new Nota(proximoId++, valor, idTarefa);
        lista.add(n);
        return n;
    }

    public ArrayList<Nota> listar() { return lista; }

    public Nota buscarPorId(int id) {
        for (Nota n : lista) {
            if (n.getIdNota() == id) return n;
        }
        return null;
    }

    public Nota buscarPorTarefa(int idTarefa) {
        for (Nota n : lista) {
            if (n.getIdTarefa() == idTarefa) return n;
        }
        return null;
    }

    public boolean atualizar(int id, double valor) {
        Nota n = buscarPorId(id);
        if (n == null) return false;
        n.setValor(valor);
        return true;
    }

    public boolean remover(int id) {
        Nota n = buscarPorId(id);
        if (n == null) return false;
        return lista.remove(n);
    }
}
