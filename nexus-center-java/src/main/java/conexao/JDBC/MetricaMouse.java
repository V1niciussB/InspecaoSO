/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao.JDBC;

/**
 *
 * @author vitor
 */

// Tabela MetricaMouse
public class MetricaMouse {

    private Integer idMetricaMouse;
    private Integer cordenadaX;
    private Integer cordenaday;
    private Integer acaoClick;
    private String dataHora;
    private String status;
    private Integer fkMaquina;
    private Integer fkEmpresa;

    public Integer getIdMetricaMouse() {
        return idMetricaMouse;
    }

    public void setIdMetricaMouse(Integer idMetricaMouse) {
        this.idMetricaMouse = idMetricaMouse;
    }

    public Integer getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(Integer cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public Integer getCordenaday() {
        return cordenaday;
    }

    public void setCordenaday(Integer cordenaday) {
        this.cordenaday = cordenaday;
    }

    public Integer getAcaoClick() {
        return acaoClick;
    }

    public void setAcaoClick(Integer acaoClick) {
        this.acaoClick = acaoClick;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(Integer fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
    
     @Override
    public String toString() {
        return String.format(" idMetricaMouse: %d |"
                + " cordenadaX: %d | cordenaday : %d| acaoClick: %d |"
                + " dataHora: %s | status: %s | fkMaquina: %d | fkEmpresa: %ds",
                 idMetricaMouse, cordenadaX, cordenaday,
                acaoClick, dataHora, status, fkMaquina, fkEmpresa);
    }

}
