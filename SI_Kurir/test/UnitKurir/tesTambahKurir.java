/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitKurir;

import Model.Kurir;
import UnitPelanggan.*;

/**
 *
 * @author budhidarmap
 */
public class tesTambahKurir {
    public static void main(String[] args) {
        Kurir k = new Kurir();
        k.setID("120417002");
        k.setNama("aku");
        k.setEmail("aku@email.id");
        k.setNo_tlp("00000000001");
        k.setAlamat("Akuaku");
        k.setPassword("123");
        k.tambahKurir(k);
    }
}
