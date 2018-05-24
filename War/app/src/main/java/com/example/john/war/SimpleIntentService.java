package com.example.john.war;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class SimpleIntentService extends IntentService {

    private static final String TAG = "com.example.john.war";

    public SimpleIntentService() {
        super("SimpleIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
        Log.i(TAG, "The service has now started");
    }
}
