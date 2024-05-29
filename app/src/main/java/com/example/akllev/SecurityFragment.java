package com.example.smarthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecurityFragment extends Fragment {

    private ListView listViewCameras;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_security, container, false);

        listViewCameras = view.findViewById(R.id.listViewCameras);

        // Dummy data for cameras
        String[] cameras = {"Front Door", "Living Room", "Bedroom", "Kitchen"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, cameras);
        listViewCameras.setAdapter(adapter);

        return view;
    }
}
