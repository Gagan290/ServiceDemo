package com.servicedemo.service;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;

/**
 * Created by akash on 30/1/18.
 */

@SuppressLint("NewApi")
public class JobSchedulerService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
