package tw.tcnr14.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class M0500 extends AppCompatActivity {

    private EditText e001;
    private Button b001;
    private TextView t003;
    private DecimalFormat pondsFormat;
    private String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {     //Ctrl+A=全選  Shift+Ctrl+Alt+L=排列好  Ctrl+Shift+"+"=展開 , +"-"=縮編
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();                                                     //從這開始打"setup"     為了自定義方法
    }

    private void setupViewcomponent() {                                  //private void開頭 自定義配置
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("classtitle");
        this.setTitle(mode_title);



        e001 = (EditText) findViewById(R.id.m0500_e001);        //打"(EditText)findViewById"跑出"(id)"後打"R.id"找"m0500_e001"
        b001 = (Button) findViewById(R.id.m0500_b001);         //選擇EditText  Button TextView 要看相對應類型
        t003 = (TextView) findViewById(R.id.m0500_t003);
        b001.setOnClickListener(b001on);                                   //監聽 b001on=下面宣告要用的名字  "xxxx".setOnClickListener
    }
    private View.OnClickListener b001on = new View.OnClickListener() {         //private View開頭 宣告b001on按鈕被觸碰後要執行的動作
        @Override
        public void onClick(View v) {                                             // DecimalFormat   pondsFormat = new DecimalFormat("0.00000");   ---複製用
            pondsFormat = new DecimalFormat("0.00000"); //複製上面的刪掉DecimalFormat後 pondsFormat選local
            if (e001.getText().toString().length() > 0) {
                ans = pondsFormat.format(Float.parseFloat(e001.getText().toString()) * 2.20462262);//紅的"ans"選local 然後選"String"  (number:"隨意打")
            } else {
                ans = "";
            }
            t003.setText(ans);                                                             //選t003是因為輸出在t003
        }
    };

}