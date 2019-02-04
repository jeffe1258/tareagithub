package miu.facci.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import miu.facci.com.client.ClientRetrofit;
import miu.facci.com.client.RetroClient;
import miu.facci.com.entity.Follower;
import miu.facci.com.listView.List_adapter;
import miu.facci.com.listView.RowItem;

import java.util.ArrayList;
import java.util.List;

import miu.facci.com.R;

import miu.facci.com.client.GlobalData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Perfil extends AppCompatActivity {

    private List<Follower> followerList = new ArrayList<>();
    private ListView listView;
    private ProgressBar progressBar;
    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);//inicializa barra de progreso
        progressBar.setVisibility(View.VISIBLE);//visible
        rowItems = new ArrayList<>();//Array List

        GlobalData globalData = (GlobalData)Perfil.this.getApplication();//instancia de la clase GlobalData
        TextView repos = (TextView) findViewById(R.id.textView_nrepo);//inicializa texview repos
        repos.setText(globalData.getUser().getPublic_repos());//manda nonombre de usuario
        TextView followers = (TextView) findViewById(R.id.textView_nfollow);//inicializa textview seguidores
        followers.setText(globalData.getUser().getFollowers());//envia los nombres de los seguidores a la entidad
        String follower = globalData.getUser().getFollowers();
        if(!follower.equals("0")) getFollowers();
        else progressBar.setVisibility(View.GONE);
    }

    public void getFollowers(){
        ClientRetrofit clientRetrofit = RetroClient.getClientRetrofit();//inicializa cliente retrofit
        GlobalData globalData= (GlobalData)Perfil.this.getApplication();//instancia de la clase Global
        String username= globalData.getLogin();//Guarda nombre de usuario
        Call<List<Follower>> getFollowersCall = clientRetrofit.getGITFollowers(username);//llamada a retrofit para obtener una lista  de los seguidores
        getFollowersCall.enqueue(new Callback<List<Follower>>() {//enviar solicitud
            @Override
            public void onResponse(Call<List<Follower>> call, Response<List<Follower>> response) {//repuesta
                followerList = response.body();//obtiene la lista de los seguidores de la entidad Followers
                progressBar.setVisibility(View.GONE);
                printList();//imprimir
            }

            @Override
            public void onFailure(Call<List<Follower>> call, Throwable t) {
                call.cancel();//cancelar solicitud
                progressBar.setVisibility(View.GONE);//de baja
                Toast.makeText(Perfil.this, "Error en obtener a seguidores", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void printList(){
        for (int i = 0; i < followerList.size(); i++){//recorrido de los seguidores segun el tamaño
            RowItem item = new RowItem(R.drawable.boy,followerList.get(i).getLogin());//lista personalizada de los seguidores foto y nombre
            rowItems.add(item);//elementos insertado a la listview
        }
        listView = (ListView) findViewById(R.id.list);//inicializa listview
        List_adapter adapter = new List_adapter(this,R.layout.activity_entry,rowItems);//instanccia de la clase adapter
        listView.setAdapter(adapter);//cargar el adapter en el listview
    }

}
