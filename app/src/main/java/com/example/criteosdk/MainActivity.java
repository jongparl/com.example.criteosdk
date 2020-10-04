package com.example.criteosdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.criteo.events.EventService;
import com.criteo.events.HomeViewEvent;


public class MainActivity extends AppCompatActivity {
    Button m_ViewHome = null;
    Button m_ViewProduct = null;
    Button m_ViewList = null;
    Button m_Purchase = null;
    Button m_ViewCart = null;
    Button m_Search = null;
    EventService criteoEventService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criteo SDK
        EventService criteoEventService = new EventService(getApplicationContext());

        // Country must follow the ISO 3166-1 alpha-2 code and should be in uppercase
        // Language must follow the ISO ISO 639-1 and should be in lowercase
        criteoEventService.setCountry("FR");
        criteoEventService.setLanguage("fr");

        // Overrides the default account name with the provided value
        criteoEventService.setAccountName("com.example.test");

        // Assign Button resources
        onButtonInit();


        // Collect Google Play Advertising ID; REQUIRED for attribution of Android apps distributed via Google Play
        new Thread(new Runnable() {
            @Override public void run() {
                // See sample code at http://developer.android.com/google/play-services/id.html

            }
        }).start();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();


    }

    public void onButtonInit() {

        //Event for Criteo ViewHome event
        m_ViewHome =(Button)findViewById(R.id.button1);
        m_ViewHome.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("Criteo ViewHome onClick", "Button1");
                // Criteo SDK
                EventService criteoEventService = new EventService(getApplicationContext());
                //Create HomeViewEvent
                // Create the home view event
                HomeViewEvent homeView = new HomeViewEvent();

                /*
                Add extra data here if required.
                Send the event to Criteo
                */
                criteoEventService.send(homeView);
            }
        });

        //Event for Criteo ViewProduct event
        m_ViewProduct =(Button)findViewById(R.id.button2);
        m_ViewProduct.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("Criteo ViewProduct onClick", "Button2");

                // create viewProduct event

            }
        });


        return ;
    }


}
