/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import java.util.List;

/**
 *
 * @author rafae
 */
public class ColetaProcessador {

    
    private Double capacidade;
    private Double valorUtilizado;
    private String unidadeMedida;
    private String tipoComponente;
    private String modeloComponente;

    public ColetaProcessador() {
        Processador processador = new Processador();
//        this.capacidade = processador.getNumeroCpusFisicas().doubleValue()+processador.getNumeroCpusLogicas().doubleValue();
        this.capacidade = ((processador.getFrequencia().doubleValue())/1000000000)*(processador.getNumeroCpusFisicas()+processador.getNumeroCpusLogicas());
        this.valorUtilizado = processador.getUso();
        this.unidadeMedida = "GHz";
        this.tipoComponente = "Processador";
        this.modeloComponente = processador.getNome();
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
        return "ColetaProcessador{" +  ", capacidade=" + capacidade + ", valorUtilizado=" + valorUtilizado + ", unidadeMedida=" + unidadeMedida + ", tipoComponente=" + tipoComponente + ", modeloComponente=" + modeloComponente + '}';
    }

    
    
    

    
}
