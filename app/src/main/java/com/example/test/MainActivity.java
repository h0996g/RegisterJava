package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button creeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
                getSupportActionBar().setTitle("Connectez-vous");
                getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.grey));
        creeButton =(Button) findViewById(R.id.creeCompte);
        creeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    openActivite2();
            }
        });
    }
    public void openActivite2(){
        Intent intent=new Intent(MainActivity.this, Activity2.class);
        Bundle bundle = new Bundle();
//        bundle.putSerializable("obj",user);
        intent.putExtras(bundle);
    this.startActivity(intent);
//        this.startActivityForResult(intent, 99);

    }

}