/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;


import com.github.britooo.looca.api.group.memoria.Memoria;


/**
 *
 * @author rafae
 */
public class ColetaMemoria {

    private Double capacidade;
    private Double valorUtilizado;
    private String unidadeMedida;
    private String tipoComponente;
    private String modeloComponente;

    public ColetaMemoria() {
        Memoria memoria = new Memoria();
//        this.capacidade = memoria.getNumeroCpusFisicas().doubleValue()+memoria.getNumeroCpusLogicas().doubleValue();
        this.capacidade = memoria.getTotal().doubleValue()/1000000000;
        this.valorUtilizado = memoria.getEmUso().doubleValue()/1000000000;
        this.unidadeMedida = "GB";
        this.tipoComponente = "Memória";
        this.modeloComponente = "Unknow";
    }
//  Para enviar à entidade Configuração Componente:
    public Double getCapacidade() {
        return capacidade;
    }
//  Para enviar à entidade Metrica:
    public Double getValorUtilizado() {
        return valorUtilizado;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }
//  Para enviar à entidade Componente:
    public String getTipoComponente() {
        return tipoComponente;
    }

    public String getModeloComponente() {
        return modeloComponente;
    }

    @Override
    public String toString() {
        return "ColetarMemoria{" + "capacidade=" + capacidade + ", valorUtilizado=" + valorUtilizado + ", unidadeMedida=" + unidadeMedida + ", tipoComponente=" + tipoComponente + ", modeloComponente=" + modeloComponente + '}';
    }
    
}
