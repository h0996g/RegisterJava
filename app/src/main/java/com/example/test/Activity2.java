package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Activity2 extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    private Button button;
    private User user;

    private EditText nom;
    private EditText password;

    private EditText prenom;
    private EditText email;
    private TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Spinner countrySpinner = findViewById(R.id.country_spinner);
        String[] countryCodes = {"+1 (USA)", "+44 (UK)", "+33 (France)", "+49 (Germany)", "+81 (Japan)",  "+213 (Algeria)"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countryCodes);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(countryAdapter);
//        ------------------------ AppBar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Cree un compte");
        getWindow().setStatusBarColor(ContextCompat.getColor(Activity2.this,R.color.grey));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//------------------------------------------------------

        prenom=(EditText) findViewById(R.id.prenom);
        password=(EditText) findViewById(R.id.password);

        nom=(EditText) findViewById(R.id.nom);
        email=(EditText) findViewById(R.id.email);
        phone=(TextView)findViewById(R.id.phone);
        button=(Button) findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( validateEmail(email) & validateUsername(nom)&validatePrenom(prenom)  & validatePassword(password)){
                    openActivite2();
                    finish();
                }
            }
        });


    }
    private boolean validateEmail(EditText email) {
        String emailInput = email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Please enter a valid email address");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }
    private boolean validateUsername(EditText nom) {
        String usernameInput = nom.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            nom.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            nom.setError("Username too long");
            return false;
        } else {
            nom.setError(null);
            return true;
        }
    }
    private boolean validatePrenom(EditText nom) {
        String prenomInput = prenom.getText().toString().trim();

        if (prenomInput.isEmpty()) {
            nom.setError("prenom can't be empty");
            return false;
        } else if (prenomInput.length() > 15) {
            nom.setError("prenom too long");
            return false;
        } else {
            nom.setError(null);
            return true;
        }
    }
    private boolean validatePassword(EditText password) {
        String passwordInput = password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }
    public void openActivite2(){

        Toast t = Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT);
        t.show();

            user=new User(nom.getText().toString(),prenom.getText().toString(),email.getText().toString(),phone.getText().toString());






        Intent intent=new Intent(Activity2.this, HomeActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("obj",user);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    this.startActivity(intent);

//        this.startActivityForResult(intent, 99);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
