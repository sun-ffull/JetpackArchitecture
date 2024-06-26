package com.sunfull.workmanagerchaining_6_4

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManageA(context : Context, workerParmeters: WorkerParameters) : Worker(context, workerParmeters) {

    override fun doWork(): Result {
        for (i in 0..3){
            sleep(1000)
            Log.d("WorkManagerA", i.toString())
        }

        return Result.success()
    }
}