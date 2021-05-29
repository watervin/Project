package com.example.hhhhhh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

/*
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.rpc.context.AttributeContext;
*/

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.example.hhhhhh.FirebaseID.email;


public class Fragment5 extends Fragment {

    static final int REQUEST_CODE = 1;
    private ImageView imageView;
    private String uid = null;
    private TextView textView,textView2;
    private EditText Email, Password;
    public String mail;
    private DatabaseReference mDatabase;

    private FirebaseAuth Auth = FirebaseAuth.getInstance();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();


    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    FirebaseDatabase database;
    DatabaseReference myRef;

    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        user.getEmail(); // 사용자 이메일
        user.getUid();    // 사용자 UID
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //realtime base



        View v = inflater.inflate(R.layout.fragment_5, container, false);
        textView =v.findViewById(R.id.name);   //이메일 읽기
        FirebaseUser user = Auth.getCurrentUser();
        textView.setText(user.getEmail());

        //별명 가져오기가 안됨.....
        textView2 =v.findViewById(R.id.collage);
        String uid = user != null ? user.getUid() : null; // 로그인한 유저의 고유 uid 가져오기
        mDatabase = FirebaseDatabase.getInstance().getReference("users"); // 파이어베이스 realtime database 에서 정보 가져오기
        DatabaseReference Nickname = mDatabase.child("Nickname");    // 닉네임
        Nickname.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.getValue(String.class);
                textView2.setText(name);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });


/*
        myRef = FirebaseDatabase.getInstance().getReference("UserInfo");
        DatabaseReference name = myRef.child("Name").child(School);
        name.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.getValue(String.class);
                textView2.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //데베 읽기
*/

        Button edit = v.findViewById(R.id.edit);
        edit.setOnClickListener(v1 -> {
            Intent intent = new Intent(getActivity(), myedit.class);
            startActivity(intent);

        });
        Button btn_reputa = v.findViewById(R.id.btn_reputa);
        btn_reputa.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), reputa.class);
                startActivity(intent1);
            }


        });


        Button btn_last = v.findViewById(R.id.btn_last);
        btn_last.setOnClickListener(v12 -> {
            Intent intent2 = new Intent(getActivity(), lasttrans.class);
            startActivity(intent2);
        });

        Button btn_meet = v.findViewById(R.id.btn_meet);
        btn_meet.setOnClickListener(v13 -> {
            Intent intent3 = new Intent(getActivity(), meeting.class);
            startActivity(intent3);
        });


        Button btn_setting = v.findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(v14 -> {
            Intent intent4 = new Intent(getActivity(), setting.class);
            startActivity(intent4);
        });




        return v;
    }


/*
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_5);
        Button edit = getView().findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), myedit.class);
                startActivity(intent);

            }


        });
        Button btn_reputa = getView().findViewById(R.id.btn_reputa);
        btn_reputa.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity().getApplicationContext(), reputa.class);
                startActivity(intent1);
            }


        });


        Button btn_last = getView().findViewById(R.id.btn_last);
        btn_last.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent2 = new Intent(getActivity().getApplicationContext(), lasttrans.class);
                startActivity(intent2);
            }


        });

        Button btn_meet = getView().findViewById(R.id.btn_meet);
        btn_meet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent3 = new Intent(getActivity().getApplicationContext(), meeting.class);
                startActivity(intent3);
            }


        });


        Button btn_setting = getView().findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent4 = new Intent(getActivity().getApplicationContext(), setting.class);
                startActivity(intent4);
            }


        });

    }
*/










}