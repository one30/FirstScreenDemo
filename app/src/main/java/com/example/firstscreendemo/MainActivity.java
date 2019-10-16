package com.example.firstscreendemo;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView myImageView;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //定义一个子控件
        myImageView = new ImageView(this);
        //为子控件设置ID
        myImageView.setId(1);
        flag=2;

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

        if(flag==1)//居中显示
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
        else if(flag==2)//铺满
        {
            DisplayMetrics metric = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getRealMetrics(metric);
//            int width = metric.widthPixels; // 宽度（PX）
//            int height = metric.heightPixels; // 高度（PX）

            //设置ImageView的布局参数
            RelativeLayout.LayoutParams imageParams =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.MATCH_PARENT);
//            RelativeLayout.LayoutParams imageParams =
//                    new RelativeLayout.LayoutParams(width,height);
            imageParams.addRule(RelativeLayout.CENTER_VERTICAL);
            imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
//            imageParams.width=width;
//            imageParams.height=height;
            //拉伸平铺图片
            myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //将布局添加到父容器中
            myLayout.addView(myImageView,imageParams);
        }



        setContentView(myLayout);
    }


}
