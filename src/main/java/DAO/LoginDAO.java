/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 *
 * @author Luis Gustavo
 */
public class LoginDAO {
    java.sql.Connection con = new conecta().getConnection();
    
    public Optional<Usuario> validaLogin(Usuario usuario) throws Exception {

        Usuario usuarioRetorno = null;

        try {
            PreparedStatement stmt = this.con.
                    prepareStatement("select * from usuarios where user=? and senha=? LIMIT 1");

            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato

                usuarioRetorno = new Usuario();
                usuarioRetorno.setId(rs.getInt("id"));
                usuarioRetorno.setNome(rs.getString("nome"));
            }
            rs.close();
            stmt.close();
            return Optional.of(usuarioRetorno);
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }

    }
}
