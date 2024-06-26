package com.sunfull.workmanagerwithcoroutine_6_5

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class WorkManager2 (context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {

        test1()
        test2()

        return Result.success()
    }

    suspend fun test1(){
        for (i in 1..3){
            delay(1000)
            Log.d("WorkManager2 test1", i.toString())
        }
    }

    suspend fun test2(){
        for (i in 1..3){
            delay(1000)
            Log.d("WorkManager2 test2", i.toString())
        }
    }
}