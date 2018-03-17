package com.servicedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.servicedemo.R;
import com.servicedemo.activity.DownloadDataInNotificationProgressBar.DownloadDataInNotificationProgressbarActivity;
import com.servicedemo.activity.ForegroundService.ForegroundServiceActivity;
import com.servicedemo.activity.NormalService.NormalServiceActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_normalBroadcastService, btn_foregroundService, btn_downloadData, btn_intentBroadcastService;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview1);
        btn_normalBroadcastService = (Button) findViewById(R.id.btn_normalBroadcastService);
        btn_foregroundService = (Button) findViewById(R.id.btn_foregroundService);
        btn_downloadData = (Button) findViewById(R.id.btn_downloadData);


        btn_normalBroadcastService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NormalServiceActivity.class));
            }
        });

        btn_foregroundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ForegroundServiceActivity.class));
            }
        });

        btn_downloadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DownloadDataInNotificationProgressbarActivity.class));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}
