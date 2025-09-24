package Controller;

import Model.Usuario;
import java.util.ArrayList;

public class UsuarioController {
    private ArrayList<Usuario> lista = new ArrayList<>();
    private int proximoId = 1;

    public Usuario adicionar(String nome, String email, String tipo) {
        Usuario u = new Usuario(proximoId++, nome, email, tipo);
        lista.add(u);
        return u;
    }

    public ArrayList<Usuario> listar() { return lista; }

    public Usuario buscarPorId(int id) {
        for (Usuario u : lista) {
            if (u.getIdUsuario() == id) return u;
        }
        return null;
    }
}
