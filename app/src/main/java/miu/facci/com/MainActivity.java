package miu.facci.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import miu.facci.com.client.ClientRetrofit;
import miu.facci.com.client.RetroClient;
import miu.facci.com.entity.User;

import miu.facci.com.R;

import miu.facci.com.client.GlobalData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private String name;
    public static GlobalData globalData;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);//inicializa editext
        Button button = (Button) findViewById(R.id.button);//inicializa button
        button.setOnClickListener(new View.OnClickListener() {//accion del boton
            @Override
            public void onClick(View v) {
                getUser();
            }
        });
        globalData = (GlobalData)this.getApplication();
    }


    public void getUser(){
        username.setError(null);
        name = username.getText().toString();//obtener usuario
        ClientRetrofit clientRetrofit = RetroClient.getClientRetrofit();//iniciarlizar cliente retrofit
        progressBar = (ProgressBar) findViewById(R.id.progressBar);//inicializar barra de progreso
        progressBar.setVisibility(View.VISIBLE);//de baja
        Call<User> getUserCall = clientRetrofit.getGITUser(name);//llamada donde especifica el tipo de solicitud y la URL relativa
        getUserCall.enqueue(new Callback<User>() {//Enví de forma asíncrona la solicitud callback
            @Override
            public void onResponse(Call<User> call, Response<User> response) {//repuesta
                User user = response.body();
                GlobalData globalData = MainActivity.this.globalData;//instancia
                globalData.setUser(user);//obtener usuario
                Intent intent = new Intent(MainActivity.this,Perfil.class);//actividad que se debe iniciar
                progressBar.setVisibility(View.GONE);
                startActivity(intent);//iniciar actividad
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {//falla
                call.cancel();//llamada o solicitud cancelada
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Usuario no existe!", Toast.LENGTH_LONG).show();
            }
        });
    }

}
