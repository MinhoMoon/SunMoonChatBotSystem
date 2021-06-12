package com.example.sunmoonchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Category extends AppCompatActivity {
    String[] item = {"오늘의 추천메뉴","홈"};
    Spinner spinner;
    boolean erCk = true;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);
        spinner = (Spinner)findViewById(R.id.rankmenu);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()// 스피너 메뉴 이동
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(erCk)
                {
                    erCk = false;
                }
                else
                {
                    if(i==0)
                    {
                        goRank();
                    }
                    else if(i==1)
                    {
                        goHome();
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }
    void goHome()
    {
        it = new Intent(this, ChatbotHome.class);
        startActivity(it);
    }
    void goRank()
    {
        it = new Intent(this, Category.class);
        startActivity(it);
    }
}