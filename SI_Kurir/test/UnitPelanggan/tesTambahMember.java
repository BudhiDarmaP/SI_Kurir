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
public class tesTambahMember {
    public static void main(String[] args) {
        Pelanggan p = new Pelanggan();
        p.setID("240317001");
        p.setNama("Mimi Peri");
        p.setEmail("mimiperi@perikhayangan.hvn");
        p.setNo_tlp("00000000000");
        p.setAlamat("Langit Ke 7");
        p.setPassword("123");
        p.tambahMember(p);
    }
}
