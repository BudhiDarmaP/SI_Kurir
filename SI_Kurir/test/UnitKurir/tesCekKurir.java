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
public class tesCekKurir {
    public static void main(String[] args) {
        Kurir k = new Kurir();
        System.out.println(k.cekKurir("kacung@email.id"));
    }
}
