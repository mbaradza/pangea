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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.osdv_selection_activity);

        btn_option_one = (Button) findViewById(R.id.btn_option_one);
        btn_option_one.setOnClickListener(this);

        btn_option_two = (Button) findViewById(R.id.btn_option_two);
        btn_option_two.setOnClickListener(this);

        btn_option_three = (Button) findViewById(R.id.btn_option_three);
        btn_option_three.setOnClickListener(this);

        setSupportActionBar(createToolBar("DSD Selection"));
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

        if (v.getId() == btn_option_three.getId()) {
            intent = new Intent(this, TXTNewListActivity.class);
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
