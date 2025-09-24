package Controller;

import Model.Tarefa;
import Model.Disciplina;
import Model.Usuario;
import java.util.ArrayList;

public class TarefaController {
    private ArrayList<Tarefa> lista = new ArrayList<>();
    private int proximoId = 1;

    public Tarefa adicionar(String titulo, String descricao, String prazo, String status,
                            int idDisciplina, int idAluno,
                            DisciplinaController disciplinas, UsuarioController usuarios) {

        Disciplina d = disciplinas.buscarPorId(idDisciplina);
        Usuario aluno = usuarios.buscarPorId(idAluno);

        if (d == null || aluno == null || !"aluno".equalsIgnoreCase(aluno.getTipo())) {
            return null; // FK inválida
        }

        Tarefa t = new Tarefa(proximoId++, titulo, descricao, prazo, status, idDisciplina, idAluno);
        lista.add(t);
        return t;
    }

    public ArrayList<Tarefa> listar() { return lista; }

    public Tarefa buscarPorId(int id) {
        for (Tarefa t : lista) {
            if (t.getIdTarefa() == id) return t;
        }
        return null;
    }

    public boolean atualizar(int id, String titulo, String descricao, String prazo, String status,
                             int idDisciplina, int idAluno,
                             DisciplinaController disciplinas, UsuarioController usuarios) {

        Tarefa t = buscarPorId(id);
        if (t == null) return false;

        Disciplina d = disciplinas.buscarPorId(idDisciplina);
        Usuario aluno = usuarios.buscarPorId(idAluno);
        if (d == null || aluno == null || !"aluno".equalsIgnoreCase(aluno.getTipo())) return false;

        t.setTitulo(titulo);
        t.setDescricao(descricao);
        t.setPrazo(prazo);
        t.setStatus(status);
        t.setIdDisciplina(idDisciplina);
        t.setIdAluno(idAluno);
        return true;
    }

    public boolean remover(int id) {
        Tarefa t = buscarPorId(id);
        if (t == null) return false;
        return lista.remove(t);
    }

    public ArrayList<Tarefa> listarPorAluno(int idAluno) {
        ArrayList<Tarefa> out = new ArrayList<>();
        for (Tarefa t : lista) if (t.getIdAluno() == idAluno) out.add(t);
        return out;
    }

    public ArrayList<Tarefa> listarPorDisciplina(int idDisciplina) {
        ArrayList<Tarefa> out = new ArrayList<>();
        for (Tarefa t : lista) if (t.getIdDisciplina() == idDisciplina) out.add(t);
        return out;
    }
}
