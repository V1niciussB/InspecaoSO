/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.software.os.OSFileStore;

/**
 *
 * @author rafae
 */
public class ColetaHDInfo {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Double capacidade;
    private Double valorUtilizado;
    private String unidadeMedida;
    private String tipoComponente;
    private String modeloComponente;
    private String dataHora;
    
    

    public ColetaHDInfo() {
        
        Looca looca=new Looca();
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        Double bytesEscritos=0.0;
        Double capacidadeocupada=0.0;
        dataHora = LocalDateTime.now().format(formatter) ;
//      Foi nescessário criar duas listas para prosseguir com a coleta de dados.       
        List <Disco> listadisco=grupoDeDiscos.getDiscos();
        for (Disco disco : listadisco) {
            bytesEscritos+=disco.getBytesDeEscritas();
            
        }
        List <Volume> listavolumed=grupoDeDiscos.getVolumes();
        for (Volume volume : listavolumed) {
            capacidadeocupada+=volume.getDisponivel();
            
        }
//        this.capacidade = memoria.getNumeroCpusFisicas().doubleValue()+memoria.getNumeroCpusLogicas().doubleValue();
        this.capacidade = grupoDeDiscos.getTamanhoTotal().doubleValue()/1000000000;
        this.valorUtilizado = this.capacidade-(capacidadeocupada/1000000000);
        this.unidadeMedida = "GB";
        this.tipoComponente = "HDTotal";
        this.modeloComponente = "Unknow";
    }
    public void enviaDados(JdbcTemplate template,String fkmaquina,String fkempresa,String fkcomponente){
        template.update("insert into configuracaoComponente(capacidade, unidadeMedida, fkMaquina, fkEmpresa, fkComponente) values (?,?,?,?,?)",
                        this.capacidade,                        
                        this.unidadeMedida,
                        fkmaquina,
                        fkempresa,
                        fkcomponente);
        template.update("insert into configuracaoComponente(valorUtilizado, unidadeMedida, dataHora, fkMaquina, fkEmpresa, fkComponente) values (?,?,?,?,?)",
                        this.valorUtilizado,
                        this.unidadeMedida,
                        this.dataHora,
                        fkmaquina,
                        fkempresa,
                        fkcomponente);
        
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public Double getValorUtilizado() {
        return valorUtilizado;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public String getTipoComponente() {
        return tipoComponente;
    }

    public String getModeloComponente() {
        return modeloComponente;
    }

    @Override
    public String toString() {
        return "ColetaHD{" + "capacidade=" + capacidade + ", valorUtilizado=" + valorUtilizado + ", unidadeMedida=" + unidadeMedida + ", tipoComponente=" + tipoComponente + ", modeloComponente=" + modeloComponente + '}';
    }
    
}

