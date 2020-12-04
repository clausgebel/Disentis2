package de.gebelcl.disentis2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    GridLayout gridLayout;
    ImageView[][] images;

    // true = tile is visible, false = tile is invisible
    boolean[][] imageState = {
            {true, true, true, true, true},
            {true, true, true, true, true},
            {true, true, true, true, true},
            {true, true, true, true, true},
            {true, true, true, true, true}
    };

    public void onImageViewClicked(View view) {
        ImageView imageView = (ImageView) view;
        

        textView.setText(view.getTag().toString());
        textView.setText("[" + ArraySquare.getXTag(view) +"][" +ArraySquare.getYTag(view)+"]");
        textView.setText("" +imageState[0][0]);

        textView.setText("");
        if (imageState[ArraySquare.getXTag(view)][ArraySquare.getYTag(view)]) {
            ArraySquare.changeArraySquare(imageState, ArraySquare.getXTag(view), ArraySquare.getYTag(view));
        }
        textView.setText("" +imageState[0][1]);
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                 if (imageState[x][y])
                    images[x][y].setAlpha(1.0f);
                else
                    images[x][y].setAlpha(0.0f);
            }
        }

        boolean won = true;
        for (boolean[] is: imageState) {
            for (boolean is2: is) {
                if (is2 == true) {
                    won = false;
                    break;
                }
            }
            if (won == false)
                break;
        }

        if (won == true) {
            textView.setVisibility(View.VISIBLE);
            textView.setText("Herzlichen Glückwunsch, Sie haben gewonnen!");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        gridLayout = findViewById(R.id.gridLayout);
        images = new ImageView[5][5];
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                images[j][i] = (ImageView) gridLayout.getChildAt(counter);
                counter++;
            }
        }

    }


}