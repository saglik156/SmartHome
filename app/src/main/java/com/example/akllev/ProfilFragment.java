package com.example.yourapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    private ImageView profilePicture;
    private TextView userName;
    private TextView userEmail;
    private Button settingsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize UI elements
        profilePicture = view.findViewById(R.id.profilePicture);
        userName = view.findViewById(R.id.userName);
        userEmail = view.findViewById(R.id.userEmail);
        settingsButton = view.findViewById(R.id.settingsButton);

        // Set data and logic
        // For example, you can set the user data dynamically
        userName.setText("John Doe");
        userEmail.setText("john.doe@example.com");

        // Add logic for settings button
        settingsButton.setOnClickListener(v -> {
            // Handle settings button click
        });

        return view;
    }
}
