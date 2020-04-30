package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthQuakeArrayAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthQuakeArrayAdapter(@NonNull Context context, @NonNull List<Earthquake> earthQuakes) {
        super(context, 0, earthQuakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Earthquake earthQuake = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.earthquake_item, parent, false);
        }

        TextView magnitudeTextView = convertView.findViewById(R.id.magnitude_text);
        TextView locationOffsetTextView = convertView.findViewById(R.id.location_offset_text);
        TextView primaryLocationTextView = convertView.findViewById(R.id.primary_location_text);
        TextView dateTextView = convertView.findViewById(R.id.date_text);
        TextView timeTextView = convertView.findViewById(R.id.time_text);

        DecimalFormat magnitudeFormatter = new DecimalFormat("0.0");
        String formattedMagnitude = magnitudeFormatter.format(earthQuake.getMagnitude());
        magnitudeTextView.setText(String.format("%s", formattedMagnitude));

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(earthQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String locationOffset = "";
        String primaryLocation = "";
        String[] locations = earthQuake.getLocation().split("of");

        if (earthQuake.getLocation().contains(LOCATION_SEPARATOR)) {
            String[] locationParts = earthQuake.getLocation().split(LOCATION_SEPARATOR);
            locationOffset = locations[0] + LOCATION_SEPARATOR;
            primaryLocation = locations[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = earthQuake.getLocation();
        }

        locationOffsetTextView.setText(String.format("%s", locationOffset));
        primaryLocationTextView.setText(String.format("%s", primaryLocation));

        Date date = new Date(earthQuake.getmTimeInMilliseconds());
        String formattedDate = new SimpleDateFormat("dd LLL, yyyy").format(date);
        String formattedTime = new SimpleDateFormat("h:mm a").format(date);

        dateTextView.setText(String.format("%s", formattedDate));
        timeTextView.setText(String.format("%s", formattedTime));

        return convertView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeFloor = (int) Math.floor(magnitude);
        int magnitudeColorResourceId;

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
