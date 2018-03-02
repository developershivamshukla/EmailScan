package com.shivam.example.textscan;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.shivam.example.textscan.MainActivity.email;

public class Email extends AppCompatActivity {

    TextView em;
    Button sagain,ex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        em = findViewById(R.id.emailtext);
        em.setText(MainActivity.email);
        sagain =findViewById(R.id.button3);
        ex=findViewById(R.id.button4);
        sagain.setEnabled(false);
        String mail = em.getText().toString().trim();
        String Expn =

                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"

                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."

                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"

                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
        if (mail.matches(Expn) && mail.length() > 0)

        {
            //Toast.makeText(this, "Valid Email", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail});
            intent.putExtra(Intent.EXTRA_SUBJECT, " ");
            startActivity(Intent.createChooser(intent, "Email via..."));

        }
        else
        {
            Toast.makeText(this, "Inavlid Email Format", Toast.LENGTH_SHORT).show();
            sagain.setEnabled(true);
            Intent i = new Intent(Email.this,MainActivity.class);
            startActivity(i);
        }
        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppExit();
                //System.exit(0);
            }
        });

    }
    public void AppExit()
    {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    /*int pid = android.os.Process.myPid();=====> use this if you want to kill your activity. But its not a good one to do.
    android.os.Process.killProcess(pid);*/

    }
}

