package com.FireBase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.example.quizappvi.MainActivity;
import com.example.quizappvi.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFcmService extends FirebaseMessagingService {
private  String title;

    private String message;
private String imageUrl;

private  String type;
private  int notificationId=0;

private Map<String,String> data;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

  onPostExecute(remoteMessage);

    }

    private void onPostExecute(RemoteMessage remoteMessage) {
  data=remoteMessage.getData();
  title=data.get("title");

  if (remoteMessage.getData().containsKey("content")&&
          remoteMessage.getData().get("content")!=null){


      message=data.get("content");

  }
        if (remoteMessage.getData().containsKey("id")&&
                remoteMessage.getData().get("id")!=null){




        }
Intent intent=new Intent(this, MainActivity.class);


    }
private void opeNotification(Intent intent){


        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        String ChannelId="Default";
        PendingIntent pendingIntent=PendingIntent.getActivity(this,notificationId,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    NotificationCompat.Builder notBuilder=new NotificationCompat.Builder(this,
            "Default").
            setSmallIcon(R.drawable.brainmy).
            setContentTitle(title).
            setContentText(message).
            setSound(defaultSoundUri).setContentIntent(pendingIntent);
    Notification notification=notBuilder.build();
    notification.tickerText=title;
    NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

    notificationManager.notify(notificationId,notification);


}

}
