package com.mgnregs.mgnregsattendance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Vivek on 12-03-2017.
 */

public class Login extends Activity{
    Button signin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);

        signin = (Button)findViewById(R.id.signin_button);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent("com.mgnregs.mgnregsattendance.Database_fetch");
                startActivity(login);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
}
