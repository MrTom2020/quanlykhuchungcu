package com.example.reheavenadmin.ui.dashboard;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.reheavenadmin.Common.Common;
import com.example.reheavenadmin.R;
import com.example.reheavenadmin.model.NewsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddnewsFragment extends Fragment {

    String newsuspost, newsavt, newsimg, newsday, newstime;
    EditText etthemtin1;
    Button btndangtin;
    ImageView imgthemtin1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addnews, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference newsRef = firebaseDatabase.getReference("news");

        etthemtin1 = view.findViewById(R.id.etthemtin1);
        newsuspost = Common.currentAdmin.getAdminname();
        newsavt = Common.currentAdmin.getAvt();
        newsday = Common.getcurrentDay().toString();
        newstime = Common.getcurrentTime().toString();
        newsimg = "https://live.staticflickr.com/65535/49889747167_a9c028a8ab_k.jpg";


        btndangtin = view.findViewById(R.id.btndangtin);

        btndangtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(getActivity());
                mDialog.setMessage("Đang xử lý...");
                mDialog.show();

                newsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mDialog.dismiss();
                        NewsModel newsModel = new NewsModel(
                                newsuspost,
                                newsavt,
                                newsimg,
                                newsday,
                                etthemtin1.getText().toString(),
                                newstime
                        );
                        newsRef.child(newsday).child(newstime).setValue(newsModel);
                        Toast.makeText(getActivity(), "Đăng tin thành công", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}