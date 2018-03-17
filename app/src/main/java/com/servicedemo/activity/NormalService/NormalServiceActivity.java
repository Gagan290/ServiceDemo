package com.servicedemo.activity.NormalService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.servicedemo.R;
import com.servicedemo.utility.CommonMethod;

public class NormalServiceActivity extends AppCompatActivity {
    public static final String mBroadcastStringAction = "com.broadcast.string";
    public static final String mBroadcastIntegerAction = "com.broadcast.integer";
    public static final String mBroadcastArrayListAction = "com.broadcast.arraylist";

    Button btn_normalBroadcastService, btn_intentBroadcastService;
    private TextView mTextView;
    private IntentFilter mIntentFilter;

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            mTextView.setText(mTextView.getText() + "Broadcast From Service: \n");

            if (intent.getAction().equals(mBroadcastStringAction)) {
                mTextView.setText(mTextView.getText()
                        + intent.getStringExtra("Data") + "\n\n");

            } else if (intent.getAction().equals(mBroadcastIntegerAction)) {
                mTextView.setText(mTextView.getText().toString()
                        + intent.getIntExtra("Data", 0) + "\n\n");

            } else if (intent.getAction().equals(mBroadcastArrayListAction)) {
                mTextView.setText(mTextView.getText()
                        + intent.getStringArrayListExtra("Data").toString() + "\n\n");

                Intent stopIntent = new Intent(NormalServiceActivity.this,
                        NormalBroadcastService.class);
                stopService(stopIntent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_service);

        mTextView = (TextView) findViewById(R.id.textview1);
        btn_normalBroadcastService = (Button) findViewById(R.id.btn_normalBroadcastService);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(mBroadcastStringAction);
        mIntentFilter.addAction(mBroadcastIntegerAction);
        mIntentFilter.addAction(mBroadcastArrayListAction);

        boolean isMyServie = CommonMethod.isMyServiceRunning(this, NormalBroadcastService.class);

        Intent serviceIntent = new Intent(NormalServiceActivity.this,
                NormalBroadcastService.class);
        startService(serviceIntent);

//        Intent serviceIntent1 = new Intent(NormalServiceActivity.this,
//                NormalBroadcastService.class);
//        startService(serviceIntent1);
//
//        Intent serviceIntent2 = new Intent(NormalServiceActivity.this,
//                NormalBroadcastService.class);
//        startService(serviceIntent2);
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mReceiver);
        super.onPause();
    }


}
