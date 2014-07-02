package com.javi.acme.servicios;
import com.javi.acme.dao.UsuarioDAO;
import com.javi.acme.dao.UsuarioDAOImpl;
import com.javi.acme.formulario.UsuarioForm;
public class UsuarioServiceImpl implements UsuarioService
{
    private UsuarioDAO usuarioDAO = (UsuarioDAO) new UsuarioDAOImpl();
    
    public boolean buscarUsuario(UsuarioForm usuario) {
        // TODO Auto-generated method stub
        return usuarioDAO.buscarUsuario(usuario);
    }
}
