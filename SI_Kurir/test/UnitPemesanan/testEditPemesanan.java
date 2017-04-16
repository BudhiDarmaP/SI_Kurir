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
public class testEditPemesanan {
    //X
    public static void main(String[] args) {
        Pengiriman p = new Pengiriman();
        p.setID("13042017170407001");
        p.setID_pelanggan("170407001");
        p.setAsal("Arab");
        p.setTujuan("Surga");
        p.setJarak(3000);
        p.setBarang("Bidadari");
        p.setBiaya(p.Biaya(p.getJarak()));
        p.editPengiriman(p);
    }
}
