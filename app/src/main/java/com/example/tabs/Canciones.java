package com.example.tabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Canciones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Canciones extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Map<String, String> songLinks;


    public Canciones() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Canciones.
     */
    // TODO: Rename and change types and number of parameters
    public static Canciones newInstance(String param1, String param2) {
        Canciones fragment = new Canciones();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Links de las canciones

        songLinks = new HashMap<>();

        songLinks.put("Let's Groove", "https://www.youtube.com/watch?v=yHLTV-ZC4lM");
        songLinks.put("Another Believer", "https://www.youtube.com/watch?v=WwcEH24Ommw");
        songLinks.put("Little Wonders", "https://www.youtube.com/watch?v=drbmygu46GM");
        songLinks.put("Any Kind Of Life", "https://www.youtube.com/watch?v=2q1i7xymL6E");
        songLinks.put("How I'm Feeling Now", "https://www.youtube.com/watch?v=x7vqvZlyxfw");
        songLinks.put("I'm Still Here", "https://www.youtube.com/watch?v=MUZwblurraA");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_canciones, container, false);

        ListView listView = view.findViewById(R.id.song_list_view);
        List<String> songNames = new ArrayList<>(songLinks.keySet());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, songNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String songTitle = songNames.get(position);
                String songUrl = songLinks.get(songTitle);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(songUrl));
                startActivity(browserIntent);
            }
        });

        return view;
    }
}