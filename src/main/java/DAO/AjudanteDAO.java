/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Ajudante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AjudanteDAO {

    java.sql.Connection con = new conecta().getConnection();

    public void cadastro(Ajudante ajudante) throws Exception {
        String sql = "insert into ajudante(nome, sexo, dataInicio, cidade, estado, idade) values(?,?,?,?,?,?)";

        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
            preparestatement.setString(1, ajudante.getNome());
            preparestatement.setString(2, ajudante.getSexo());
            preparestatement.setString(3, ajudante.getDataInicio());
            preparestatement.setString(4, ajudante.getCidade());
            preparestatement.setString(5, ajudante.getEstado());
            preparestatement.setInt(6, ajudante.getIdade());
            preparestatement.execute();
            preparestatement.close();
        } catch (SQLException e) {
            throw new Exception("Não foi possível cadastrar o ajudante.");

        }

    }

    public boolean consultaAjudante(Ajudante ajudante) throws Exception {

        String sql = "select * from ajuda_humanitaria.ajudante where nome = ?";
        boolean retornaAjudante = false;

        try (PreparedStatement preparestatement = con.prepareStatement(sql)) {

            preparestatement.setString(1, ajudante.getNome());
            ResultSet resultado = preparestatement.executeQuery();

            retornaAjudante = resultado.next();
            preparestatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return retornaAjudante;
    }

    public List<Ajudante> buscarTodos() throws Exception {
        List<Ajudante> listarAjudantes = new ArrayList<>();

        String sql = "Select * from ajudante";
        Ajudante ajudante = null;

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            ResultSet resultado = preparedStatement.executeQuery();

            /*
			 * Dentro do while estou verificando se tem registro no banco de dados, enquanto tiver registro vai 
			 * adcionando um a um na lista e no final fora do while retorna todos os registro encontrados. 
             */
            while (resultado.next()) {
                ajudante = new Ajudante();
                ajudante.setId(resultado.getInt("id"));
                ajudante.setNome(resultado.getString("nome"));
                ajudante.setSexo(resultado.getString("sexo"));
                ajudante.setDataInicio(resultado.getString("dataInicio"));
                ajudante.setCidade(resultado.getString("cidade"));
                ajudante.setEstado(resultado.getString("estado"));
                ajudante.setIdade(resultado.getInt("idade"));

                // Adcionando cada registro encontro, na lista .
                listarAjudantes.add(ajudante);
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível listar os ajudantes.");
        }
        return listarAjudantes;

    }
}
