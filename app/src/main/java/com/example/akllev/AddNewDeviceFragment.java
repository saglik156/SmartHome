package com.example.smarthome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddNewDeviceFragment extends Fragment {

    private EditText editTextDeviceName;
    private Button buttonLivingRoom, buttonKitchen, buttonBedroom, buttonContinue;
    private String selectedLocation = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_device, container, false);

        editTextDeviceName = view.findViewById(R.id.editTextDeviceName);
        buttonLivingRoom = view.findViewById(R.id.buttonLivingRoom);
        buttonKitchen = view.findViewById(R.id.buttonKitchen);
        buttonBedroom = view.findViewById(R.id.buttonBedroom);
        buttonContinue = view.findViewById(R.id.buttonContinue);

        buttonLivingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLocation = "Living Room";
                updateButtonBackgrounds();
                buttonLivingRoom.setBackgroundResource(R.drawable.button_selected);
            }
        });

        buttonKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLocation = "Kitchen";
                updateButtonBackgrounds();
                buttonKitchen.setBackgroundResource(R.drawable.button_selected);
            }
        });

        buttonBedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLocation = "Bedroom";
                updateButtonBackgrounds();
                buttonBedroom.setBackgroundResource(R.drawable.button_selected);
            }
        });

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deviceName = editTextDeviceName.getText().toString();
                if (deviceName.isEmpty() || selectedLocation.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter device name and select location", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle the device addition logic here
                    Toast.makeText(getActivity(), "Device " + deviceName + " added to " + selectedLocation, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void updateButtonBackgrounds() {
        buttonLivingRoom.setBackgroundResource(R.drawable.button_unselected);
        buttonKitchen.setBackgroundResource(R.drawable.button_unselected);
        buttonBedroom.setBackgroundResource(R.drawable.button_unselected);
    }
}
