/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.dispositivos.DispositivoUsb;
import com.github.britooo.looca.api.group.dispositivos.DispositivosUsbGrupo;
import java.util.List;

/**
 *
 * @author vitor
 */
public class teste {
    public static void main(String[] args) {
        Looca looca =new Looca();
  
         DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        System.out.println(        grupoDeDiscos.getTamanhoTotal()
);
            
    }
}
