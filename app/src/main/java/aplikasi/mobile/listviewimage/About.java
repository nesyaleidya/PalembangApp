package aplikasi.mobile.listviewimage;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


public class About extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

   }
