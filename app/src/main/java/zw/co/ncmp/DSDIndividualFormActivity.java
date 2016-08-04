package zw.co.ncmp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;

import zw.co.ncmp.business.ARTForm;
import zw.co.ncmp.business.Facility;
import zw.co.ncmp.business.Period;
import zw.co.ncmp.util.AppUtil;

public class DSDIndividualFormActivity extends MenuBar implements View.OnClickListener {

    Spinner facility;
    Spinner period;
    EditText dateCreated;
    EditText name;
    EditText numerator;
    EditText denominator;
    EditText alreadyOnART;
    EditText newOnART;

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
    private ARTForm artForm;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art_form_activity);

        Intent intent = getIntent();
        Long artForm_id = intent.getLongExtra(AppUtil.ID, 0);

        facility = (Spinner) findViewById(R.id.facility);
        name = (EditText) findViewById(R.id.name);
        period = (Spinner) findViewById(R.id.period);
        numerator = (EditText) findViewById(R.id.numerator);
        denominator = (EditText) findViewById(R.id.denominator);
        alreadyOnART = (EditText) findViewById(R.id.alreadyOnART);
        newOnART = (EditText) findViewById(R.id.newOnART);
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

        if (artForm_id != 0) {
            artForm = ARTForm.get(artForm_id);
            name.setText(artForm.name);
            numerator.setText(String.valueOf(artForm.numerator));
            denominator.setText(String.valueOf(artForm.denominator));
            alreadyOnART.setText(String.valueOf(artForm.alreadyOnART));
            newOnART.setText(String.valueOf(artForm.newOnART));

            maleLessThanOne.setText(String.valueOf(artForm.maleLessThanOne));
            femaleLessThanOne.setText(String.valueOf(artForm.femaleLessThanOne));
            maleOneToFour.setText(String.valueOf(artForm.maleOneToFour));
            femaleOneToFour.setText(String.valueOf(artForm.femaleOneToFour));
            maleFiveToNine.setText(String.valueOf(artForm.maleFiveToNine));
            femaleFiveToNine.setText(String.valueOf(artForm.femaleFiveToNine));
            maleTenToFourteen.setText(String.valueOf(artForm.maleTenToFourteen));
            femaleTenToFourteen.setText(String.valueOf(artForm.femaleTenToFourteen));
            maleFifteenToNineteen.setText(String.valueOf(artForm.maleFifteenToNineteen));
            femaleFifteenToNineteen.setText(String.valueOf(artForm.femaleFifteenToNineteen));
            maleTwentyPlus.setText(String.valueOf(artForm.maleTwentyPlus));
            femaleTwentyPlus.setText(String.valueOf(artForm.femaleTwentyPlus));

            updateLabel(artForm.dateCreated);

            int i = 0;
            for (Facility s : Facility.getAll()) {
                if (artForm.facility.equals(facility.getItemAtPosition(i))) {
                    facility.setSelection(i);
                    break;
                }
                i++;
            }

            i = 0;
            for (Period s : Period.getAll()) {
                if (artForm.period.equals(period.getItemAtPosition(i))) {
                    period.setSelection(i);
                    break;
                }
                i++;
            }

            setSupportActionBar(createToolBar("TB_ART Update"));
        } else {
            artForm = new ARTForm();
            setSupportActionBar(createToolBar("TB_ART"));
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

        if (artForm.serverId != null) {
            btn_save.setVisibility(View.GONE);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == btn_save.getId()) {
            if (validate()) {
                artForm.facility = (Facility) facility.getSelectedItem();
                artForm.name = name.getText().toString();
                artForm.period = (Period) period.getSelectedItem();
                artForm.numerator = AppUtil.getLongValue(numerator.getText().toString());
                artForm.denominator = AppUtil.getLongValue(denominator.getText().toString());
                artForm.alreadyOnART = AppUtil.getLongValue(alreadyOnART.getText().toString());
                artForm.newOnART = AppUtil.getLongValue(newOnART.getText().toString());
                artForm.dateCreated = AppUtil.getDate(dateCreated.getText().toString());

                artForm.maleLessThanOne = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                artForm.femaleLessThanOne = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                artForm.maleOneToFour = AppUtil.getLongValue(maleOneToFour.getText().toString());
                artForm.femaleOneToFour = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                artForm.maleFiveToNine = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                artForm.femaleFiveToNine = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                artForm.maleTenToFourteen = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                artForm.femaleTenToFourteen = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                artForm.maleFifteenToNineteen = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                artForm.femaleFifteenToNineteen = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                artForm.maleTwentyPlus = AppUtil.getLongValue(maleTwentyPlus.getText().toString());
                artForm.femaleTwentyPlus = AppUtil.getLongValue(femaleTwentyPlus.getText().toString());

                artForm.save();
                intent = new Intent(this, ARTFormListActivity.class);
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
        finish();
    }


}

