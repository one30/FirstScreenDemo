package com.example.firstscreendemo;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

//    private boolean clicked = false;
//    private Button myButton;
//    private EditText myEditText;
    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //定义三个子控件
//        myButton = new Button(this);
//        myButton.setText("Press me");
//
//        myEditText = new EditText(this);
//        myEditText.setHint("See me");

        myImageView = new ImageView(this);


        //为控件设置ID
//        myButton.setId(1);
//        myEditText.setId(2);
          myImageView.setId(3);

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
        //myImageView = (ImageView)findViewById(R.id.3);
        myImageView.setImageBitmap(bitmap);

        //定义父容器和设置属性
        RelativeLayout myLayout = new RelativeLayout(this);
        //设置背景颜色
        myLayout.setBackgroundColor(Color.BLUE);

        //设置Button布局参数
//        RelativeLayout.LayoutParams buttonParams =
//                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT);
//        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        //设置EditText的布局参数
//        RelativeLayout.LayoutParams textParams =
//                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT);
//        textParams.addRule(RelativeLayout.ABOVE,myButton.getId());
//        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        textParams.setMargins(0,0,0,80);

        //设置EditText的宽度为指定大小宽度，要相应的dp转化为px
//        Resources r = getResources();
//        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());

        //设置ImageView的布局参数
        RelativeLayout.LayoutParams imageParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        //imageParams.addRule(RelativeLayout.BELOW,myButton.getId());
        imageParams.addRule(RelativeLayout.CENTER_VERTICAL);
        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);


        //myEditText.setWidth(px);
        //将布局添加到父容器中
//        myLayout.addView(myButton,buttonParams);
//        myLayout.addView(myEditText,textParams);
        myLayout.addView(myImageView,imageParams);

        setContentView(myLayout);
    }
}
