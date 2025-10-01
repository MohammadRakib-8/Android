package com.example.notification

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class NotificationHelperClass {
    fun createNotificationChannel(context:Context){ //context give access to the system services and aslo for registred any services :)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ //Version check using condition that is the version oreo 8.0 or higher
            if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    context as Activity,  // You need an Activity here
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    101
                )
                return
            }
            val channelId="fresh_test_channel_001"
            val channelName="Channel_Notification_Test"
            val channelDescription="Channel for Notification Test"
            val channelImportance= NotificationManager.IMPORTANCE_HIGH
val cahnnel = NotificationChannel(channelId,channelName,channelImportance).apply {
        description=channelDescription }


    val notificationManager: NotificationManager =context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(cahnnel)    //Registered the channel with the system
    }
    }

    fun showNotification(context: Context){
        val notificationId="fresh_test_channel_001"
        val builder= NotificationCompat.Builder(context,notificationId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Notification Test")
            .setContentText("Notification Test code is working")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(context)){
            notify(1,builder.build())
        }
    }
}

