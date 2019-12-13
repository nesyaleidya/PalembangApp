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

public class Menu_Daftar_Wisata extends AppCompatActivity {

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
                R.mipmap.bkb,
                R.mipmap.bukitsiguntang,
                R.mipmap.puntikayu,
                R.mipmap.ampera,
                R.mipmap.tamanki,
                R.mipmap.pulaukemaro,
                R.mipmap.alquran};

        NamaItem 	= new String[]{
                "Benteng Kuto Besak",
                "Bukit Siguntang",
                "Taman Wisata Alam Punti Kayu",
                "Jembatan Ampera ",
                "Taman Kambang Iwak",
                "Pulau Kemaro",
                "Wisata Religi Al Quran Raksasa"};

        HargaItem 	= new String[]{
                "Free ",
                "Rp. 2000",
                "Rp. 5000 - Rp. 20.000",
                "Free",
                "Free",
                "Ketek : Rp. 30.000",
                "Rp. 5000"};

        Deskripsi 	= new String[]{
                "Benteng Kuto Besak adalah bangunan keraton yang pada abad XVIII menjadi pusat Kesultanan Palembang " +
                        " Gagasan mendirikan Benteng Kuto Besak diprakarsai oleh Sultan Mahmud Badaruddin I yang memerintah pada tahun 1724-1758 " +
                        " dilihat dari daerah Seberang Ulu atau Jembatan Ampera, pemandangan yang tampak adalah pelataran luas dengan latar belakang deretan pohon palem" +
                        "malam hari, suasana akan terasa lebih dramatis. Cahaya dari deretan lampu-lampu taman menciptakan refleksi warna kuning pada permukaan sungai. ",

                "ukit Siguntang merupakan tempat ibadah sekaligus situs yang menyimpan kisah kerajaan sriwijaya" +
                        "Wisatawan datang kesini umumnya adalah untuk mencari informasi tentang cerita kerajaan sriwijaya."+
                        "Selain itu, tempat ini dijadikan sebagai tempat ziarah oleh wisatawan untuk menghormati bangsawan tempo dulu."+
                        "Buka : 07.00 - 16.00 Setiap Hari",

                " Sebuah kawasan pelestarian alam yang dimanfaatkan untuk kegiatan pariwisata alam dan rekreasi di Palembang" +
                        "Terletak di tengah kota Palembang - tepatnya di kawasan Km.7 Palembang, Punti Kayu menjadi tempat liburan favorit yang ramai dikunjungi"+
                        " Kawasan ini dilengkapi dengan fasilitas flying fox, taman bermain, miniatur 7 keajaiban dunia, danau, waterpark, dan berbagai hiburan lainnya." +
                        "Buka : 09.00 - 16.00 Setiap Hari",

                " Jembatan Ampera (Amanat penderitaan rakyat) adalah sebuah jembatan di Kota Palembang, Provinsi Sumatra Selatan, Indonesia "+
                        "Jembatan Ampera, yang telah menjadi semacam lambang kota, terletak di tengah-tengah kota Palembang, " +
                        "menghubungkan daerah Seberang Ulu dan Seberang Ilir yang dipisahkan oleh Sungai Musi. ",

                " Kambang Iwak merupakan tempat favorit bagi yang mau berolahraga pagi sembari rekreasi, tanpa harus mengeluarkan biaya" +
                        "Di sini ada jogging track, juga kolam dengan luas sekitar 750 meter. Tak hanya itu, ada juga tersedia fasilitas bersantai," +
                        "termasuk arena bermain untuk remaja dan anak-anak",

                "Pulau Kemaro, merupakan sebuah delta kecil di Sungai Musi, terletak sekitar 6 km dari Jembatan Ampera. Pulau Kemaro terletak di daerah industri,." +
                        "yaitu di antara Pabrik Pupuk Sriwijaya dan Pertamina Plaju dan Sungai Gerong. Posisi Pulau Kemaro adalah agak ke timur dari pusat Kota Palembang" +
                        "Daya tarik wisata sejarah yang ada di pulau Kemaro berupa adanya peninggalan-peninggalan sejarah (Pagoda berlantai 9, " +
                        " Makam putri Sriwijaya, Klenteng Hok Tjing Rio, Kuil Buddha, pertunjukkan kesenian, dan ritual keagamaan khususnya umat Tridharma)"+
                        "Jam buka 9 Pagi - 10 Malam ",

                "Wisata Religi Alquran Terbesar di Sumatera Selatan"+
                        " Buka : 08.00 - 17.00 Setiap Hari"};


        //Nomor HP harus dimulai dengan kode negara yaitu : +62
        NomorHP  = new String[]{
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        };

        Lat  = new String[]{
                "-2.9913357",
                "-2.9971478",
                "-2.9444698",
                "-2.991774",
                "-2.989787",
                "-2.9786105",
                "-3.0111215"
        };

        Long  = new String[]{
                "104.7417618",
                "104.71706",
                "104.7096838",
                "104.7593899",
                "104.7289392",
                "104.7825662",
                "104.686563"
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
