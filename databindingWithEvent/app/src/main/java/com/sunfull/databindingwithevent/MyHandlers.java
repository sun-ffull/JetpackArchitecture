package com.sunfull.databindingwithevent;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyHandlers {

    Context context;
    public MyHandlers(Context context){
        this.context = context;
    }
    public void onCLickFriend(View view){
        Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
    }
}
