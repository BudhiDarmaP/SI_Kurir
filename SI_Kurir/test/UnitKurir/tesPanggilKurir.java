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
public class tesPanggilKurir {
    public static void main(String[] args) {
        Kurir k = new Kurir();
        k = k.panggilKurir("kacung@email.id", "123");
        System.out.println(k.getID());
        System.out.println(k.getNama());
        System.out.println(k.getEmail());
        System.out.println(k.getNo_tlp());
        System.out.println(k.getAlamat());
        System.out.println(k.getPassword());
    }
}
