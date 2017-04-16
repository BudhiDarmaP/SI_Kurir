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
public class testHapusPesanan {
    public static void main(String[] args) {
        Pengiriman p = new Pengiriman();
        p.hapusPengiriman("13042017170407001", "170407001");
    }
}
