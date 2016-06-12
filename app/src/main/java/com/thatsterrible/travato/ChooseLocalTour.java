package com.thatsterrible.travato;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

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
public class ChooseLocalTour extends DrawerActivity {

    private RecyclerView mRecyclerView;
    private LocalToursAdapter mLocalToursAdapter;
    private List<LocalTourItem> mLocalToursList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_local);

        mRecyclerView = (RecyclerView) findViewById(R.id.local_activities_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mLocalToursAdapter = new LocalToursAdapter();
        mRecyclerView.setAdapter(mLocalToursAdapter);

//        getData();

        // test data
        mLocalToursAdapter.addLocalTour(new LocalTourItem(null,"Biking with Ru", "Ru Li", "Waterloo", "biking :D", "5000","Aug 26", "Aug 27","1/2"));
        mLocalToursAdapter.addLocalTour(new LocalTourItem(null,"Frolicking with Ru", "Ru Li", "Waterloo", "biking :D", "8000","Aug 26", "Aug 27","1/20"));

    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("STUFFFFF")
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

            LocalTourItem item =
                    new LocalTourItem(imgurl, tourTitle, guideName, cityName,
                            description, price, startDate, endDate, capacity);

            mLocalToursList.add(item);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
