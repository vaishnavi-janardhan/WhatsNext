package com.c0deb1ade.whatsnext;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;

public class RegisterActivity extends AppCompatActivity {
    private TextView eventTitleTextView;
    private TextView organizingClubTextView;
    private TextView eventDescriptionTextView;
    private TextView dateTextView;
    private TextView venueTextView;
    private TextView timeTextView;
    private ImageView eventImageView;
    private Button registerButton;

    private Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eventTitleTextView = findViewById(R.id.event_name);
        organizingClubTextView = findViewById(R.id.organizing_club);
        eventDescriptionTextView = findViewById(R.id.event_description);
        dateTextView = findViewById(R.id.date);
        venueTextView = findViewById(R.id.venue);
        timeTextView = findViewById(R.id.time);
        eventImageView = findViewById(R.id.event_image);
        registerButton = findViewById(R.id.register_button);

        toast = Toast.makeText(RegisterActivity.this,
                "Online registration not available, please visit the infodesk at fc",
                Toast.LENGTH_LONG);

        Intent registerIntent = getIntent();
        final Event currentEvent = (Event) registerIntent.getSerializableExtra("Event");

        eventTitleTextView.setText(currentEvent.getTitle());
        organizingClubTextView.setText(currentEvent.getOrganizer());
        eventDescriptionTextView.setText(currentEvent.getDescription());
        dateTextView.setText(currentEvent.getDate());
        venueTextView.setText(currentEvent.getVenue());
        timeTextView.setText(currentEvent.getTime());
        Log.e(RegisterActivity.class.getSimpleName(), currentEvent.getPhoto());
        Glide.with(this).load(currentEvent.getPhoto()).into(eventImageView);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentEvent.getGoogleFormUrl().isEmpty()) {
                   toast.show();
                } else {
                    Intent googleFormIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentEvent.getGoogleFormUrl()));
                    if (googleFormIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(googleFormIntent);
                    }
                }
            }
        });
    }

}
