package wallpapers.dhruv.jagrit.avengers.avengers;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by JAGRIT on 21-04-2015.
 */
public class FullImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_activity);


        Intent intent = getIntent();
        final int positon = intent.getIntExtra(MainActivity.EXTRA_ID,0);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_ID, 0));


        Button b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Wallpaper Set", Toast.LENGTH_LONG).show();
                InputStream bingo = getResources().openRawResource(positon);
                Bitmap dhruv = BitmapFactory.decodeStream(bingo);
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                // get the height and width of screen
                int height = metrics.heightPixels;
                int width = metrics.widthPixels;

                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setBitmap(dhruv);



                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}