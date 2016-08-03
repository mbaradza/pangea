package zw.co.ncmp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import zw.co.ncmp.business.Period;
import zw.co.ncmp.business.ScreenForm;
import zw.co.ncmp.business.Facility;
import zw.co.ncmp.util.AppUtil;

public class ScreenFormActivity extends MenuBar implements View.OnClickListener {

    Spinner facility;
    EditText dateCreated;
    Spinner period;
    EditText name;
    EditText numerator;
    EditText specimentSent;
    EditText tbStatus;
    EditText smear;
    EditText xpert;
    EditText others;

    EditText maleLessThanOne;
    EditText femaleLessThanOne;
    EditText maleOneToFour;
    EditText femaleOneToFour;
    EditText maleFiveToNine;
    EditText maleTenToFourteen;
    EditText femaleFiveToNine;
    EditText femaleTenToFourteen;
    EditText maleFifteenToNineteen;
    EditText femaleFifteenToNineteen;
    EditText maleTwentyPlus;
    EditText femaleTwentyPlus;

    Button btn_save;
    private ScreenForm screenForm;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_form_activity);

        Intent intent = getIntent();
        Long screenForm_id = intent.getLongExtra(AppUtil.ID, 0);

        facility = (Spinner) findViewById(R.id.facility);
        name = (EditText) findViewById(R.id.name);
        period = (Spinner) findViewById(R.id.period);
        numerator = (EditText) findViewById(R.id.numerator);
        specimentSent = (EditText) findViewById(R.id.specimentSent);
        tbStatus = (EditText) findViewById(R.id.tbStatus);
        smear = (EditText) findViewById(R.id.smear);
        xpert = (EditText) findViewById(R.id.xpert);
        others = (EditText) findViewById(R.id.others);
        dateCreated = (EditText) findViewById(R.id.dateCreated);

        maleLessThanOne = (EditText) findViewById(R.id.maleLessThanOne);
        femaleLessThanOne = (EditText) findViewById(R.id.femaleLessThanOne);
        maleOneToFour = (EditText) findViewById(R.id.maleOneToFour);
        femaleOneToFour = (EditText) findViewById(R.id.femaleOneToFour);
        maleFiveToNine = (EditText) findViewById(R.id.maleFiveToNine);
        femaleFiveToNine = (EditText) findViewById(R.id.femaleFiveToNine);
        maleTenToFourteen = (EditText) findViewById(R.id.maleTenToFourteen);
        femaleTenToFourteen = (EditText) findViewById(R.id.femaleTenToFourteen);
        maleFifteenToNineteen = (EditText) findViewById(R.id.maleFifteenToNineteen);
        femaleFifteenToNineteen = (EditText) findViewById(R.id.femaleFifteenToNineteen);
        maleTwentyPlus = (EditText) findViewById(R.id.maleTwentyPlus);
        femaleTwentyPlus = (EditText) findViewById(R.id.femaleTwentyPlus);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                updateLabel(newDate.getTime());
            }

        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        dateCreated.setOnClickListener(this);

        if (screenForm_id != 0) {
            screenForm = ScreenForm.get(screenForm_id);
            numerator.setText(String.valueOf(screenForm.numerator));
            name.setText(String.valueOf(screenForm.name));
            specimentSent.setText(String.valueOf(screenForm.specimentSent));
            tbStatus.setText(String.valueOf(screenForm.tbStatus));
            smear.setText(String.valueOf(screenForm.smear));
            xpert.setText(String.valueOf(screenForm.xpert));
            others.setText(String.valueOf(screenForm.others));

            maleLessThanOne.setText(String.valueOf(screenForm.maleLessThanOne));
            femaleLessThanOne.setText(String.valueOf(screenForm.femaleLessThanOne));
            maleOneToFour.setText(String.valueOf(screenForm.maleOneToFour));
            femaleOneToFour.setText(String.valueOf(screenForm.femaleOneToFour));
            maleFiveToNine.setText(String.valueOf(screenForm.maleFiveToNine));
            femaleFiveToNine.setText(String.valueOf(screenForm.femaleFiveToNine));
            maleTenToFourteen.setText(String.valueOf(screenForm.maleTenToFourteen));
            femaleTenToFourteen.setText(String.valueOf(screenForm.femaleTenToFourteen));
            maleFifteenToNineteen.setText(String.valueOf(screenForm.maleFifteenToNineteen));
            femaleFifteenToNineteen.setText(String.valueOf(screenForm.femaleFifteenToNineteen));
            maleTwentyPlus.setText(String.valueOf(screenForm.maleTwentyPlus));
            femaleTwentyPlus.setText(String.valueOf(screenForm.femaleTwentyPlus));

            dateCreated = (EditText) findViewById(R.id.dateCreated);

            updateLabel(screenForm.dateCreated);

            int i = 0;
            for (Facility s : Facility.getAll()) {
                if (screenForm.facility.equals(facility.getItemAtPosition(i))) {
                    facility.setSelection(i);
                    break;
                }
                i++;
            }

            i = 0;
            for (Period s : Period.getAll()) {
                if (screenForm.period.equals(period.getItemAtPosition(i))) {
                    period.setSelection(i);
                    break;
                }
                i++;
            }

            setSupportActionBar(createToolBar("TB_SCREENDX Update"));
        } else {
            screenForm = new ScreenForm();
            setSupportActionBar(createToolBar("TB_SCREENDX"));
        }

        ArrayAdapter<Facility> facilityArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Facility.getAll());
        facilityArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facility.setAdapter(facilityArrayAdapter);

        ArrayAdapter<Period> periodArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Period.getAll());
        periodArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        period.setAdapter(periodArrayAdapter);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        if (screenForm.serverId != null) {
            btn_save.setVisibility(View.GONE);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == btn_save.getId()) {
            if (validate()) {
                screenForm.facility = (Facility) facility.getSelectedItem();
                screenForm.name = name.getText().toString();
                screenForm.period = (Period) period.getSelectedItem();
                screenForm.numerator=AppUtil.getLongValue(numerator.getText().toString());
                screenForm.specimentSent=AppUtil.getLongValue(specimentSent.getText().toString());
                screenForm.tbStatus = AppUtil.getLongValue(tbStatus.getText().toString());
                screenForm.smear = AppUtil.getLongValue(smear.getText().toString());
                screenForm.xpert = AppUtil.getLongValue(xpert.getText().toString());
                screenForm.others = AppUtil.getLongValue(others.getText().toString());

                screenForm.maleLessThanOne = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                screenForm.femaleLessThanOne = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                screenForm.maleOneToFour = AppUtil.getLongValue(maleOneToFour.getText().toString());
                screenForm.femaleOneToFour = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                screenForm.maleFiveToNine = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                screenForm.femaleFiveToNine = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                screenForm.maleTenToFourteen = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                screenForm.femaleTenToFourteen = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                screenForm.maleFifteenToNineteen = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                screenForm.femaleFifteenToNineteen = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                screenForm.maleTwentyPlus = AppUtil.getLongValue(maleTwentyPlus.getText().toString());
                screenForm.femaleTwentyPlus = AppUtil.getLongValue(femaleTwentyPlus.getText().toString());

                screenForm.dateCreated = AppUtil.getDate(dateCreated.getText().toString());
                screenForm.save();
                intent = new Intent(this, ScreenFormListActivity.class);
                startActivity(intent);
                finish();
            } else {
                return;
            }
        }

        if (v.getId() == dateCreated.getId()) {
            datePickerDialog.show();
        }


    }

    private void updateLabel(Date date) {
        dateCreated.setText(AppUtil.getStringDate(date));
    }

    public boolean validate() {
        boolean valid = true;

        String name = numerator.getText().toString().toString();

        if (name.isEmpty()) {
            numerator.setError("Required");
            valid = false;
        } else {
            numerator.setError(null);
        }

        name = tbStatus.getText().toString().toString();

        if (name.isEmpty()) {
            tbStatus.setError("Required");
            valid = false;
        } else {
            tbStatus.setError(null);
        }

        name = specimentSent.getText().toString().toString();

        if (name.isEmpty()) {
            specimentSent.setError("Required");
            valid = false;
        } else {
            specimentSent.setError(null);
        }

        return valid;
    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
