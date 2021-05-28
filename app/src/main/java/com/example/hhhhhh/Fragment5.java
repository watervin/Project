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




public class Fragment5 extends Fragment {

    static final int REQUEST_CODE = 1;
    private ImageView imageView;
    private String uid = null;
    private TextView textView;
    private EditText Email, Password;
    public String mail;

    private FirebaseAuth Auth = FirebaseAuth.getInstance();


    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        user.getEmail(); // 사용자 이메일
        user.getUid();    // 사용자 UID
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_5, container, false);
        textView =v.findViewById(R.id.name);

        FirebaseUser user = Auth.getCurrentUser();
        textView.setText(user.getEmail());

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