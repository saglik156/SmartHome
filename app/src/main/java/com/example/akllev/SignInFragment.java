package com.example.akllev;



import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInFragment extends Fragment {

    private EditText editTextName, editTextEmail, editTextPassword;
    private Button buttonSignUp;
    private DatabaseHelper myDb;
    private TextView textViewAlreadyRegistered;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        myDb = new DatabaseHelper(getContext());

        editTextName = view.findViewById(R.id.editTextName);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonSignUp = view.findViewById(R.id.buttonSignUp);
        textViewAlreadyRegistered = view.findViewById(R.id.textView3);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                } else {
                    Cursor res = myDb.getData(email);
                    if (res.getCount() == 0) {
                        boolean isInserted = myDb.insertData(name, email, password);
                        if (isInserted) {
                            Toast.makeText(getContext(), "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                            // Login fragmentine geçiş
                            ((MainActivity) getActivity()).loadFragment(new LoginFragment());
                        } else {
                            Toast.makeText(getContext(), "Kayıt başarısız", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Bu e-posta ile zaten kayıtlı", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        textViewAlreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Login fragmentine geçiş
                ((MainActivity) getActivity()).loadFragment(new LoginFragment());
            }
        });

        return view;
    }
}
