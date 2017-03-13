package mgnregs.attendance;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;


/**
 * ${PACKAGE_NAME} Created by Vivek on 12-03-2017.
 */

public class Database_fetch extends Activity{
    ProgressBar progress=null;
    JSONObject jsonObject;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_login_splash);

            progress = (ProgressBar)findViewById(R.id.progressBar);
            progress.setIndeterminate(true);

            jsonObject= new JSONObject();
        }

public String getJSON(String url, int timeout){
        HttpsURLConnection c = null;
        //Download JSON data from URL
        try{
            URL u = new URL(url);
            c = (HttpsURLConnection) u.openConnection();
            c.setRequestMethod("POST");
            c.setRequestProperty("Content-length","0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.connect();
            int status = c.getResponseCode();

            switch (status){
                case 200:
                case 201:
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine())!=null){
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            bufferedReader.close();
            return stringBuilder.toString();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,null, e);
            e.printStackTrace();
        }
        finally {
            if (c!=null){
                try {
                    c.disconnect();
                }
                catch (Exception e){
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE,null, e);
                }
            }
        }
        return null;
    }
}

