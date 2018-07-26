package com.bigstark.similarfacebook.app.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bigstark.similarfacebook.R;
import com.bigstark.similarfacebook.model.PictureModel;
import com.bigstark.similarfacebook.rest.PictureService;
import com.bigstark.similarfacebook.rest.SimilarFBClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private HomeAdapter adapter;

    @BindView(R.id.rv_home) RecyclerView rvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        ButterKnife.bind(this);

        rvHome.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HomeAdapter();
        rvHome.setAdapter(adapter);

        PictureService pictureService = SimilarFBClient.create(PictureService.class);
        Call<List<PictureModel>> call = pictureService.getPictures();
        call.enqueue(new Callback<List<PictureModel>>() {
            @Override
            public void onResponse(Call<List<PictureModel>> call, Response<List<PictureModel>> response) {
                if (response.isSuccessful()) {
                    List<PictureModel> pictures = response.body();
                    adapter.setItems(pictures);
                }
            }

            @Override
            public void onFailure(Call<List<PictureModel>> call, Throwable t) {

            }
        });
    }
}
