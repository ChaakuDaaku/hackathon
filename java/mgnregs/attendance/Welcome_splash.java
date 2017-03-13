package mgnregs.attendance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * ${PACKAGE_NAME} Created by Vivek on 12-03-2017.
 */

public class Welcome_splash extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_splash);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                finally{
                    Intent login=new Intent("mgnregs.attendance.Login");
                    startActivity(login);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
