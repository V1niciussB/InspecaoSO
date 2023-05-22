/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import conexao.JDBC.Conexao;
import conexao.JDBC.Maquina;


/**
 *
 * @author vitor
 */

// classe (DAO) Data Access Object - Acesso ao banco de dados
public class UsuarioDAO {

    Connection con;

    // Autenticação do Usuário
    public ResultSet autenticsacaoUsuario(Maquina maquina) {
        
        con = new Conexao().conectaBDAzure();
        

        try {

            String sql = "select * from maquina join empresa on fkempresa=idempresa WHERE patrimonio = ? AND senha = ?";

            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maquina.getPatrimonio());
            pstm.setString(2, maquina.getSenha());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO:" + erro);
            return null;
        }
    }



     // Retorna o fkComponente
    public Integer selectComponente(Maquina maquina) {
        con = new Conexao().conectaBDAzure();

        String sql = "select*from maquina join ConfiguracaoComponente on idmaquina=fkmaquina join componente on fkcomponente=idcomponente where patrimonio = ? AND senha = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, maquina.getPatrimonio());
            pstm.setString(2, maquina.getSenha());

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {

                maquina.setIdMaquina(rs.getInt("idComponente"));

                // Preencha as outras propriedades de Maquina aqui
                return rs.getInt("idMaquina");
            } else {
                return null; // Não encontrou a máquina com o ID fornecido
            }
        } catch (SQLException e) {
            return null;
        }
    }
  
}
//    public Integer getFkMaquina(Integer idMaquina) {
//        conn = new Conexao().conectaBD();
//
//        String sql = "SELECT * FROM componente WHERE idMaquina = ?";
//        try {
//            PreparedStatement pstm = conn.prepareStatement(sql);
//            pstm.setInt(1, idcomponente);
//            ResultSet rs = pstm.executeQuery();
//            if (rs.next()) {
//                Maquina maquina = new Maquina();
//
//                componente.setFkEmpresa(rs.getInt("idcomponente"));
//
//                // Preencha as outras propriedades de Maquina aqui
//                return rs.getInt("idcomponente");
//            } else {
//                return null; // Não encontrou a máquina com o ID fornecido
//            }
//        } catch (SQLException e) {
//            return null;
//        }
//    }
//
//    
//    
//
