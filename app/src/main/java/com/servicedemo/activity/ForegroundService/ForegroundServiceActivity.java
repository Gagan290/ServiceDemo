package com.servicedemo.activity.ForegroundService;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.servicedemo.R;
import com.servicedemo.utility.Constants;

//http://www.tutorialsface.com/2015/09/simple-android-foreground-service-example/

public class ForegroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);
    }

    public void buttonClicked(View v) {
        Button button = (Button) v;
        Intent service = new Intent(ForegroundServiceActivity.this, ForegroundService.class);

        if (!ForegroundService.IS_SERVICE_RUNNING) {
            service.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
            ForegroundService.IS_SERVICE_RUNNING = true;
            button.setText("Stop Service");
        } else {
            service.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
            ForegroundService.IS_SERVICE_RUNNING = false;
            button.setText("Start Service");

        }
        startService(service);
    }
}