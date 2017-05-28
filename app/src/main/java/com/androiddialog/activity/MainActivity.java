package com.androiddialog.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androiddialog.R;
import com.androiddialog.dialog.PictureSelectDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private TextView tv_toolbar_title;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void initView() {
        initToolbar();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.mipmap.ic_back);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv_toolbar_title = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        tv_toolbar_title.setText("自定义dialog");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog() {
        final Dialog dialog = new PictureSelectDialog().creatRequestDialog(MainActivity.this);
        dialog.show();
        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.findViewById(R.id.tv_location_picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.findViewById(R.id.tv_camera_piture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button:
                showDialog();
                break;
        }
    }
}
