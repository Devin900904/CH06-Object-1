package tw.tcnr14.m0609;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Menu03 extends AppCompatActivity {

    private LinearLayout mlay02;
    private TextView myname;
    private TextView tv;
    private String mode_title;
    private Intent intent01 = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        setupViewComponent();
    }

    private void setupViewComponent() {
        mlay02 = (LinearLayout) findViewById(R.id.lay02);
        myname = (TextView) findViewById(R.id.myname);

        //-----------------------------------------------------
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LayoutParams.MATCH_PARENT, 180);
        lp.setMargins(0, 0, 0, 0); // 設定物件之間距離

        // 動態調整高度 抓取使用裝置尺寸
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int newscrollheight = displayMetrics.heightPixels * 86 / 100; // 設定ScrollView使用尺寸的4/5
//         String px = displayMetrics.widthPixels + " x " +
//         displayMetrics.heightPixels;
//         String dp = displayMetrics.xdpi + " x " + displayMetrics.ydpi;
//         String density = "densityDpi = " + displayMetrics.densityDpi +
//         ", density=" + displayMetrics.density + ", scaledDensity = " +
//         displayMetrics.scaledDensity;
//         myname.setText(px + "\n" + dp + "\n" +density + "\n" +
//         newscrollheight);

//------------------------------------------------------------------------

        ScrollView scr01 = (ScrollView) findViewById(R.id.scr01);
        scr01.getLayoutParams().height = newscrollheight;
        scr01.setLayoutParams(scr01.getLayoutParams()); // 重定ScrollView大小
        myname.setText("size:" + displayMetrics.widthPixels + " x "
                + displayMetrics.heightPixels + " "
                + getString(R.string.myname));
        // ----
        TextView objt001 = (TextView) findViewById(R.id.objT001); // 取出參考物件
        objt001.setVisibility(View.GONE); // 設定參考物件隱藏不佔空間
        // 設定class標題
        Intent intent01 = this.getIntent();
        mode_title = intent01.getStringExtra("subname");
        this.setTitle(this.getResources().getIdentifier(mode_title, "string", getPackageName()));
        // ----
        try {
            for (int i = 1; i <= 20; i++) {  // 設定走20圈, 遇到沒資料自動停止.
                tv = new TextView(this); // tv 繼承TextView
                tv.setId(i); // 寫入配置碼ID 代號
                // %02d執行十進制整數轉換d，格式化補零，寬度為2。 因此，一個int參數，它的值是7
                // ，將被格式化為"07"作為一個String
                String microNo = String.format("%02d", i);
//                Log.d(TAG,             microNo                );
                // 取得string 裏頭相對應的ID 碼
                int id = getResources().getIdentifier( mode_title+ microNo, "string", getPackageName());
                // --------------------------------------------

                // --------------------------------------------
                tv.setText(id); // 將產生的物件填入文字.
                tv.setLayoutParams(lp); // 套用格式
                tv.setTextColor(objt001.getCurrentTextColor());      // 以objt001字體顏色為依據
                tv.setGravity(objt001.getGravity());        // 以objt001字體靠右靠左
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, objt001.getTextSize());     // 設定文字大小
                tv.setBackground(objt001.getBackground()); // 設定背景
                tv.setPadding(objt001.getPaddingLeft(),
                        objt001.getPaddingTop(),
                        objt001.getPaddingRight(),
                        objt001.getPaddingBottom());      // 設定文字內間距 left,top,right,bottom
                mlay02.addView(tv);                             // 顯示textview物件

                    tv.setOnClickListener(clkOn);
            }
        } catch (Exception e) {
            return; //for迴圈異常中斷到此跳出
        }
    }


    private View.OnClickListener clkOn =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int ii = (v.getId()); // 下層巨集前兩碼
            String mm = String.format("%02d", ii);
            String theme = "mode_bile" + mm;
            intent01.putExtra("subname", theme); // subname => m05,m06,m07....m17
//            intent01.setClass(Menu03.this, Menu04.class);
            startActivity(intent01);

        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0609, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//         Handle action bar item clicks here. The action bar will
//         automatically handle clicks on the Home/Up button, so long
//         as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
            case R.id.m_about:
                this.finish();
                break;

        }

        if (id == R.id.action_settings) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    } @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"進用返回建",Toast.LENGTH_LONG).show();
//        super.onBackPressed();
    }
}