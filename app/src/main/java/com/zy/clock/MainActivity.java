package com.zy.clock;

import android.app.Activity;
import android.os.Bundle;

import com.zy.clock.widget.ClockView;

public class MainActivity extends Activity {
    ClockView mClockView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClockView = (ClockView) findViewById(R.id.clock);
    }
}
