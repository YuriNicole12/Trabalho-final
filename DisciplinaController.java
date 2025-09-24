package com.mycompany.trabalho;

import java.util.ArrayList;

public class DisciplinaController {
    private ArrayList<Disciplina> lista = new ArrayList<>();
    private int proximoId = 1;

    // FK: idProfessor deve existir e ser "professor"
    public Disciplina adicionar(String nome, int idProfessor, UsuarioController usuarios) {
        Usuario prof = usuarios.buscarPorId(idProfessor);
        if (prof == null || !"professor".equalsIgnoreCase(prof.getTipo())) {
            return null; // professor inválido
        }
        Disciplina d = new Disciplina(proximoId++, nome, idProfessor);
        lista.add(d);
        return d;
    }

    public ArrayList<Disciplina> listar() { return lista; }

    public Disciplina buscarPorId(int id) {
        for (Disciplina d : lista) {
            if (d.getIdDisciplina() == id) return d;
        }
        return null;
    }

    public boolean atualizar(int id, String nome, int idProfessor, UsuarioController usuarios) {
        Disciplina d = buscarPorId(id);
        if (d == null) return false;
        Usuario prof = usuarios.buscarPorId(idProfessor);
        if (prof == null || !"professor".equalsIgnoreCase(prof.getTipo())) return false;
        d.setNome(nome);
        d.setIdProfessor(idProfessor);
        return true;
    }

    public boolean remover(int id) {
        Disciplina d = buscarPorId(id);
        if (d == null) return false;
        return lista.remove(d);
    }
}
