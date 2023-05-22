/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import conexao.JDBC.Conexao;
import conexao.JDBC.Empresa;
import conexao.JDBC.EnviaDados;
import conexao.JDBC.InfoMaquina;
import conexao.JDBC.Maquina;
import conexao.JDBC.RegistroAtividade;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rafae
 */
public class EnviaDados {

    Conexao conexao = new Conexao();
    JdbcTemplate conMysql = conexao.getConnection();
    JdbcTemplate conAzure = conexao.getConnectionAzu();

    public void iniciarEnvio() {

        while (true) {
            try {
                ColetaProcessador coletacontinua = new ColetaProcessador();
                ColetaMemoria coletacontinuamem = new ColetaMemoria();
                ColetaHDInfo coletacontinuaHD = new ColetaHDInfo();
//                conAzure.query(psc, rse)
                System.out.println(coletacontinua);
                System.out.println(coletacontinuaHD);
                System.out.println(coletacontinuamem);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
