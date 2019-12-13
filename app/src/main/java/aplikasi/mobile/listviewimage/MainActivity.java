package aplikasi.mobile.listviewimage;


import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        TextView kuliner = (TextView) findViewById(R.id.kuliner);

        kuliner.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent kulinerIntent = new Intent(MainActivity.this, Menu_Daftar_Makanan.class);
                startActivity(kulinerIntent);
            }
        });

        TextView wisata = (TextView) findViewById(R.id.wisata);

        wisata.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                Intent wisataIntent = new Intent(MainActivity.this, Menu_Daftar_Wisata.class);
                startActivity(wisataIntent);
            }
        });
        TextView penginapan = (TextView) findViewById(R.id.penginapan);

        penginapan.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                Intent penginapanIntent = new Intent(MainActivity.this, Daftar_Penginapan.class);
                startActivity(penginapanIntent);
            }
        });

        TextView cuaca = (TextView) findViewById(R.id.cuaca);

        cuaca.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                Intent cuacaIntent = new Intent(MainActivity.this, Cuaca.class);
                startActivity(cuacaIntent);
            }
        });

        TextView sholat = (TextView) findViewById(R.id.sholat);

        sholat.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                Intent sholatIntent = new Intent(MainActivity.this, SholatActivity.class);
                startActivity(sholatIntent);
            }
        });

        TextView about = (TextView) findViewById(R.id.aboutme);
        about.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(MainActivity.this, About.class);
                startActivity(aboutIntent);
            }
        });



    }};

