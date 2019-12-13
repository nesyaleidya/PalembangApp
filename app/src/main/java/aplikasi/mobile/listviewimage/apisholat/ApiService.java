package aplikasi.mobile.listviewimage.apisholat;



import aplikasi.mobile.listviewimage.model.ModelJadwal;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("palembang.json")
    Call<ModelJadwal> getJadwal();



}
