package com.Bands70k;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

import static com.Bands70k.staticVariables.context;
import static java.lang.Thread.sleep;

public class bandListView extends ArrayAdapter<bandListItem> {

    protected LayoutInflater inflater;
    protected int layout;
    private List<bandListItem> bandInfoList = new ArrayList<bandListItem>();


    static class bandListHolder{
        ImageView rankImage;
        ImageView eventTypeImage;
        ImageView attendedImage;
        ImageView rankImageNoSchedule;

        TextView bandName;
        TextView location;
        TextView locationColor;
        TextView day;
        TextView startTime;
        TextView endTime;
        TextView dayLable;
        TextView bandNameNoSchedule;

        TextView bottomSpacer;

    }

    public void setBandInfoList(List<bandListItem> bandInfoList){
        this.bandInfoList = bandInfoList;
    }

    public bandListView(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public bandListItem getItem(int index) {
        return this.bandInfoList.get(index);
    }

    @Override
    public void add(bandListItem object) {
        bandInfoList.add(object);
        super.add(object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        bandListHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.bandlist70k, parent, false);
            viewHolder = new bandListHolder();
            viewHolder.rankImage = (ImageView) row.findViewById(R.id.rankingInCell);
            viewHolder.eventTypeImage = (ImageView) row.findViewById(R.id.eventTypeInCell);
            viewHolder.attendedImage = (ImageView) row.findViewById(R.id.attendedInCell);
            viewHolder.bandName = (TextView) row.findViewById(R.id.bandNameInCell);
            viewHolder.location = (TextView) row.findViewById(R.id.locationInCell);
            viewHolder.locationColor = (TextView) row.findViewById(R.id.locationColorInCell);
            viewHolder.day = (TextView) row.findViewById(R.id.dayInCell);
            viewHolder.startTime = (TextView) row.findViewById(R.id.startTimeInCell);
            viewHolder.endTime = (TextView) row.findViewById(R.id.endTimeInCell);
            viewHolder.dayLable = (TextView) row.findViewById(R.id.dayLabelInCell);

            viewHolder.bottomSpacer = (TextView) row.findViewById(R.id.bottomSpacer);
            viewHolder.rankImageNoSchedule = (ImageView) row.findViewById(R.id.rankingInCellnoSchedule);
            viewHolder.bandNameNoSchedule = (TextView) row.findViewById(R.id.bandNameInCellNoSchedule);

            row.setTag(viewHolder);
        } else {
            viewHolder = (bandListHolder)row.getTag();
        }

        bandListItem bandData = getItem(position);

        //Log.d("displayingList", "working on bandName " + bandData.getBandName() + " position " + String.valueOf(position));
        Log.d("displayingList", "working on bandName " + bandData.getBandName() + " color " + bandData.getLocationColor());

        if (bandData.getLocation() == null){

            viewHolder.eventTypeImage.setVisibility(View.INVISIBLE);
            viewHolder.attendedImage.setVisibility(View.INVISIBLE);
            viewHolder.location.setVisibility(View.INVISIBLE);
            viewHolder.location.setVisibility(View.INVISIBLE);
            viewHolder.locationColor.setVisibility(View.INVISIBLE);
            viewHolder.day.setVisibility(View.INVISIBLE);
            viewHolder.startTime.setVisibility(View.INVISIBLE);
            viewHolder.endTime.setVisibility(View.INVISIBLE);
            viewHolder.dayLable.setVisibility(View.INVISIBLE);

            viewHolder.rankImage.setVisibility(View.INVISIBLE);
            viewHolder.bandName.setVisibility(View.INVISIBLE);

            viewHolder.rankImageNoSchedule.setVisibility(View.VISIBLE);
            viewHolder.bandNameNoSchedule.setVisibility(View.VISIBLE);


            viewHolder.rankImageNoSchedule.setImageResource(bandData.getRankImg());
            viewHolder.bandNameNoSchedule.setText(bandData.getBandName());

            viewHolder.bottomSpacer.setVisibility(View.INVISIBLE);

            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
                viewHolder.bandNameNoSchedule.setTextSize(25);
            }

        } else {

            viewHolder.eventTypeImage.setVisibility(View.VISIBLE);
            viewHolder.attendedImage.setVisibility(View.VISIBLE);
            viewHolder.location.setVisibility(View.VISIBLE);
            viewHolder.location.setVisibility(View.VISIBLE);
            viewHolder.locationColor.setVisibility(View.VISIBLE);
            viewHolder.day.setVisibility(View.VISIBLE);
            viewHolder.startTime.setVisibility(View.VISIBLE);
            viewHolder.endTime.setVisibility(View.VISIBLE);
            viewHolder.dayLable.setVisibility(View.VISIBLE);
            viewHolder.bottomSpacer.setVisibility(View.VISIBLE);
            viewHolder.rankImage.setVisibility(View.VISIBLE);
            viewHolder.bandName.setVisibility(View.VISIBLE);

            viewHolder.rankImageNoSchedule.setVisibility(View.INVISIBLE);
            viewHolder.bandNameNoSchedule.setVisibility(View.INVISIBLE);

            if (bandData.getRankImg() == 0){
                viewHolder.rankImage.setVisibility(View.INVISIBLE);
            } else {

                Log.d("bandListView", "ranking image is " + String.valueOf(bandData.getRankImg()));
                if (bandData.getRankImg() != 50000000) {
                    viewHolder.rankImage.setImageResource(bandData.getRankImg());
                } else {
                    viewHolder.rankImage.setImageResource(0);
                }

                viewHolder.rankImage.setVisibility(View.VISIBLE);
            }

            if (bandData.getEventTypeImage() == 0){
                viewHolder.eventTypeImage.setVisibility(View.INVISIBLE);
            } else {
                viewHolder.eventTypeImage.setImageResource(bandData.getEventTypeImage());
                viewHolder.eventTypeImage.setVisibility(View.VISIBLE);
            }

            if (bandData.getAttendedImage() == 0){
                viewHolder.attendedImage.setVisibility(View.INVISIBLE);
            } else {
                viewHolder.attendedImage.setImageResource(bandData.getAttendedImage());
                viewHolder.attendedImage.setVisibility(View.VISIBLE);
            }

            viewHolder.location.setText(bandData.getLocation());

            String locationColorChoice = bandData.getLocationColor();

            if (locationColorChoice != null){
                viewHolder.locationColor.setBackgroundColor(Color.parseColor(locationColorChoice));

            } else {
                viewHolder.locationColor.setBackgroundColor(Color.parseColor(staticVariables.unknownVenueColor));
            }

            viewHolder.bandName.setText(bandData.getBandName());
            viewHolder.day.setText(bandData.getDay());
            viewHolder.startTime.setText(bandData.getStartTime());
            viewHolder.endTime.setText(bandData.getEndTime());
            if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
                viewHolder.bandName.setTextSize(23);
            }

        }


        if (getScreenWidth(context) <= 480){
            viewHolder.day.setWidth(35);
            viewHolder.dayLable.setWidth(35);

        }
        return row;

    }

    private static Integer getScreenWidth(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;

        Log.d("screenWidth", "Screen Width is " + String.valueOf(width));
        return width;
    }
}