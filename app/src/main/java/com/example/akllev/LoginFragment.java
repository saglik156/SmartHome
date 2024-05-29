package com.example.akllev;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LoginFragment extends Fragment {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private CheckBox checkBoxRobot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        checkBoxRobot = view.findViewById(R.id.checkbox_robot);

        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkBoxRobot.isChecked()) {
                    Toast.makeText(getContext(), "Lütfen 'Ben robot değilim' kutusunu işaretleyin", Toast.LENGTH_SHORT).show();
                } else {
                    // Login işlemleri
                    String email = editTextEmail.getText().toString();
                    String password = editTextPassword.getText().toString();

                    if (email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(getContext(), "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                    } else {
                        // Giriş yapma işlemleri
                        boolean loginSuccessful = true; // Burada gerçek login kontrolünü yapın

                        if (loginSuccessful) {
                            // Giriş başarılı olduğunda HomeFragment'e yönlendirme
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragment_container, new HomeFragment());
                            transaction.addToBackStack(null);
                            transaction.commit();
                        } else {
                            Toast.makeText(getContext(), "Giriş başarısız", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        Button buttonCreateAccount = view.findViewById(R.id.buttonCreateAccount);
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hesap oluşturma ekranına yönlendirme
                ((MainActivity) getActivity()).loadFragment(new SignInFragment());
            }
        });

        return view;
    }
}
