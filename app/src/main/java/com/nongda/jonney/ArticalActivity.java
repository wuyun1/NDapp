package com.nongda.jonney;

import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.nongda.jonney.global.GlobalApp;
import com.nongda.jonney.vo.User;

public class ArticalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artical);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        User user = GlobalApp.getInstance().getUser();
        getSupportActionBar().setTitle(user.getusertype()+"   "+user.getUserName());
        TextView message = (TextView) findViewById(R.id.message);
        message.setText(user.toString().replaceAll(", ","\n---------------------------\n"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "注销登录", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                setResult(0);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_artical, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_logout:
                GlobalApp.getInstance().loginOut();
                setResult(2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
