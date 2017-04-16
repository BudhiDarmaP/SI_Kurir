/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitPemesanan;

import Model.Pengiriman;

/**
 *
 * @author budhidarmap
 */
public class testListPemesanan {

    public static void main(String[] args) {
        Pengiriman p[] = Pengiriman.getListPengiriman("13042017");
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getID());
            System.out.println(p[i].getID_pelanggan());
            System.out.println(p[i].getID_kurir());
            System.out.println(p[i].getTanggal());
            System.out.println(p[i].getAsal());
            System.out.println(p[i].getTujuan());
            System.out.println(p[i].getJarak()+" Km");
            System.out.println(p[i].getBarang());
            System.out.println("Rp."+p[i].getBiaya()+",00");
            System.out.println(p[i].isStatus());
        }
    }
}
