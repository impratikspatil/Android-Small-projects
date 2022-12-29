package com.myapp.notification

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "questionsnotif"
    val CHANNEL_NAME = "Questions"
    val CHANNEL_DESCRIPTION = "Questions NOTIFICATION"

    lateinit var send: Button
    lateinit var askuser: TextView
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var ll: LinearLayout
    lateinit var testbtn: Button
    lateinit var imgBitmap: Bitmap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send = findViewById(R.id.sendbtn)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        askuser = findViewById(R.id.askque)
        ll = findViewById(R.id.ll)


        send.setOnClickListener {
            ll.visibility= View.VISIBLE
            askuser.visibility= View.VISIBLE
        }
         imgBitmap= BitmapFactory.decodeResource(resources,R.drawable.quiz)

        val pendingIntent1= PendingIntent.getActivity(this, 5, Intent(this,Questoin1::class.java), PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val pendingIntent2= PendingIntent.getActivity(this, 5, Intent(this,Question2::class.java), PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val pendingIntent3= PendingIntent.getActivity(this, 5, Intent(this,Question3::class.java), PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val pendingIntent4= PendingIntent.getActivity(this, 5, Intent(this,Questoin4::class.java), PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val pendingIntent5= PendingIntent.getActivity(this, 5, Intent(this,Question5::class.java), PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        notificationChannel();





        btn1.setOnClickListener {
            sendnotificaton(pendingIntent1,"1")
            Toast.makeText(this,"Notification has sent successfully",Toast.LENGTH_SHORT).show()

        }


        btn2.setOnClickListener {
            sendnotificaton(pendingIntent2,"2")
            Toast.makeText(this,"Notification has sent successfully",Toast.LENGTH_SHORT).show()


        }

        btn3.setOnClickListener {
            sendnotificaton(pendingIntent3,"3")
            Toast.makeText(this,"Notification has sent successfully",Toast.LENGTH_SHORT).show()


        }

        btn4.setOnClickListener {
            sendnotificaton(pendingIntent4,"4")
            Toast.makeText(this,"Notification has sent successfully",Toast.LENGTH_SHORT).show()

        }

        btn5.setOnClickListener {
            sendnotificaton(pendingIntent5,"5")
            Toast.makeText(this,"Notification has sent successfully",Toast.LENGTH_SHORT).show()

        }



    }

    private fun notificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description = CHANNEL_DESCRIPTION
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendnotificaton(pendingIntent:PendingIntent,num:String) {
        val nBuilder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("QuizApp")
            .setContentText("Solve the question "+num)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setLargeIcon(imgBitmap)
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(imgBitmap)
                .bigLargeIcon(null))
            .addAction(0, "Solve", pendingIntent)
            .setAutoCancel(true)
            .build()


        val nManager = NotificationManagerCompat.from(this)
        nManager.notify(5, nBuilder)


    }



}