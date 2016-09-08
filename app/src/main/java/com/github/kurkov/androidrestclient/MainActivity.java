package com.github.kurkov.androidrestclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.kurkov.androidrestclient.domain.Message;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MainActivity extends AppCompatActivity {

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

        assert btnGet != null;
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new RestTemplate instance
                RestTemplate restTemplate = new RestTemplate();

                // Add the String message converter
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

                // Make the HTTP GET request, marshaling the response to a String
                Message result = restTemplate.getForObject(URI, Message.class);

                EditText responseData = (EditText) findViewById(R.id.responseData);

                assert responseData != null;
                responseData.setText(result.getText());
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
}
