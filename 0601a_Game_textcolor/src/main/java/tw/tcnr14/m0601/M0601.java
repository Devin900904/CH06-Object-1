package tw.tcnr14.m0601;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class M0601 extends AppCompatActivity {

    private TextView complay, textselect, textResult;
    private String user_select;
    private String answer;
    private Button btnScissors;
    private Button btnStone;
    private Button btnNet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0601);
        setupCompont();
    }

    private void setupCompont() {
        complay = (TextView) findViewById(R.id.m0601_c001);
        textselect = (TextView) findViewById(R.id.m0601_s001);
        textResult = (TextView) findViewById(R.id.m0601_f000);


        btnScissors = (Button) findViewById(R.id.m0601_b001);
        btnStone = (Button) findViewById(R.id.m0601_b002);
        btnNet = (Button) findViewById(R.id.m0601_b003);

        btnScissors.setOnClickListener(b001On);
        btnStone.setOnClickListener(b001On);
        btnNet.setOnClickListener(b001On);


    }


    private View.OnClickListener b001On = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            int iComplay = (int) (Math.random() * 3 + 1);

            switch (v.getId()) {
                case R.id.m0601_b001:
                    user_select = getString(R.string.m0601_s001) + " " + getString(R.string.m0601_b001);
                    switch (iComplay) {
                        case 1:

                            complay.setText(R.string.m0601_b001);



                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f003);
                            textResult.setTextColor(Color.YELLOW);
                            break;
                        case 2:
                            complay.setText(R.string.m0601_b002);
                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f002);
                            textResult.setTextColor(Color.RED);

                            break;
                        case 3:
                            complay.setText(R.string.m0601_b003);
                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f001);
                            textResult.setTextColor(Color.GREEN);
                            break;
                    }
                    break;


                case R.id.m0601_b002:

                    user_select = getString(R.string.m0601_s001) + " " + getString(R.string.m0601_b002);
                    switch (iComplay) {

                        case 1:

                            complay.setText(R.string.m0601_b001);

                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f001);
                            textResult.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            complay.setText(R.string.m0601_b002);
                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f003);
                            textResult.setTextColor(Color.YELLOW);

                            break;
                        case 3:
                            complay.setText(R.string.m0601_b003);
                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f002);
                            textResult.setTextColor(Color.RED);
                            break;
                    }
                    break;


                case R.id.m0601_b003:
                    user_select = getString(R.string.m0601_s001) + " " + getString(R.string.m0601_b003);

                    switch (iComplay) {
                        case 1:

                            complay.setText(R.string.m0601_b001);

                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f002);
                            textResult.setTextColor(Color.RED);
                            break;
                        case 2:
                            complay.setText(R.string.m0601_b002);
                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f001);
                            textResult.setTextColor(Color.GREEN);

                            break;
                        case 3:
                            complay.setText(R.string.m0601_b003);
                            textResult.setTextColor(Color.YELLOW);
                            answer = getString(R.string.m0601_f000) + " " + getString(R.string.m0601_f003);

                            break;
                    }
                    break;


            }
            textselect.setText(user_select);
            textResult.setText(answer);


        }


    };
};

