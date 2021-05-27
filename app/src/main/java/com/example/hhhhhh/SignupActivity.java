package com.example.hhhhhh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity  {

    private FirebaseAuth Auth = FirebaseAuth.getInstance();
    private FirebaseFirestore store = FirebaseFirestore.getInstance();
    private EditText Email, Nickname, Password, ID, Name, Join, School;
    private Button Joinbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Email = findViewById(R.id.login_email);
        Nickname = findViewById(R.id.login_nickname);
        Password = findViewById(R.id.login_password);
        ID = findViewById(R.id.login_id);
        Name = findViewById(R.id.login_name);
        School = findViewById(R.id.login_school);
        Joinbtn = findViewById(R.id.login_join);
        Joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "회원가입완료", Toast.LENGTH_SHORT).show();
            }
        });
    }

   /* public void onClick(View v) {
        Auth.createUserWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = Auth.getCurrentUser();
                            if (user != null) {
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
    }*/
}