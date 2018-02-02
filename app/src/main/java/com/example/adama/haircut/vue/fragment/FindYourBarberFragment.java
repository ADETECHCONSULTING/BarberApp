package com.example.adama.haircut.vue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adama.haircut.adapter.BarberAdapter;
import com.example.adama.haircut.R;
import com.example.adama.haircut.modele.Barber;

import java.util.ArrayList;

/**
 * Created by Adama on 22/01/2018.
 */

public class FindYourBarberFragment extends Fragment {
    private RecyclerView rcvMain;
    private ArrayList<Barber> lesBarbers = new ArrayList<>();
    private BarberAdapter barberAdapter;

    public static FindYourBarberFragment newInstance(){
        FindYourBarberFragment fragment = new FindYourBarberFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        rcvMain = view.findViewById(R.id.rcvMain);

        lesBarbers.add(new Barber("Elige", getString(R.string.lorem), getString(R.string.url_1)));
        lesBarbers.add(new Barber("Adama", getString(R.string.lorem), getString(R.string.url_2)));
        lesBarbers.add(new Barber("Will", getString(R.string.lorem), getString(R.string.url_3)));
        lesBarbers.add(new Barber("Tali", getString(R.string.lorem), getString(R.string.url_1)));


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        rcvMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        barberAdapter = new BarberAdapter(getActivity().getApplicationContext());
        rcvMain.setAdapter(barberAdapter);

        barberAdapter.resetData(lesBarbers);
    }

}
