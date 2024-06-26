package com.sunfull.workmanagerchaining_6_4

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManagerB (context : Context, workerParmeters: WorkerParameters) : Worker(context, workerParmeters) {

    override fun doWork(): Result {
        for (i in 0..3){
            Thread.sleep(1000)
            Log.d("WorkManagerB", i.toString())
        }

        return Result.success()
    }
}