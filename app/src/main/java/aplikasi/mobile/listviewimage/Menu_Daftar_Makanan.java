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

public class Menu_Daftar_Makanan extends AppCompatActivity {

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
                R.mipmap.kacangmerah,
                R.mipmap.pindang,
                R.mipmap.pagisore,
                R.mipmap.miecelor,
                R.mipmap.warungaba,
                R.mipmap.martabakhar,
                R.mipmap.mietek};

        NamaItem 	= new String[]{
                "Es Kacang Merah Mamat",
                "Tempoyak Musi Rawas",
                "Rumah Makan Pagi Sore",
                "Mie Celor 26 ",
                "Warung Aba",
                "Martabak Har",
                "Mie Tek Pakde Hadi"};

        HargaItem 	= new String[]{
                "Rp. 9.000",
                "Rp. 50.000",
                "Rp. 20.000",
                "Rp. 15.000",
                "Rp. 20.000",
                "Rp. 21.000",
                "Rp. 12.000"};

        Deskripsi 	= new String[]{
                "Dessert lokal favorit di Palembang. Es kacang merah menjadi salah satu " +
                        " es kacang merah Palembang favorit adalah “Es Mamat” yang berada di komplek Lapangan Hatta " +
                        "Buka : 08.00 - 16.00 Setiap Hari",

                "Kuliner ini merupakan makanan fermentasi yang terbuat dari buah durian dan " +
                        "digemari masyarakat Kota Palembang. Makanan ini pun sering digunakan"+
                        "sebagai campuran untuk memasak makanan tradisional seperti pempek, pepes ikan, sambal, dll"+
                        "Buka : 09.00 - 21.00 Setiap Hari",

                " R.M Pagi Sore membuktikan kalau di Palembang kamu juga bisa menjumpai menu masakan rendang yang tak kalah lezatnya." +
                        "tempat ini justru menyajikan rendang berwarna cokelat tua dengan bumbu dan kuah yang begitu pekat"+
                        " Daging rendangnya sendiri bercita rasa gurih dan sedikit manis" +
                        "Buka : 09.00 - 22.00 Setiap Hari",

                "komponen utama mi celor relatif lebih sederhana yaitu terdiri dari "+
                        "mi telur, taoge, dan kuah kaldu yang kental dan gurih." +
                        "Buka Pukul : 06.00 - 17.00 Setiap Hari",

                " Menyediakan berbagai makanan khas palembang dengan rasa yang enak dan harga yang pastinya terjangkau" +
                        "Menu : Burgo, Laksan, Lakso, Celampung, Ragit, Lontong, Martabak Kentang, Pempek" +
                        "Buka : 06.00 - 12.00 Setiap Hari",

                "Martabak HAR hanya berisi dua butir telur ayam atau telur bebek." +
                        "biasa dinikmati bersama kuah kari yang dicampur kentang dan daging" +
                        "Buka : 07.00 - 23.00 Setiap Hari ",

                "Mie Tek-Tek merupakan suatu olahan mie yang sangat menarik dan enak"+
                        " Buka : 17.30 - 23.00 Setiap Hari"};



        NomorHP  = new String[]{
                "+6281278977788",
                "(0711) 370590",
                "(0711) 510655",
                "(0711) 5630501",
                "(0711) 713991",
                "(0711) 358432",
                "+6285378109786"
        };

        Lat  = new String[]{
                "-2.9771237",
                "-2.969675",
                "-3.0000124",
                "-2.9913172",
                "-2.9801306",
                "-2.9913172",
                "-2.9670725"
        };

        Long  = new String[]{
                "104.7573521",
                "104.7318573",
                "104.7593849",
                "104.7516047",
                "104.7693137",
                "104.7450386",
                "104.741623"
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
