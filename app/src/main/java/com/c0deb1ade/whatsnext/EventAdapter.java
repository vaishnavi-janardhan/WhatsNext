package com.c0deb1ade.whatsnext;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lifeLessCoder on 01-04-2018.
 */

public class EventAdapter extends ArrayAdapter<Event>{
    public EventAdapter(@NonNull Context context, int resource, @NonNull List<Event> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.event_list_item, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.event_name);
        TextView descriptionTextView = convertView.findViewById(R.id.event_description);
        ImageView eventImageView = convertView.findViewById(R.id.event_image);

        Event currentEvent = getItem(position);

        titleTextView.setText(currentEvent.getTitle());
        descriptionTextView.setText(currentEvent.getDescription());
        Glide.with(getContext()).load(currentEvent.getPhoto()).into(eventImageView);


        return convertView;
    }
}
