package com.example.estudiante.miniflickr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        loginButton = (LoginButton) findViewById(R.id.login_button);
        header = (TextView) findViewById(R.id.txtLogin);

        if(estaLogueado()){

            Intent i = new Intent(getApplicationContext(),NavigationActivity.class);
            startActivity(i);

        }

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent i = new Intent(getApplicationContext(),NavigationActivity.class);
                startActivity(i);

            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.loginCancel, Toast.LENGTH_LONG);
                //header.setText("" + R.string.loginCancel);
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.loginError, Toast.LENGTH_LONG);
                //header.setText("" + R.string.loginError);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private boolean estaLogueado(){
        return AccessToken.getCurrentAccessToken() != null;
    }
}
