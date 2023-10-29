package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView nom;
    private TextView prenom;
    private TextView email;
    private TextView phone;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout=(Button)findViewById(R.id.logout);
        nom=  (TextView)findViewById(R.id.nom);
        prenom=  (TextView)findViewById(R.id.prenom);
        email=  (TextView)findViewById(R.id.email);
        phone=  (TextView)findViewById(R.id.phone);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        User user = (User) bundle.getSerializable("obj");


        nom.setText(user.nom);
        prenom.setText(user.prenom);
        email.setText(user.email);
        phone.setText(user.phone);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            goToMainActivity();
            }
        });
    }
    public void goToMainActivity(){
        Intent intent=new Intent(HomeActivity.this, MainActivity.class);



        this.startActivity(intent);
        finish();
    }

}