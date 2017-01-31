package com.example.ravi.customnvaigationdrawer;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;

    ActionBarDrawerToggle mDrawerToggle;
     private static final String Root_url="http://api.androidhive.info";
    List<Model> modelList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          insertUser();
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }

        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

    }

    private void insertUser() {


        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Root_url).build();

        ApiService api = adapter.create(ApiService.class);

        api.Myeth(new Callback<JsonArray>() {
            @Override
            public void success(JsonArray jsonElements, Response response) {
                for (int i = 0; i < jsonElements.size(); i++) {

                    JsonObject jsonObject1 = jsonElements.get(i).getAsJsonObject();
                    String image = jsonObject1.get("image").getAsString();
                    String title = jsonObject1.get("releaseYear").getAsString();
                    Model model = new Model();
                    model.setImage(image);
                    model.setName(""+title);
                    modelList.add(model);

                }


                CustomAdapter customAdapter=new CustomAdapter(modelList,getApplicationContext());
                mRecyclerView.setAdapter(customAdapter);



            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "retro error"+error.toString(), Toast.LENGTH_SHORT).show();


            }
        });


    }





}

