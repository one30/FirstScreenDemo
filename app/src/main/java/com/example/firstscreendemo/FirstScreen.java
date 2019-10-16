package com.example.firstscreendemo;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class FirstScreen extends AppCompatActivity {

    private ImageView myImageView;
    private TextView countDown;
    //图片放置模式，1是居中，2是平铺
    private int imageflag=1;
    //设置倒计时时间多少s
    private int duration = 8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showFirstScreen();
        initCountDown();
    }

    public void showFirstScreen(){
        //定义子控件
        myImageView = new ImageView(this);
        countDown  = new TextView(this);
        //为子控件设置ID
        myImageView.setId(1);
        countDown.setId(2);
        AssetManager assets = getAssets();
        InputStream is = null;
        //读取assets中的图片
        try{
            is = assets.open("scnu.jpg");
        }catch (IOException e){
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeStream(is,null,options);
        //myImageView = (ImageView)findViewById(R.id.1);
        myImageView.setImageBitmap(bitmap);

        //定义父容器和设置属性
        RelativeLayout myLayout = new RelativeLayout(this);
        //设置背景颜色
        myLayout.setBackgroundColor(Color.BLUE);

        if(imageflag==1)//居中显示
        {
            //设置ImageView的布局参数
            RelativeLayout.LayoutParams imageParams =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            imageParams.addRule(RelativeLayout.CENTER_VERTICAL);
            imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            //将布局添加到父容器中
            myLayout.addView(myImageView,imageParams);
        }
        else if(imageflag==2)//铺满
        {
            //设置ImageView的布局参数
            RelativeLayout.LayoutParams imageParams =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.MATCH_PARENT);
            imageParams.addRule(RelativeLayout.CENTER_VERTICAL);
            imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            //拉伸平铺图片
            myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //将布局添加到父容器中
            myLayout.addView(myImageView,imageParams);
        }

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        //将布局添加到父容器中
        myLayout.addView(countDown,textParams);
        setContentView(myLayout);
    }

    private void initCountDown(){
        myImageView = findViewById(myImageView.getId());
        countDown = findViewById(countDown.getId());
        CountDownTimer timer = new CountDownTimer(duration*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countDown.setText("倒计时:"+(millisUntilFinished/1000)+"s ");
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }

//    private Handler updateHandler = new Handler(){
//
//        @Override
//        public void dispatchMessage(Message msg) {
//            super.dispatchMessage(msg);
//            if(msg.what==2){
//                if(duration>0){
//                    duration--;
//
//                }
//            }
//        }
//    }


}
