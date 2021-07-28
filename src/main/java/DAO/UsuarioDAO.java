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

public class UsuarioDAO {

    java.sql.Connection con = new conecta().getConnection();

    public void cadastro(Usuario usuario) throws Exception {
        String sql = "insert into usuarios(user, senha, nome, sexo) values(?,?,?,?)";

        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
            preparestatement.setString(1, usuario.getUser());
            preparestatement.setString(2, usuario.getSenha());
            preparestatement.setString(3, usuario.getNome());
            preparestatement.setString(4, usuario.getSexo());
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            throw new Exception("Não foi possível cadastrar o usuário.");

        }

    }

    public boolean consultaUsuario(Usuario usuario) throws Exception {

        String sql = "select * from ajuda_humanitaria.usuarios where user = ?";
        boolean retornaUsuario = false;

        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
            
            preparestatement.setString(1, usuario.getUser());
            ResultSet resultado = preparestatement.executeQuery();       

            retornaUsuario = resultado.next();
            preparestatement.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return retornaUsuario;
    }
}
