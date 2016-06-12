package com.thatsterrible.travato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by naomikoo on 16-06-11.
 */
public class ChooseLocalTour extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LocalToursAdapter mLocalToursAdapter;
    private List<LocalActivityItem> mLocalToursList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRecyclerView = new RecyclerView(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mLocalToursAdapter = new LocalToursAdapter();
        mRecyclerView.setAdapter(mLocalToursAdapter);

//        getData();

        setContentView(R.layout.activity_choose_local);
        mLocalToursAdapter.addLocalTour(new LocalActivityItem(null,"Biking with Ru", "Ru Li", "Waterloo", "biking :D", "5000","Aug 26", "Aug 27","1/2"));

    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
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

                    mLocalToursAdapter.setLocalToursList(mLocalToursList);

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

            LocalActivityItem item =
                    new LocalActivityItem(imgurl, tourTitle, guideName, cityName,
                            description, price, startDate, endDate, capacity);

            mLocalToursList.add(item);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
