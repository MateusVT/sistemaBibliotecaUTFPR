/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.biblioteca.salas.dao;

import br.edu.utfpr.biblioteca.salas.model.bo.UsuarioBO;
import br.edu.utfpr.biblioteca.salas.model.dao.UsuarioDAO;
import br.edu.utfpr.biblioteca.salas.model.entity.ReservaPO;
import br.edu.utfpr.biblioteca.salas.model.entity.UsuarioPO;
import br.edu.utfpr.biblioteca.salas.tools.CalendarioHelper;
import java.util.Date;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author romulo
 */
public class UsuarioDAOTest {

    UsuarioDAO dao = new UsuarioDAO();

    public UsuarioDAOTest() {
    }

    public void cadastrar() {
        UsuarioDAO dao = new UsuarioDAO();
        if (dao.list().isEmpty()) {
            dao.insert(new UsuarioPO("1137212", "Rômulo", "112131", "email@email.com"));
            dao.insert(new UsuarioPO("1602063", "Mateus", "teste", "asd.com"));
            dao.insert(new UsuarioPO("113722", "Rômulo", "senha", "email@mail.com"));
            dao.insert(new UsuarioPO("1137612", "Rômulo", "senha", "emil@email.com"));

        }
    }

//    @Test
    public void test_autenticar() {
        UsuarioPO d = dao.isAutentico("1136631", "baiser");
        assertTrue(d != null);
    }
    
//    @Test
    public void test_usuarioCadastrado() {
        UsuarioPO usuario = new UsuarioPO("1136631", null, "baiser", "");
        assertTrue(UsuarioBO.alreadyCadastrado(usuario));

    }
    
    @Test
    public void test_ReservaEmCurso(){
        Date date = CalendarioHelper.parseDate("09-05-2016", "12", "0", "0");
        UsuarioPO u = dao.obter("1602063");
        assertTrue(u != null);
        ReservaPO reserva = dao.getReservaEmCurso(u, date);
        assertTrue(reserva != null);
        
    }
    
}
