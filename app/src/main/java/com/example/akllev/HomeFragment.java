package com.example.akllev;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private TextView textView;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        // Eğer fragment'a parametre eklemek gerekiyorsa, burada Bundle'ı ayarlayabilirsiniz
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Kullanıcı adını göstereceğimiz TextView'e erişim sağla
        textView = view.findViewById(R.id.textView);

        // Eğer kullanıcı adı Bundle ile gönderildiyse, textView'e yaz
        Bundle bundle = getArguments();
        if (bundle != null) {
            String userName = bundle.getString("userName");
            textView.setText("Hello " + userName + "!");
        }

        return view;
    }
}
