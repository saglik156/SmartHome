package com.example.smarthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HomeOverviewFragment extends Fragment {

    private TextView textViewWelcome;
    private TextView textViewWeather;
    private TextView textViewHumidity;
    private Button buttonAllLightsOn;
    private Button buttonPlayMusic;
    private RecyclerView recyclerViewDevices;
    private DeviceAdapter deviceAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_overview, container, false);

        textViewWelcome = view.findViewById(R.id.textViewWelcome);
        textViewWeather = view.findViewById(R.id.textViewWeather);
        textViewHumidity = view.findViewById(R.id.textViewHumidity);
        buttonAllLightsOn = view.findViewById(R.id.buttonAllLightsOn);
        buttonPlayMusic = view.findViewById(R.id.buttonPlayMusic);
        recyclerViewDevices = view.findViewById(R.id.recyclerViewDevices);

        // Setting welcome message
        textViewWelcome.setText("Welcome home, Yiğit");

        // Setting weather and humidity
        textViewWeather.setText("23°C");
        textViewHumidity.setText("67%");

        // Setting up RecyclerView
        recyclerViewDevices.setLayoutManager(new LinearLayoutManager(getActivity()));
        deviceAdapter = new DeviceAdapter(getDeviceList());
        recyclerViewDevices.setAdapter(deviceAdapter);

        return view;
    }

    private List<Device> getDeviceList() {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Speaker", "Living Room", R.drawable.ic_speaker, false));
        devices.add(new Device("Security Systems", "Everywhere", R.drawable.ic_security, true));
        devices.add(new Device("Air Conditioner", "Living Room", R.drawable.ic_air_conditioner, false));
        devices.add(new Device("Television", "Living Room", R.drawable.ic_television, false));
        devices.add(new Device("My Routers", "Living Room", R.drawable.ic_router, false));
        devices.add(new Device("ACS", "Everywhere", R.drawable.ic_acs, false));
        return devices;
    }
}
