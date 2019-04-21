package rose.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rose.com.retrofit.Model.Items;
import rose.com.retrofit.Model.Jadwal;
import rose.com.retrofit.Rest.ApiClient;
import rose.com.retrofit.Rest.ApiInterface;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvSubuh)
    TextView tvSubuh;

    @BindView(R.id.tvZuhur)
    TextView tvZuhur;

    @BindView(R.id.tvAshar)
    TextView tvAshar;

    @BindView(R.id.tvMagrhib)
    TextView tvMagrhib;

    @BindView(R.id.tvIsya)
    TextView tvIsya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void loadData(List<Jadwal> jadwal) {

        for (Jadwal data : jadwal) {
            tvSubuh.setText(data.getShurooq());
            tvZuhur.setText(data.getDhuhr());
            tvAshar.setText(data.getAsr());
            tvMagrhib.setText(data.getMaghrib());
            tvIsya.setText(data.getIsha());
        }

    }

    @OnClick(R.id.btnLoadData)
    void actionLoadData(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Items> call = apiService.getJadwalSholat("Malang");

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                List <Jadwal> jadwal = response.body().getItems();
                loadData(jadwal);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {

            }
        });
    }

}
