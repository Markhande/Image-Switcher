package com.example.scrollviewpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class scrollViewDemo extends AppCompatActivity {
    ImageSwitcher imageSwitche;
    int[]  image_arr;
    int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scroll_view_demo);

        image_arr=new int []{R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5};
        imageSwitche = findViewById(R.id.image_switcher);

        imageSwitche.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageview=new ImageView(getApplicationContext());
                imageview.setScaleType(ImageView.ScaleType.CENTER);
                return imageview;
            }
        });
        imageSwitche.setImageResource(image_arr[index]);
    }

    public void next_btn(View view) {
        index = (index + 1) % image_arr.length;
        imageSwitche.setImageResource(image_arr[index]);
    }
    public void previous(View view) {
        index = (index - 1 + image_arr.length) % image_arr.length;
        imageSwitche.setImageResource(image_arr[index]);
    }
}