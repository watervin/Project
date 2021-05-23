package com.example.hhhhhh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth Auth = FirebaseAuth.getInstance();
    private FirebaseFirestore store = FirebaseFirestore.getInstance();
    private EditText Email, Nickname, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Email = findViewById(R.id.sign_email);
        Nickname = findViewById(R.id.sign_nick);
        Password = findViewById(R.id.sign_password);

        findViewById(R.id.sign_success).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Auth.createUserWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = Auth.getCurrentUser();
                            if (user != null){
                                Map<String, Object> userMap = new HashMap<>();
                                userMap.put(FirebaseID.documentID, user.getUid());
                                userMap.put(FirebaseID.email, Email.getText().toString());
                                userMap.put(FirebaseID.nickname, Nickname.getText().toString());
                                userMap.put(FirebaseID.password, Password.getText().toString());
                                store.collection(FirebaseID.user).document(user.getUid()).set(userMap, SetOptions.merge());
                                finish();
                            }


                        } else {
                            Toast.makeText(SignupActivity.this, "Sign up failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}