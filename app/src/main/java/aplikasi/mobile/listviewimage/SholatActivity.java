package aplikasi.mobile.listviewimage;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;

import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.view.MenuItem;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


//import com.google.android.material.floatingactionbutton.FloatingActionButton;

import aplikasi.mobile.listviewimage.apisholat.ApiService;
import aplikasi.mobile.listviewimage.apisholat.ApiUrl;
import aplikasi.mobile.listviewimage.model.ModelJadwal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SholatActivity extends AppCompatActivity {

    private TextView tv_lokasi_value, tv_fajr_value, tv_shurooq_value,
            tv_dhuhr_value, tv_asr_value, tv_maghrib_value, tv_isha_value;
    //private FloatingActionButton fab_refresh;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sholat);

        getSupportActionBar().setTitle("Jadwal Sholat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_lokasi_value = findViewById(R.id.tv_lokasi_value);
        tv_fajr_value = findViewById(R.id.tv_fajr_value);
        tv_shurooq_value = findViewById(R.id.tv_shurooq_value);
        tv_dhuhr_value = findViewById(R.id.tv_dhuhr_value);
        tv_asr_value = findViewById(R.id.tv_asr_value);
        tv_maghrib_value = findViewById(R.id.tv_maghrib_value);
        tv_isha_value = findViewById(R.id.tv_isha_value);
        //fab_refresh = findViewById(R.id.fab_refresh);

        getJadwal();

        /*fab_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJadwal();
            }
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getJadwal () {

        progressDialog = new ProgressDialog(SholatActivity.this);
        progressDialog.setMessage("Please Wait / Silahkan tunggu ...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_ROOT_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<ModelJadwal> call = apiService.getJadwal();

        call.enqueue(new Callback<ModelJadwal>() {
            @Override
            public void onResponse(Call<ModelJadwal> call, Response<ModelJadwal> response) {

                progressDialog.dismiss();

                if(response.isSuccessful())
                    Toast.makeText(SholatActivity.this, "SUKSES", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SholatActivity.this, "GAGAL", Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    tv_lokasi_value.setText(response.body().getCity()+", "+response.body().getItems().get(0).getDateFor());
                    tv_fajr_value.setText(response.body().getItems().get(0).getFajr());
                    tv_shurooq_value.setText(response.body().getItems().get(0).getShurooq());
                    tv_dhuhr_value.setText(response.body().getItems().get(0).getDhuhr());
                    tv_asr_value.setText(response.body().getItems().get(0).getAsr());
                    tv_maghrib_value.setText(response.body().getItems().get(0).getMaghrib());
                    tv_isha_value.setText(response.body().getItems().get(0).getIsha());

                } else {

                }
            }

            @Override
            public void onFailure(Call<ModelJadwal> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(SholatActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
