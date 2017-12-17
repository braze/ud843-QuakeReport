package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by braze on 12/10/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(@NonNull Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        String magnitudeObject = formatMagnitude(currentEarthquake.getmMagnitude());
        magnitudeView.setText(magnitudeObject);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        String s = currentEarthquake.getmLocation();
        int index = s.lastIndexOf("of");
        String distance = s.substring(0, index + 2);
        String location = s.substring(index + 3);

        TextView distanceView = (TextView) listItemView.findViewById(R.id.location_offset);
        distanceView.setText(distance);

        TextView locationView = (TextView) listItemView.findViewById(R.id.primary_location);
        locationView.setText(location);

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        Date date = new Date(currentEarthquake.getmDate());
        String dateObject = formatDate(date);
        dateView.setText(dateObject);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        Date time = new Date(currentEarthquake.getmDate());
        String timeObject = formatTime(time);
        timeView.setText(timeObject);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
//        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude (i.e "7.5) from a decimal magnitde value
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magFormat = new DecimalFormat("0.0");
        return magFormat.format(magnitude);
    }

    /**
     * Return the circle color
     */
    private int getMagnitudeColor(double mag){
        int magnitudeColorResourceId;
        int magnitude = (int) Math.floor(mag);
        switch (magnitude){
            case 1: magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2: magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3: magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4: magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5: magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6: magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7: magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8: magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9: magnitudeColorResourceId = R.color.magnitude9;
                break;
            default: magnitudeColorResourceId = R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
