package br.edu.faj.poo.exerciciofinal.repositories;

import br.edu.faj.poo.exerciciofinal.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Produto> obter() throws Exception {
        String sqlSelect = "SELECT * FROM produto";

        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sqlSelect)
        ) {
            List<Produto> produtos = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {

                // Enquanto ouver produtos
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setQuantidade(rs.getString("quantidade"));
                    produto.setValor(rs.getDouble("valor"));
                    produto.setConta_id(rs.getInt("conta_id"));

                    // Adicionando o produto encontrado à lista de produtos
                    produtos.add(produto);
                }
            }
            return produtos;
        }
    }

    public Produto obterPorId(int id) throws Exception {
        String sqlSelect = "SELECT * FROM produto WHERE id = ?";
        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sqlSelect);
        ) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setQuantidade(rs.getString("quantidade"));
                    produto.setValor(rs.getDouble("valor"));
                    produto.setConta_id(rs.getInt("conta_id"));

                    return produto;
                }
            }

            return null;
        }
    }

    public List<Produto> obterPorContaId(int contaId) throws Exception {
        String sqlSelect = "SELECT * FROM produto WHERE conta_id = ?";
        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sqlSelect);
        ) {
            ps.setInt(1, contaId);

            List<Produto> produtos = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setQuantidade(rs.getString("quantidade"));
                    produto.setValor(rs.getDouble("valor"));
                    produto.setConta_id(rs.getInt("conta_id"));

                    produtos.add(produto);
                }
            }

            return produtos;
        }
    }

    public Produto cadastrar(Produto produto) throws Exception {
        String sqlInsertConta = "INSERT INTO produto (nome, quantidade, valor, conta_id) VALUES (?, ?, ?, ?)";
        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement psInsertProduto = con.prepareStatement(sqlInsertConta, Statement.RETURN_GENERATED_KEYS);
        ) {
            psInsertProduto.setString(1, produto.getNome());
            psInsertProduto.setString(2, produto.getQuantidade());
            psInsertProduto.setDouble(3, produto.getValor());
            psInsertProduto.setInt(4, produto.getConta_id());

            if (psInsertProduto.executeUpdate() == 1) {
                return produto;
            } else {
                throw new Exception("Erro ao cadastrar Produto.");
            }
        }
    }

    public Produto excluir(int id) throws Exception {
        String sqlSelect = "DELETE FROM produto WHERE id = ?";
        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sqlSelect);
        ) {
            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                return null;
            }

            throw new Exception("Erro ao excluir Produto.");
        }
    }
}
