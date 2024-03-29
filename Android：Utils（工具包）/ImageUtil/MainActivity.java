package com.takeoffandroid.iconcolorchanger;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtColorCode;
    private Button btnChange;
    private ImageView imgIcon;
    private Bitmap mFinalBitmap;
    private int mColorCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assigning ids to the views used in the project
        findViews();


        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strColorCode = edtColorCode.getText().toString();
                if (strColorCode != null && strColorCode.length() > 0 && strColorCode.length()==7) {
                    mColorCode = Color.parseColor(strColorCode);

                    //Get the image to be changed from the drawable, drawable-xhdpi, drawable-hdpi,etc folder.
                    Drawable sourceDrawable = getResources().getDrawable(R.drawable.android);

                    //Convert drawable in to bitmap
                    Bitmap sourceBitmap = ImageUtil.convertDrawableToBitmap(sourceDrawable);

                    //Pass the bitmap and color code to change the icon color dynamically.

                    mFinalBitmap = ImageUtil.changeImageColor(sourceBitmap, mColorCode);

                    imgIcon.setImageBitmap(mFinalBitmap);
                }else {

                    Toast.makeText(MainActivity.this, "Please enter valid color code with '#' followed by code(Eg : #FFFFFF)",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void findViews() {
        edtColorCode = (EditText) findViewById(R.id.edt_color_code);
        btnChange = (Button) findViewById(R.id.btn_change);
        imgIcon = (ImageView) findViewById(R.id.img_icon);

    }
}
