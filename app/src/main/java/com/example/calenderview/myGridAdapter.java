package com.example.calenderview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class myGridAdapter extends ArrayAdapter {

    List<Date> dates;
    Calendar currentDate;
    List<events> Events;
    LayoutInflater inflater;

    public myGridAdapter(@NonNull Context context, List<Date> dates, Calendar currentDate, List<events> Events) {
        super(context, R.layout.single_cell_layout);

        this.dates = dates;
        this.currentDate = currentDate;
        this.Events = Events;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dates.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Date month = dates.get(position);
        Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.setTime(month);
        int DayNo = dateCalendar.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCalendar.get(Calendar.MONTH)+1;
        int displayYear = dateCalendar.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH)+1;
        int currentYear = currentDate.get(Calendar.YEAR);


        View view = convertView;
        if (view ==null){
            view = inflater.inflate(R.layout.single_cell_layout, parent, false);

        }

        //highlights the month in the interface
        if (displayMonth == currentMonth && displayYear == currentYear){
            view.setBackgroundColor(getContext().getResources().getColor(R.color.blue));
        } else {
            view.setBackgroundColor(Color.parseColor("#cccccc"));
        }

        TextView whichDay = view.findViewById(R.id.calendar_day);
        TextView eventNumber = view.findViewById(R.id.eventsid);
        whichDay.setText(String.valueOf(DayNo));
        Calendar eventCalendar = Calendar.getInstance();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < Events.size(); i++){
            eventCalendar.setTime(ConvertStringToDate(Events.get(i).getDate()));
            if (DayNo == eventCalendar.get(Calendar.DAY_OF_MONTH) && displayMonth == eventCalendar.get(Calendar.MONTH)+1
             && displayYear == eventCalendar.get(Calendar.YEAR)){
                arrayList.add(Events.get(i).getEvent());
                eventNumber.setText(arrayList.size()+" Events");
            }
        }



        return view;
    }

    private Date ConvertStringToDate(String eventDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(eventDate);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return dates.indexOf(item);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return dates.get(position);
    }
}
