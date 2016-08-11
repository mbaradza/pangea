package zw.co.ncmp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import zw.co.ncmp.business.StatForm;
import zw.co.ncmp.business.Facility;
import zw.co.ncmp.util.AppUtil;

public class StatFormActivity extends MenuBar implements View.OnClickListener {

    Spinner facility;
    EditText dateCreated;
    Spinner period;
    EditText name;
    EditText numerator;
    EditText denominator;
    EditText knownHIV;
    EditText positiveHIV;
    EditText negativeHIV;

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
    private StatForm statForm;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat_form_activity);

        Intent intent = getIntent();
        Long statForm_id = intent.getLongExtra(AppUtil.ID, 0);

        facility = (Spinner) findViewById(R.id.facility);
        name = (EditText) findViewById(R.id.name);
        period = (Spinner) findViewById(R.id.period);
        numerator = (EditText) findViewById(R.id.numerator);
        denominator = (EditText) findViewById(R.id.denominator);
        knownHIV = (EditText) findViewById(R.id.knownHIV);
        positiveHIV = (EditText) findViewById(R.id.positiveHIV);
        negativeHIV = (EditText) findViewById(R.id.negativeHIV);
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

        if (statForm_id != 0) {
            statForm = StatForm.get(statForm_id);
            name.setText(statForm.name);

            numerator.setText(AppUtil.getLongValue(statForm.numerator));
            denominator.setText(AppUtil.getLongValue(statForm.denominator));
            knownHIV.setText(AppUtil.getLongValue(statForm.knownHIV));
            positiveHIV.setText(AppUtil.getLongValue(statForm.positiveHIV));
            negativeHIV.setText(AppUtil.getLongValue(statForm.negativeHIV));

            maleLessThanOne.setText(AppUtil.getLongValue(statForm.maleLessThanOne));
            femaleLessThanOne.setText(AppUtil.getLongValue(statForm.femaleLessThanOne));
            maleOneToFour.setText(AppUtil.getLongValue(statForm.maleOneToFour));
            femaleOneToFour.setText(AppUtil.getLongValue(statForm.femaleOneToFour));
            maleFiveToNine.setText(AppUtil.getLongValue(statForm.maleFiveToNine));
            femaleFiveToNine.setText(AppUtil.getLongValue(statForm.femaleFiveToNine));
            maleTenToFourteen.setText(AppUtil.getLongValue(statForm.maleTenToFourteen));
            femaleTenToFourteen.setText(AppUtil.getLongValue(statForm.femaleTenToFourteen));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(statForm.maleFifteenToNineteen));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(statForm.femaleFifteenToNineteen));
            maleTwentyPlus.setText(AppUtil.getLongValue(statForm.maleTwentyPlus));
            femaleTwentyPlus.setText(AppUtil.getLongValue(statForm.femaleTwentyPlus));

            updateLabel(statForm.dateCreated);

            int i = 0;
            for (Facility s : Facility.getAll()) {
                if (statForm.facility.equals(facility.getItemAtPosition(i))) {
                    facility.setSelection(i);
                    break;
                }
                i++;
            }

            i = 0;
            for (Period s : Period.getAll()) {
                if (statForm.period.equals(period.getItemAtPosition(i))) {
                    period.setSelection(i);
                    break;
                }
                i++;
            }

            setSupportActionBar(createToolBar("TB_STAT Update"));
        } else {
            statForm = new StatForm();
            setSupportActionBar(createToolBar("TB_STAT"));
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

        if (statForm.serverId != null) {
            btn_save.setVisibility(View.GONE);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == btn_save.getId()) {
            if (validate()) {
                statForm.facility = (Facility) facility.getSelectedItem();
                statForm.name = name.getText().toString();
                statForm.period = (Period) period.getSelectedItem();
                statForm.numerator=AppUtil.getLongValue(numerator.getText().toString());
                statForm.denominator=AppUtil.getLongValue(denominator.getText().toString());
               
                statForm.knownHIV = AppUtil.getLongValue(knownHIV.getText().toString());
                statForm.positiveHIV = AppUtil.getLongValue(positiveHIV.getText().toString());
                statForm.negativeHIV = AppUtil.getLongValue(negativeHIV.getText().toString());
                statForm.dateCreated = AppUtil.getDate(dateCreated.getText().toString());

                statForm.maleLessThanOne = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                statForm.femaleLessThanOne = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                statForm.maleOneToFour = AppUtil.getLongValue(maleOneToFour.getText().toString());
                statForm.femaleOneToFour = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                statForm.maleFiveToNine = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                statForm.femaleFiveToNine = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                statForm.maleTenToFourteen = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                statForm.femaleTenToFourteen = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                statForm.maleFifteenToNineteen = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                statForm.femaleFifteenToNineteen = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                statForm.maleTwentyPlus = AppUtil.getLongValue(maleTwentyPlus.getText().toString());
                statForm.femaleTwentyPlus = AppUtil.getLongValue(femaleTwentyPlus.getText().toString());


                statForm.save();
                intent = new Intent(this, StatFormListActivity.class);
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

        name = denominator.getText().toString().toString();

        if (name.isEmpty()) {
            denominator.setError("Required");
            valid = false;
        } else {
            denominator.setError(null);
        }

        name = dateCreated.getText().toString().toString();

        if (name.isEmpty()) {
            dateCreated.setError("Required");
            valid = false;
        } else {
            dateCreated.setError(null);
        }

        return valid;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(context)
                .setMessage("Are you sure you want to cancel?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (validate()) {
                            finish();
                        }
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }



}
