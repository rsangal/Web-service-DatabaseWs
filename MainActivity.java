package com.databasews;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.app.Activity;
 

public class MainActivity extends Activity {
	
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new InsertOperation().execute();
    }

    private class InsertOperation extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
 
        	String result = "Data inserted";
            try {
     
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse httpResponse = httpclient.execute(new HttpGet("http://10.0.2.2:8080/DatabaseWS/rest/emp/users"));
                 } catch (Exception e) {
                Log.d("InputStream", e.getLocalizedMessage());
            }
     
            return result;
          
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
        	EditText myresponse1=(EditText) findViewById(R.id.myresponse);;
        	  
            myresponse1.setBackgroundColor(0xFF00CC00);
           myresponse1.setText("Data inserted Successfully ");
       }
    }
    
}
