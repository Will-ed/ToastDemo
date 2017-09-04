package com.ed.will.toastdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toast1)
    Button toast1;
    @BindView(R.id.toast2)
    Button toast2;
    @BindView(R.id.toast3)
    Button toast3;
    @BindView(R.id.toast4)
    Button toast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toast1, R.id.toast2, R.id.toast3,R.id.toast4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toast1:
                toast1();
                break;
            case R.id.toast2:
                toast2();
                break;
            case R.id.toast3:
                toast3();
                break;
            case R.id.toast4:
                toast4();
                break;
        }
    }

    private void toast4() {
        Toast toast=Toast.makeText(getApplicationContext(),"Toast背景色和自体颜色的改变",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        LinearLayout linearLayout= (LinearLayout) toast.getView();
        ////linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        linearLayout.setBackgroundColor(Color.parseColor("#00ffff"));
        TextView textView= (TextView) linearLayout.getChildAt(0);
        textView.setTextColor(Color.parseColor("#FF0000"));
        toast.show();
    }

    private void toast3() {
        Toast toast=Toast.makeText(getApplicationContext(),"Toast显示图片",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        ImageView imageView=new ImageView(MainActivity.this);
        imageView.setImageResource(R.mipmap.ic_launcher);
        toast.setView(imageView);
        toast.show();

    }

    private void toast2() {
        Toast toast=Toast.makeText(getApplicationContext(),"Toast显示位置",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    private void toast1() {
        Toast.makeText(getApplicationContext(),"Tosat的基础用法",Toast.LENGTH_SHORT).show();
    }
}
