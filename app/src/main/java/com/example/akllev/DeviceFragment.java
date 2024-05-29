package com.example.akllev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeviceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeviceFragment extends Fragment {

    private boolean isSpeakerOn = false;
    private int volume = 70;
    private int batteryLevel = 90;

    public DeviceFragment() {
        // Required empty public constructor
    }

    public static DeviceFragment newInstance(String param1, String param2) {
        DeviceFragment fragment = new DeviceFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mParam1 = getArguments().getString("param1");
            String mParam2 = getArguments().getString("param2");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_device, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView speakerImage = view.findViewById(R.id.speakerImage);
        Switch speakerSwitch = view.findViewById(R.id.speakerSwitch);
        TextView batteryText = view.findViewById(R.id.batteryText);
        SeekBar volumeSeekBar = view.findViewById(R.id.volumeSeekBar);
        TextView volumeText = view.findViewById(R.id.volumeText);

        batteryText.setText("Battery: " + batteryLevel + "%");
        volumeSeekBar.setProgress(volume);
        volumeText.setText("Volume: " + volume + "%");

        speakerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isSpeakerOn = isChecked;
            }
        });

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volume = progress;
                volumeText.setText("Volume: " + volume + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
