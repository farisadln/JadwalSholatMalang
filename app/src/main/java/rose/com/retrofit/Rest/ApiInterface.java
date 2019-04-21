package rose.com.retrofit.Rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rose.com.retrofit.Model.Items;

public interface ApiInterface {

    @GET("Malang/{periode}/dayli.json")
    Call<Items> getJadwalSholat(@Path("periode")String periode);
}
