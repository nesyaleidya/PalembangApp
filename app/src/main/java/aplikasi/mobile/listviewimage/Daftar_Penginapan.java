package aplikasi.mobile.listviewimage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Daftar_Penginapan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapterCall adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<ListViewAdapterMenu>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.jasmine,
                R.mipmap.fabel,
                R.mipmap.srijaya,
                R.mipmap.airi,
                R.mipmap.rambang,
                R.mipmap.pipe,
                R.mipmap.winer};

        NamaItem 	= new String[]{
                "Wisma Jasmine Syariah",
                "Homestay Fabel",
                "Wisma Srijaya",
                "Airy Eco Ilir Timur Dua Lingkaran",
                "Hotel Rambang",
                "The Pipe House",
                "Hotel Winer"};

        HargaItem 	= new String[]{
                "Rp. 100.000 - 150.000 ",
                "Rp. 120.000 - 150.000",
                "Rp. 108.000",
                "Rp. 100.000 - 120.000",
                "Rp. 100.000- Rp.130.000",
                "Rp. 100.000 - Rp. 170.000",
                "Rp. 100.000 - Rp. 300.000"};

        Deskripsi 	= new String[]{
                "Penginapan Yang Tenang Dan Nyaman di Palembang. Wisma Jasmine Syariah sebuah hunian yang berlokasi di Ilir Timur II " +
                        " Suasana ruangan yang bersih dan nyaman, cocok bagi Anda yang akan berlibur atau mengadakan kunjungan bisnis " +
                        "Lokasi yang strategis sehingga mudah untuk diakses, dan harga yang terjangkau \n"+
                        "Alamat: Jl. R. Sukamto, 8 Ilir, Kec. Ilir Tim. II, Kota Palembang, Sumatera Selatan 30127",

                "Homestay murah dengan wifi gratis dan kamar AC dapat memanjalankan anda saat menginap" +
                        "Akses kemana saja cukup mudah, dan layanan yang terbaik  \n"+
                        "Jl. Hos Cokro Aminoto No. 06 RT/RW 041/014 Kec. 30 Ilir Kel, 30 Ilir, Kec. Ilir Bar. II",

                " Pilihan akomodasi yang ideal untuk Pasangan, Backpacker dan Liburan Keluarga." +
                        "Wisma Srijaya sebuah hunian yang berlokasi di Palembang. Suasana ruangan yang bersih dan nyaman, cocok bagi Anda "+
                        " yang akan berlibur atau mengadakan kunjungan bisnis. Lokasi yang strategis sehingga mudah untuk diakses, dan harga terjangkau \n" +
                        "Jl. Inspektur Marzuki No.2924, Siring Agung, Kec. Ilir Bar. I, Kota Palembang",

                "AIRY ECO adalah pilihan kamar Airy dengan harga paling bersahabat yang bekerja sama dengan hotel bujet, residence, "+
                        "penginapan dan guest house. Fasilitas AC tidak tersedia untuk kamar Airy Eco tertentu di area-area beriklim dingin" +
                        "Wifi Gratis, Perlengakapan Mandi, TV, Perlengkapan Mandi\n"+
                        "Jl. Lingkaran No.565, kec, 15 Ilir, Ilir Timur II, Palembang City",

                " Akomodasi yang tak kalah nyaman dan terjangkau. Hotel Rambang sebuah penginapan yang luar biasa berlokasi strategis." +
                        "Pilihan yang fantastis untuk mendapatkan pengalaman yang tidak terlupakan. Nikmati layanan professional," +
                        "penuh perhatian, dan ramah demi kenyamanan Anda selama menginap.\n"+
                        " Jl. Mayor Ruslan No.4216, 9 Ilir, Kec. Ilir Tim. II, Kota Palembang",

                "OYO 183 The Pipe House terletak di Palembang, bearada dalam jarak 10 km dari Jembatan Ampera dan 6 km" +
                        "dari Palembang Square. Hotel bintang 2 ini menawarkan ruang bersama dan kamar-kamar dengan AC, Wi-Fi gratis" +
                        "kamar mandi pribadi. Kamar-kamar di hotel ini dilengkapi dengan TV layar datar.\n"+
                        "Lrg. Mufakat 2 No.3672, Pipa Jaya, Kec. Kemuning, Kota Palembang",

                "Hotel simpel murah dengan eksterior penuh warna yang terletak di daerah perumahan ini berjarak 2 km"+
                        " dari stasiun LRT Pasar Cinde dan Benteng Kuto Besak dari abad ke-18.\n"+
                    " Lorong Karyawan, 9 Ilir, Kec. Ilir Tim. II, Kota Palembang"};


        //Nomor HP harus dimulai dengan kode negara yaitu : +62
        NomorHP  = new String[]{
                "+6281273360849",
                "+628119213338",
                "+6285366650348",
                "+628041112479",
                "(0711) 312804",
                "(021) 39501530",
                "(021) 39501530"
        };

        Lat  = new String[]{
                "-2.9534835",
                "-2.9890052",
                "-2.9622625",
                "-2.980624",
                "-2.9695852",
                "-2.94304",
                "-2.9766868"
        };

        Long  = new String[]{
                "104.7590557",
                "104.7386068",
                "104.7169329",
                "104.7628654",
                "104.7593188",
                "104.7448394",
                "104.765323"
        };




        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], NomorHP[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
