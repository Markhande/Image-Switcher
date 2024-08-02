package com.example.scrollview;

import android.graphics.drawable.Drawable;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Image_Switcher extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;
    Vibrator vibration;
    int[] images;
    int leng;
    int img_index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_image_switcher);

        imageSwitcher = findViewById(R.id.image_switcher);
//                                 0                   1                     2                  3                4
        images = new int[]{R.drawable.donkey, R.drawable.eagle, R.drawable.giraffe, R.drawable.goat, R.drawable.tree};
        vibration = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView img=new ImageView(getApplicationContext());
                img.setScaleType(ImageView.ScaleType.CENTER);
                return img;
            }
        });
        imageSwitcher.setImageResource(images[0]);

    }
    public void next(View view) {
        vibration.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE));
        img_index++;
        if (img_index == 5){
            img_index=0;
        }
            imageSwitcher.setImageResource(images[img_index]);
    }
    public void previous(View view) {
        vibration.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE));
        img_index--;
        if(img_index < 0){
            img_index= images.length-1;
        }
        imageSwitcher.setImageResource(images[img_index]);
    }
}