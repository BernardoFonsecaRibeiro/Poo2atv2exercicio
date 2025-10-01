/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import static br.ulbra.DAO.AbstractDAO.getConnection;
import br.ulbra.Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
  public void salvar(Fornecedor f) throws SQLException {
        String sql = "INSERT INTO fornecedor (nomerazao, nomefantasia, telefone, email) VALUES (?, ?, ?,?)";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, f.getNomeRazao());
            ps.setString(2, f.getNomeFantasia());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getEmail());

            int affected = ps.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Falha ao inserir fornecedor.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    f.setId(rs.getInt(1));
                }
            }
        }
    }

    public Fornecedor buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM fornecedor WHERE idfor = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Fornecedor(
                            rs.getInt("idfor"),
                            rs.getString("nomerazao"),
                            rs.getString("nomefantasia"),
                            rs.getString("telefone"),
                            rs.getString("email")
                    );
                }
            }
        }
        return null;
    }

    public List<Fornecedor> listar() throws SQLException {
        String sql = "SELECT * FROM fornecedor ORDER BY nomerazao";
        List<Fornecedor> lista = new ArrayList<>();

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fornecedor f = new Fornecedor(
                        rs.getInt("idfor"),
                        rs.getString("nomerazao"),
                        rs.getString("nomefantasia"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                lista.add(f);
            }
        }
        return lista;
    }

    public void atualizar(Fornecedor f) throws SQLException {
        String sql = "UPDATE fornecedor SET nomerazao = ?, nomefantasia = ?,telefone = ?, email = ?  WHERE idfor = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, f.getNomeRazao());
            ps.setString(2, f.getNomeFantasia());
            ps.setString(3, f.getTelefone());
            ps.setString(4, f.getEmail());
            ps.setInt(5, f.getId());

            ps.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM fornecedor WHERE idfor = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
  
 
}
