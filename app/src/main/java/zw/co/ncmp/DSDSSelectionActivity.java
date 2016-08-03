package zw.co.ncmp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DSDSSelectionActivity extends MenuBar implements View.OnClickListener {

    Button btn_option_one;
    Button btn_option_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsd_selection_activity);

        btn_option_one = (Button) findViewById(R.id.btn_option_one);
        btn_option_one.setOnClickListener(this);

        btn_option_two = (Button) findViewById(R.id.btn_option_two);
        btn_option_two.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_option_one.getId()) {

        }

        if (v.getId() == btn_option_two.getId()) {

        }

    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
