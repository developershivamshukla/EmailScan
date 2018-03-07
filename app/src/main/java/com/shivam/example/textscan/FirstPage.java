package com.shivam.example.textscan;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        b1=findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check()){
                    Intent i = new Intent(FirstPage.this,MainActivity.class);
                    startActivity(i);}
                else
                {
                    Toast.makeText(FirstPage.this, "Internet Unavailable.Please Check your Connectivity", Toast.LENGTH_SHORT).show();
                }

            }
        });
}
    public final boolean check()
    {
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(0).getState()== NetworkInfo.State.CONNECTED||
                connectivityManager.getNetworkInfo(0).getState()== NetworkInfo.State.CONNECTING||
                connectivityManager.getNetworkInfo(1).getState()== NetworkInfo.State.CONNECTING||
                connectivityManager.getNetworkInfo(1).getState()== NetworkInfo.State.CONNECTED)
        {
            return true;
        }
        else if(
                connectivityManager.getNetworkInfo(0).getState()==NetworkInfo.State.DISCONNECTED||
                        connectivityManager.getNetworkInfo(1).getState()==NetworkInfo.State.DISCONNECTED)
        {
            return false;
        }
        return false;
    }

}
