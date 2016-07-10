package com.thatsterrible.travato;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by naomikoo on 16-06-12.
 */
public class FirstTimeLoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_choose_traveller_local, container, false);

        ImageView picture = (ImageView) v.findViewById(R.id.first_time_login_picture);

//        picture.setImageURI(); todo how can we pull image from facebook?

        return v;
    }
}
