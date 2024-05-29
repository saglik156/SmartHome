package com.example.yourapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class RouterFragment extends Fragment {

    private TextView myRoutersTitle;
    private ImageView routerIcon;
    private TextView routerInfo;
    private Switch routerSwitch;
    private TextView wifiStatisticsTitle;
    private ImageView wifiSpeedGauge;
    private TextView speedInfo;
    private TextView usageStatisticsTitle;
    private ImageView usageStatisticsChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_router, container, false);

        // Initialize UI elements
        myRoutersTitle = view.findViewById(R.id.myRoutersTitle);
        routerIcon = view.findViewById(R.id.routerIcon);
        routerInfo = view.findViewById(R.id.routerInfo);
        routerSwitch = view.findViewById(R.id.routerSwitch);
        wifiStatisticsTitle = view.findViewById(R.id.wifiStatisticsTitle);
        wifiSpeedGauge = view.findViewById(R.id.wifiSpeedGauge);
        speedInfo = view.findViewById(R.id.speedInfo);
        usageStatisticsTitle = view.findViewById(R.id.usageStatisticsTitle);
        usageStatisticsChart = view.findViewById(R.id.usageStatisticsChart);

        // Set listeners and logic
        routerSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getActivity(), "Router is ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Router is OFF", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
