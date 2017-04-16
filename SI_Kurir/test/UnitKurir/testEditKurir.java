/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitKurir;

import UnitPelanggan.*;
import Model.Kurir;

/**
 *
 * @author budhidarmap
 */
public class testEditKurir {
    public static void main(String[] args) {
        Kurir k = new Kurir();
        k.setID("120417001");
        k.setNama("Kacung Bola");
        k.setEmail("kacung@email.id");
        k.setNo_tlp("00000000000");
        k.setAlamat("Belakang Gawang");
        k.editKurir(k);
    }
}
