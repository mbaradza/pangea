package zw.co.ncmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zw.co.ncmp.business.TXTNew;

public class ODSVSelectionActivity extends MenuBar implements View.OnClickListener {

    Button btn_option_one;
    Button btn_option_two;
    Button btn_option_three;
    Button btn_option_four;
    Button btn_option_five;
    Button btn_option_six;
    Button btn_option_seven;
    Button btn_option_eight;
    Button btn_option_nine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_activity);

        btn_option_one = (Button) findViewById(R.id.btn_option_one);
        btn_option_one.setOnClickListener(this);
        btn_option_one.setBackgroundResource(R.drawable.finish_background);
        btn_option_one.setText("Monthly Report Form");

        btn_option_two = (Button) findViewById(R.id.btn_option_two);
        btn_option_two.setOnClickListener(this);
        btn_option_two.setBackgroundResource(R.drawable.finish_background);
        btn_option_two.setText("Registers");

        btn_option_three = (Button) findViewById(R.id.btn_option_three);
        btn_option_three.setOnClickListener(this);
        btn_option_three.setBackgroundResource(R.drawable.finish_background);
        btn_option_three.setVisibility(View.GONE);

        btn_option_four = (Button) findViewById(R.id.btn_option_four);
        btn_option_four.setOnClickListener(this);
        btn_option_four.setBackgroundResource(R.drawable.finish_background);
        btn_option_four.setVisibility(View.GONE);

        btn_option_five = (Button) findViewById(R.id.btn_option_five);
        btn_option_five.setOnClickListener(this);
        btn_option_five.setBackgroundResource(R.drawable.finish_background);
        btn_option_five.setVisibility(View.GONE);

        btn_option_six = (Button) findViewById(R.id.btn_option_six);
        btn_option_six.setOnClickListener(this);
        btn_option_six.setBackgroundResource(R.drawable.finish_background);
        btn_option_six.setVisibility(View.GONE);

        btn_option_seven = (Button) findViewById(R.id.btn_option_seven);
        btn_option_seven.setOnClickListener(this);
        btn_option_seven.setBackgroundResource(R.drawable.finish_background);
        btn_option_seven.setVisibility(View.GONE);

        btn_option_eight = (Button) findViewById(R.id.btn_option_eight);
        btn_option_eight.setOnClickListener(this);
        btn_option_eight.setBackgroundResource(R.drawable.finish_background);
        btn_option_eight.setVisibility(View.GONE);

        btn_option_nine = (Button) findViewById(R.id.btn_option_nine);
        btn_option_nine.setOnClickListener(this);
        btn_option_nine.setBackgroundResource(R.drawable.finish_background);
        btn_option_nine.setVisibility(View.GONE);

        setSupportActionBar(createToolBar("OSDV Selection"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        if (v.getId() == btn_option_one.getId()) {
            intent = new Intent(this, MonthReportFormListActivity.class);
        }

        if (v.getId() == btn_option_two.getId()) {
            intent = new Intent(this, RegisterFormListActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
