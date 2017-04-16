package UnitPemesanan;

import Model.Pengiriman;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author budhidarmap
 */
public class testUbahStatus {
    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        Pengiriman p = Pengiriman.panggilPemesanan("170407001",timeStamp);
        p.setID_kurir("120417001");
        p.ubahStatus(p);
    }
}
