package tw.tcnr14.m0602;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import tw.tcnr14.m0602.R;

public class M0602 extends AppCompatActivity {

    private TextView  textselect, textResult;
    private String user_select;
    private String answer;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;
    private ImageView complay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0602);
        setupCompont();
    }

    private void setupCompont() {
        complay = (ImageView) findViewById(R.id.m0602_c001);
        textselect = (TextView) findViewById(R.id.m0602_s001);
        textResult = (TextView) findViewById(R.id.m0602_f000);


        btnScissors = (ImageButton) findViewById(R.id.m0602_b001);
        btnStone = (ImageButton) findViewById(R.id.m0602_b002);
        btnNet = (ImageButton) findViewById(R.id.m0602_b003);

        btnScissors.setOnClickListener(b001On);
        btnStone.setOnClickListener(b001On);
        btnNet.setOnClickListener(b001On);


    }


    private View.OnClickListener b001On = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            int iComplay = (int) (Math.random() * 3 + 1);

            switch (v.getId()) {
                case R.id.m0602_b001:
                    user_select = getString(R.string.m0602_s001) + " " + getString(R.string.m0602_b001);
                    switch (iComplay) {
                        case 1:

                            complay.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f002);
                            textResult.setTextColor(Color.YELLOW);
                            break;
                        case 2:
                            complay.setImageResource(R.drawable.scissors);
                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f003);
                            textResult.setTextColor(Color.RED);

                            break;
                        case 3:
                            complay.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f001);
                            textResult.setTextColor(Color.GREEN);
                            break;
                    }
                    break;


                case R.id.m0602_b002:

                    user_select = getString(R.string.m0602_s001) + " " + getString(R.string.m0602_b002);
                    switch (iComplay) {

                        case 1:

                            complay.setImageResource(R.drawable.scissors);

                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f001);
                            textResult.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            complay.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f003);
                            textResult.setTextColor(Color.YELLOW);

                            break;
                        case 3:
                            complay.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f002);
                            textResult.setTextColor(Color.RED);
                            break;
                    }
                    break;


                case R.id.m0602_b003:
                    user_select = getString(R.string.m0602_s001) + " " + getString(R.string.m0602_b003);

                    switch (iComplay) {
                        case 1:

                            complay.setImageResource(R.drawable.scissors);

                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f002);
                            textResult.setTextColor(Color.RED);
                            break;
                        case 2:
                            complay.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f001);
                            textResult.setTextColor(Color.GREEN);

                            break;
                        case 3:
                            complay.setImageResource(R.drawable.net);
                            textResult.setTextColor(Color.YELLOW);
                            answer = getString(R.string.m0602_f000) + " " + getString(R.string.m0602_f003);

                            break;
                    }
                    break;


            }
            textselect.setText(user_select);
            textResult.setText(answer);


        }


    };
};

