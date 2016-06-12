package com.thatsterrible.travato;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by naomikoo on 16-06-12.
 */
public class ChooseTravellerOrLocalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_choose_traveller_local, container, false);

        RelativeLayout chooseTravellerButton = (RelativeLayout) v.findViewById(R.id.choose_traveller_button);
        RelativeLayout chooseLocalsButton = (RelativeLayout) v.findViewById(R.id.choose_local_button);

        chooseTravellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: launch activity that travellers start with: My Tours. Find out what My Tours needs; user id? If so, how do we get it? from login?
            }
        });

        chooseLocalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: launch activity that locals start with; My Tours maybe? consult backend
            }
        });

        return v;
    }
}
