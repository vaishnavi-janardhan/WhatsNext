package com.c0deb1ade.whatsnext;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity {
    // Firebase variables
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    private CircleImageView mCircleImageView;
    private TextView studentNameTextView;
    private Button signOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mCircleImageView = findViewById(R.id.profile_image);
        studentNameTextView = findViewById(R.id.student_name);
        signOutButton = findViewById(R.id.sign_out_button);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        Uri photoUri = mFirebaseUser.getPhotoUrl();

        Glide.with(this).load(photoUri).into(mCircleImageView);

        studentNameTextView.setText(mFirebaseUser.getDisplayName());

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthUI.getInstance().signOut(DashboardActivity.this);
                finish();
            }
        });
    }
}
