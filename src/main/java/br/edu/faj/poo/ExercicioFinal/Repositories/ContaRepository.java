package br.edu.faj.poo.ExercicioFinal.Repositories;

import br.edu.faj.poo.ExercicioFinal.Entities.Conta;
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
public class ContaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Conta> obter() throws Exception {
        String sqlSelect = "SELECT * FROM conta";

        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sqlSelect)
        ) {
            List<Conta> contas = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery()) {

                // Enquanto ouver contas
                while (rs.next()) {
                    Conta conta = new Conta();
                    conta.setId(rs.getInt("id"));
                    conta.setLogin(rs.getString("login"));
                    conta.setSenha(rs.getString("senha"));

                    // Adicionando a conta encontrada à lista de contas
                    contas.add(conta);
                }
            }
            return contas;
        }
    }

    public Conta obterPorId(int id) throws Exception {
        String sqlSelect = "SELECT id, login, senha FROM conta WHERE id = ?";

        // comandos executados dentro do () do try para garantir que as conexões sejão fechadas
        try (
                // Conexão com o banco de dados
                Connection con = jdbcTemplate.getDataSource().getConnection();

                // PreparedStatement inicializado com a instrução SQL
                PreparedStatement ps = con.prepareStatement(sqlSelect)
        ) {

            // Definindo o ID como um parâmetro no PreparedStatement, referente ao ? da query
            ps.setInt(1, id);

            // Executando a consulta e obtendo o ResultSet
            try (ResultSet rs = ps.executeQuery()) {

                // Verificando se há uma linha no ResultSet
                if (rs.next()) {
                    // Criando um objeto Conta e definindo os valores do ResultSet
                    Conta conta = new Conta();
                    conta.setId(rs.getInt("id"));
                    conta.setLogin(rs.getString("login"));
                    conta.setSenha(rs.getString("senha"));

                    // Retornando a conta encontrada
                    return conta;
                }
            }

            // Retorna null se nenhuma conta for encontrada
            return null;
        }
    }

    public Conta obterPorLogin(String login) throws Exception {
        String sqlSelect = "SELECT id, login, senha FROM conta WHERE login = ?";
        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sqlSelect);
        ) {
            ps.setString(1, login);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Conta conta = new Conta();
                    conta.setId(rs.getInt("id"));
                    conta.setLogin(rs.getString("login"));
                    conta.setSenha(rs.getString("senha"));
                    return conta;
                }
            }

            return null;
        }
    }

    public Conta cadastrar(Conta conta) throws Exception {
        String sqlInsertConta = "INSERT INTO conta (login, senha) VALUES (?, ?)";
        try (
                Connection con = jdbcTemplate.getDataSource().getConnection();
                PreparedStatement psInsertConta = con.prepareStatement(sqlInsertConta, Statement.RETURN_GENERATED_KEYS);
        ) {
            psInsertConta.setString(1, conta.getLogin());
            psInsertConta.setString(2, conta.getSenha());

            // caso linha seja afetada (conta adicionada)
            if (psInsertConta.executeUpdate() == 1) {
                return conta;
            } else {
                throw new Exception("Erro ao cadastrar Conta.");
            }
        }
    }
}
