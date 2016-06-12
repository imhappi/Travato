package com.thatsterrible.travato;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pandominator on 11/06/16.
 */
public class MyToursActivity extends DrawerActivity {

    private RecyclerView mMyRecyclerView;
    private LocalToursAdapter mMyToursAdapter;
    private List<LocalTourItem> mMyToursList;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytours);


        mMyRecyclerView = (RecyclerView) findViewById(R.id.mytours_recycler_view);
        mMyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mMyToursAdapter = new LocalToursAdapter();
        mMyRecyclerView.setAdapter(mMyToursAdapter);

        mMyToursList = new ArrayList<>();

        //getData();
    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("CHANGE THISSSSSSS")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                try {
                    String responseData = response.body().string();
                    JSONObject json = new JSONObject(responseData);
                    JSONArray jsonArray = json.getJSONArray("tours");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tourObject = jsonArray.getJSONObject(i);
                        parseAndAddLocalTourObject(tourObject);
                    }

                    mMyToursAdapter.setLocalToursList(mMyToursList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void parseAndAddLocalTourObject(JSONObject object) {
        try {
            String imgurl = object.getString("pic_url");
            String tourTitle = object.getString("name");
            String guideName = object.getString("NAMEEEEEEEEEEEEEEEE");
            String cityName = object.getString("city");
            String price = object.getString("price");
            String description = object.getString("description");
            String capacity = object.getString("spots_sold") + "/" + object.getString("total_capacity");
            String startDate = object.getString("start_time");
            String endDate = object.getString("end_time");

            LocalTourItem item =
                    new LocalTourItem(imgurl, tourTitle, guideName, cityName,
                            description, price, startDate, endDate, capacity);

            mMyToursList.add(item);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
