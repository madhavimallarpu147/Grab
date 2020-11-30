package com.mrhgroups.grab.workmanager


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.mrhgroups.grab.R

class MyWorker(getApplication: Context, workerParameters: WorkerParameters) : Worker(
    getApplication,
    workerParameters
) {

    companion object{
        val TASK_DESC = "task_desc"
    }
    override fun doWork(): Result {
        sendNotification(inputData.getString(TASK_DESC))
       return Result.success()
    }

    private fun sendNotification(string: String?) {
         val manager:NotificationManager=applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

         if(android.os.Build.VERSION.SDK_INT> android.os.Build.VERSION_CODES.O){

             val channel:NotificationChannel=
                 NotificationChannel(
                     "myNotification",
                     "MyNotification",
                     NotificationManager.IMPORTANCE_DEFAULT
                 )
             manager.createNotificationChannel(channel)
         }

        val notification : NotificationCompat.Builder= NotificationCompat.Builder(
            applicationContext,
            "MyNotification"
        ).setContentTitle(string).setContentText("hey this madhavi testing work manager").setSmallIcon(
            R.mipmap.ic_launcher
        )

         manager.notify(1, notification.build())



    }
}