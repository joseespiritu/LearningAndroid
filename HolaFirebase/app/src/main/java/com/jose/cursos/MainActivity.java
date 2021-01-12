package com.jose.cursos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String PATH_START = "start";
    private static final String PATH_MESSAGE = "message";
    @BindView(R.id.etMessage)
    EditText etMessage;
    @BindView(R.id.btnSend)
    Button btnSend;

    private FirebaseDatabase dataBase;
    private DatabaseReference mRootreference;
    private DatabaseReference mChildreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final TextView textViewMessage = findViewById(R.id.textviewMessage);

        dataBase = FirebaseDatabase.getInstance();
        mRootreference = dataBase.getReference(PATH_START);
        mChildreference = mRootreference.child(PATH_MESSAGE);

        mChildreference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                textViewMessage.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Error al consultar en firebase", Toast.LENGTH_LONG).show();
            }
        });
    }

    @OnClick(R.id.btnSend)
    public void onViewClicked(){
        dataBase = FirebaseDatabase.getInstance();
        mRootreference = dataBase.getReference(PATH_START);
        mChildreference = mRootreference.child(PATH_MESSAGE);

        mChildreference.setValue(etMessage.getText().toString().trim());
        etMessage.setText("");
    }
}