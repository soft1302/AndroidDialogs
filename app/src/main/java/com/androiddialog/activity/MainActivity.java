package com.androiddialog.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androiddialog.R;
import com.androiddialog.dialog.PictureSelectDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ic_back, ic_menu;
    private TextView tv_toolbar_title, tv_back;

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
        tv_toolbar_title = (TextView) findViewById(R.id.tv_toolbar_title);
        ic_back = (ImageView) findViewById(R.id.ic_back);
        ic_menu = (ImageView) findViewById(R.id.ic_menu);
        ic_back.setImageResource(R.mipmap.ic_back);
        ic_menu.setImageResource(R.mipmap.ic_search);
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_back.setText("返回");
        ic_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
            }
        });
        tv_toolbar_title.setText("自定义dialog");
    }


    public void showDialog() {
        final Dialog dialog = new PictureSelectDialog().creatDialog(MainActivity.this);
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
