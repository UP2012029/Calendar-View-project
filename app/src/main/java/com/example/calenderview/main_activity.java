package com.example.calenderview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class main_activity extends AppCompatActivity {

    calendarView CalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView = (calendarView) findViewById(R.id.activity_custom_calndar);
    }
}