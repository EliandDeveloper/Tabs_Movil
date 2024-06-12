package com.example.tabs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Registro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Registro extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText nameText, emailText, passwordText;
    private Button register;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Registro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Registro.
     */
    // TODO: Rename and change types and number of parameters
    public static Registro newInstance(String param1, String param2) {
        Registro fragment = new Registro();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registro, container, false);

        nameText = view.findViewById(R.id.name);
        emailText = view.findViewById(R.id.email);
        passwordText = view.findViewById(R.id.password);
        register = view.findViewById(R.id.register_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
                    showNewScreen(name);
                }
            }
        });

        return view;
    }

    private void showNewScreen(String name) {
        Intent intent = new Intent(getActivity(), BienvenidaActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}