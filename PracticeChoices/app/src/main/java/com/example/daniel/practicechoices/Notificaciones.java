package com.example.daniel.practicechoices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class Notificaciones extends AppCompatActivity {
    public static final int NOTIFICACION_ID=1;
    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        regresar = (Button)findViewById(R.id.btnRegresar);
        Notificacion();
    }
    public void Notificacion(){
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);

        //Construccion de la notificacion;
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_stat_notification);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setTicker("Facebook");
        builder.setContentTitle("Etiqueta de...");
        builder.setSubText("Pulse aqui para ingresar");

        //Enviar la notificacion
        NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICACION_ID,builder.build());

    }
    public void Regresar(View view){
        Intent principal = new Intent(this,Principal.class);
        startActivity(principal);
    }
}
