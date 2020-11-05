package com.example.reheaven;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reheaven.Common.Common;
import com.example.reheaven.model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText account;
    EditText password;
    private DatabaseReference userRef;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        account = findViewById(R.id.etID);
        password = findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        userRef = FirebaseDatabase.getInstance().getReference(Common.USER_REFERENCES);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInput();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot blockSnapshot : dataSnapshot.getChildren()) {
                            // for (DataSnapshot apartmentSnapshot:blockSnapshot.getChildren()){
                            if (blockSnapshot.child(account.getText().toString()).exists()) {
                                //lay thong tin nguoi dung
                                UserModel user = blockSnapshot.child(account.getText().toString()).getValue(UserModel.class);
                                if (user.getPassword().equals(password.getText().toString())) {
                                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    UserModel userModel = dataSnapshot.getValue(UserModel.class);
                                    gotohomeactivity(userModel);


                                } else {
                                    Toast.makeText(Login.this, "Sai mat khau", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(Login.this, "Tai khoan khong ton tai", Toast.LENGTH_SHORT).show();
                            }
                            // }
                        }
                        //kiem tra tai khoan trong database
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(Login.this, "DatabaseError", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void checkInput() {
        if (account.equals("")) {
            Toast.makeText(this, "Vui lòng nhập tài khoản", Toast.LENGTH_SHORT).show();
        }
        if (password.equals("")) {
            Toast.makeText(this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
        }
    }


    private void gotohomeactivity(UserModel userModel) {
        Common.currentUser = userModel;
        startActivity(new Intent(Login.this, MainActivity.class));
    }
}