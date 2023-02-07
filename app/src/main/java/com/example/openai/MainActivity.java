package com.example.openai;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(new Runnable() {
            @Override
            public void run() {
                OpenAiService service = new OpenAiService("OPENAI_Token");
                CompletionRequest completionRequest = CompletionRequest.builder()
                        .prompt("Somebody once told me the world is gonna roll me")
                        .model("ada")
                        .echo(true)
                        .build();
                service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
            }
        }).start();


    }


}