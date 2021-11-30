package tw.tcnr14.m0606;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import tw.tcnr14.m0606.R;

public class M0606 extends AppCompatActivity {

    private TextView  textselect, textResult;
    private String user_select;
    private String answer;
    private ImageButton btnScissors;
    private ImageButton btnStone;
    private ImageButton btnNet;
    private ImageView complay;
    private MediaPlayer startmusic;
    private MediaPlayer mediaWIN;
    private MediaPlayer mediaLose;
    private MediaPlayer mediaVoctory;
    private MediaPlayer medianight;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0606);
        setupCompont();
    }

    private void setupCompont() {
        complay = (ImageView) findViewById(R.id.m0606_c001);   //電腦選
        textselect = (TextView) findViewById(R.id.m0606_s001); //選擇結果
        textResult = (TextView) findViewById(R.id.m0606_f000);



        btnScissors = (ImageButton) findViewById(R.id.m0606_b001);
        btnStone = (ImageButton) findViewById(R.id.m0606_b002);
        btnNet = (ImageButton) findViewById(R.id.m0606_b003);
        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
        startmusic.start();
        mediaWIN = MediaPlayer.create(getApplication(), R.raw.vctory);
        mediaLose= MediaPlayer.create(getApplication(), R.raw.lose);
        mediaVoctory= MediaPlayer.create(getApplication(), R.raw.haha);
        medianight = MediaPlayer.create(getApplication(), R.raw.goodnight);

        // --開啟片頭音樂-----
//        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//        startmusic.start();





        btnScissors.setOnClickListener(b001On);
        btnStone.setOnClickListener(b001On);
        btnNet.setOnClickListener(b001On);


    }


    private View.OnClickListener b001On = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            int iComplay = (int) (Math.random() * 3 + 1);

            switch (v.getId()) {
                case R.id.m0606_b001:
                    user_select = getString(R.string.m0606_s001) + " " + getString(R.string.m0606_b001);
                    u_setalpha();
                    btnScissors.getBackground().setAlpha(180);
                    switch (iComplay) {
                        case 1:

                            complay.setImageResource(R.drawable.stone);
//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f002);
//                            textResult.setTextColor(Color.YELLOW);
                            music(3);
                            break;


                        case 2:
                            complay.setImageResource(R.drawable.scissors);
//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f003);
//                            textResult.setTextColor(Color.RED);
                            music(1);

                            break;
                        case 3:
                            complay.setImageResource(R.drawable.net);
//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f001);
//                            textResult.setTextColor(Color.GREEN);
                            music(2);
                            break;
                    }
                    break;


                case R.id.m0606_b002:

                    user_select = getString(R.string.m0606_s001) + " " + getString(R.string.m0606_b002);
                    u_setalpha();
                    btnStone.getBackground().setAlpha(255);
                    switch (iComplay) {

                        case 1:

                            complay.setImageResource(R.drawable.scissors);

//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f001);
//                            textResult.setTextColor(Color.GREEN);
                            music(2);
                            break;
                        case 2:
                            complay.setImageResource(R.drawable.stone);
//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f003);
//                            textResult.setTextColor(Color.YELLOW);
                            music(1);

                            break;
                        case 3:
                            complay.setImageResource(R.drawable.net);
//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f002);
//                            textResult.setTextColor(Color.RED);
                            music(3);
                            break;
                    }
                    break;


                case R.id.m0606_b003:
                    user_select = getString(R.string.m0606_s001) + " " + getString(R.string.m0606_b003);
                    u_setalpha();
                    btnNet.getBackground().setAlpha(180);
                    switch (iComplay) {
                        case 1:

                            complay.setImageResource(R.drawable.scissors);

//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f002);
//                            textResult.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 2:
                            complay.setImageResource(R.drawable.stone);
//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f001);
//                            textResult.setTextColor(Color.GREEN);
                            music(2);

                            break;
                        case 3:
                            complay.setImageResource(R.drawable.net);
//                            textResult.setTextColor(Color.YELLOW);
//                            answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f003);
                            music(1);
                            break;
                    }
                    break;


            }
            textselect.setText(user_select);
            textResult.setText(answer);


        }


    };

    private void u_setalpha() {
        btnScissors.setBackgroundColor(Color.GRAY);
        btnScissors.getBackground().setAlpha(0);
        btnStone.setBackgroundColor(Color.YELLOW);
        btnStone.getBackground().setAlpha(0);
        btnNet.setBackgroundColor(Color.GREEN);
        btnNet.getBackground().setAlpha(0);
    }
        //imageButton 背景為銀色且為全透明
//        btnScissors.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnScissors.getBackground().setAlpha(0); //0-255
//        btnStone.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnStone.getBackground().setAlpha(0);
//        btnNet.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnNet.getBackground().setAlpha(0);







//    private void music(int i) {
//    }

    private void music(int i) {
        if(startmusic.isPlaying()) startmusic.stop();
        if(mediaWIN.isPlaying()) mediaWIN.stop();
        if(mediaLose.isPlaying()) mediaLose.stop();
        if(mediaVoctory.isPlaying()) mediaVoctory.stop();
        switch (i){
            case 1:
                textResult.setTextColor(Color.YELLOW);
                answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f003);

                toast = Toast.makeText(getApplicationContext(), getText(R.string.m0606_t007), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM , 0, 0);
                toast.show();
                mediaVoctory .start();



                break;
            case 2:
                textResult.setTextColor(Color.GREEN);
                answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f001);
                toast = Toast.makeText(getApplicationContext(), getText(R.string.m0606_t008), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM , 0, 0);
                toast.show();
                mediaWIN .start();

                break;

            case 3:
                textResult.setTextColor(Color.RED);
                answer = getString(R.string.m0606_f000) + " " + getString(R.string.m0606_f002);
                toast = Toast.makeText(getApplicationContext(), getText(R.string.m0606_t009), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM , 0, 0);
                toast.show();
                mediaLose .start();

                break;
            case 4:
                medianight.start();
                break;



        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        music(4);
        this.finish();

    }

    @Override
    protected void onStop() {
//        if (startmusic.isPlaying()) startmusic.stop();
        super.onStop();
        music(4);
        this.finish();


    }


};

