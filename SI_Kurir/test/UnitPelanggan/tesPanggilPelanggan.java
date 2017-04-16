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
public class tesPanggilPelanggan {
    public static void main(String[] args) {
        Pelanggan p = new Pelanggan();
        p = p.panggilPelanggan("mimiperi@perikhayangan.hvn", "123");
        System.out.println(p.getID());
        System.out.println(p.getNama());
        System.out.println(p.getEmail());
        System.out.println(p.getNo_tlp());
        System.out.println(p.getAlamat());
        System.out.println(p.getPassword());
    }
}
