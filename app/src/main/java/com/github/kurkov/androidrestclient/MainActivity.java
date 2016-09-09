package com.github.kurkov.androidrestclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.kurkov.androidrestclient.domain.Message;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

    Message response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnGet = (Button) findViewById(R.id.btnGet);
        final Button btnPost = (Button) findViewById(R.id.btnPost);
        final Button btnPut = (Button) findViewById(R.id.btnPut);
        final Button btnDelete = (Button) findViewById(R.id.btnDelete);

        final TextView URLtv = (TextView) findViewById(R.id.URLtv);

        EditText urlRequest = (EditText) findViewById(R.id.urlRequest);
        EditText requestData = (EditText) findViewById(R.id.requestData);


        // The connection URL
        final String URI = getURI(URLtv, urlRequest);

        //assert btnGet != null;
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendRequestJob job = new SendRequestJob();
                job.execute();
                EditText responseData = (EditText) findViewById(R.id.responseData);
                responseData.setText(response.getText());
            }
        });

        assert btnPost != null;
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        assert btnPut != null;
        btnPut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        assert btnDelete != null;
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private String getURI(TextView URLtv, EditText urlRequest) {
        assert URLtv != null;
        assert urlRequest != null;
        String URI = URLtv.getText().toString() + urlRequest.getText().toString();
        return URI;
    }

    private class SendRequestJob extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String[] params) {
            // do above Server call here

            /*Resty resty = new Resty();
            String result = new String();
            try {
                result = resty.json("http://chat-v1.herokuapp.com/api/message/1").toObject().get("text").toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("result= " + result);
            return result;*/

            // The connection URL
            String url = "http://chat-v1.herokuapp.com/api/message/1";

            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

            // Add the String message converter
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            // Make the HTTP GET request, marshaling the response to a String
            ResponseEntity<Message> result = restTemplate.getForEntity(url, Message.class);
            response = new Message(result.getBody().getId(), result.getBody().getDateOfCreation(), result.getBody().getText());
            return "OK";
        }

        @Override
        protected void onPostExecute(String message) {
            //process message
        }
    }
}


