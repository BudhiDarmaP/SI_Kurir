/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitPelanggan;

import Model.Pelanggan;

/**
 *
 * @author budhidarmap
 */
public class tesPanggilMember {
    public static void main(String[] args) {
        Pelanggan p = Pelanggan.panggilMember("mimiperi@perikhayangan.hvn", "123");
        System.out.println(p.getID());
    }
}
