package zw.co.ncmp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import zw.co.ncmp.business.DSDIndividual;
import zw.co.ncmp.business.Facility;
import zw.co.ncmp.business.Period;
import zw.co.ncmp.util.AppUtil;

public class DSDIndividualActivity extends MenuBar implements View.OnClickListener {

    private DSDIndividual dsdIndividual;

    Spinner facility;
    Spinner period;
    EditText dateCreated;

    EditText testedFHS;
    EditText positiveTestedFHS;
    EditText testedOPD;
    EditText positiveTestedOPD;
    EditText testedOutreach;
    EditText positiveTestedOutreach;
    EditText testedMaternity;
    EditText positiveTestedMaternity;
    EditText testedANC;
    EditText positiveTestedANC;
    EditText name;

    Button btn_save;
    Button btn_completed;
    Button btn_submit;

    Button btn_question_one;
    Button btn_question_two;
    Button btn_question_three;
    Button btn_question_four;
    Button btn_question_five;
    Button btn_question_six;
    Button btn_question_seven;
    Button btn_question_eight;

    Button btn_dsd;

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsd_individual_activity);

        Intent intent = getIntent();
        Long dsdIndividual_id = intent.getLongExtra(AppUtil.ID, 0);

        facility = (Spinner) findViewById(R.id.facility);

        period = (Spinner) findViewById(R.id.period);
        testedFHS = (EditText) findViewById(R.id.testedFHS);
        positiveTestedFHS = (EditText) findViewById(R.id.positiveTestedFHS);
        testedOPD = (EditText) findViewById(R.id.testedOPD);
        positiveTestedOPD = (EditText) findViewById(R.id.positiveTestedOPD);
        testedOutreach = (EditText) findViewById(R.id.testedOutreach);
        positiveTestedOutreach = (EditText) findViewById(R.id.positiveTestedOutreach);
        testedMaternity = (EditText) findViewById(R.id.testedMaternity);
        positiveTestedMaternity = (EditText) findViewById(R.id.positiveTestedMaternity);
        testedANC = (EditText) findViewById(R.id.testedANC);
        positiveTestedANC = (EditText) findViewById(R.id.positiveTestedANC);
        name = (EditText) findViewById(R.id.name);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                updateLabel(newDate.getTime());
            }

        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        dateCreated = (EditText) findViewById(R.id.dateCreated);
        dateCreated.setOnClickListener(this);

        ArrayAdapter<Facility> facilityArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Facility.getAll());
        facilityArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facility.setAdapter(facilityArrayAdapter);

        ArrayAdapter<Period> periodArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Period.getAll());
        periodArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        period.setAdapter(periodArrayAdapter);

        if (dsdIndividual_id != 0) {
            dsdIndividual = DSDIndividual.get(dsdIndividual_id);

            name.setText(dsdIndividual.name);
            testedFHS.setText(AppUtil.getLongValue(dsdIndividual.testedFHS));
            positiveTestedFHS.setText(AppUtil.getLongValue(dsdIndividual.positiveTestedFHS));
            testedOPD.setText(AppUtil.getLongValue(dsdIndividual.testedOPD));
            positiveTestedOPD.setText(AppUtil.getLongValue(dsdIndividual.positiveTestedOPD));
            testedOutreach.setText(AppUtil.getLongValue(dsdIndividual.testedOutreach));
            positiveTestedOutreach.setText(AppUtil.getLongValue(dsdIndividual.positiveTestedOutreach));
            testedMaternity.setText(AppUtil.getLongValue(dsdIndividual.testedMaternity));
            positiveTestedMaternity.setText(AppUtil.getLongValue(dsdIndividual.positiveTestedMaternity));
            testedANC.setText(AppUtil.getLongValue(dsdIndividual.testedANC));
            positiveTestedANC.setText(AppUtil.getLongValue(dsdIndividual.positiveTestedANC));

            updateLabel(dsdIndividual.dateCreated);

            int i = 0;
            for (Facility s : Facility.getAll()) {
                if (dsdIndividual.facility.equals(facility.getItemAtPosition(i))) {
                    facility.setSelection(i);
                    break;
                }
                i++;
            }

            i = 0;
            for (Period s : Period.getAll()) {
                if (dsdIndividual.period.equals(period.getItemAtPosition(i))) {
                    period.setSelection(i);
                    break;
                }
                i++;
            }

            setSupportActionBar(createToolBar("HTC_TST: DSD- Individuals"));
        } else {
            dsdIndividual = new DSDIndividual();
            setSupportActionBar(createToolBar("HTC_TST: DSD- Individuals"));
        }


        btn_question_one = (Button) findViewById(R.id.btn_question_one);
        btn_question_one.setOnClickListener(this);
        btn_question_one.setText(R.string.dsd_indvidual_question_one);

        btn_question_two = (Button) findViewById(R.id.btn_question_two);
        btn_question_two.setOnClickListener(this);
        btn_question_two.setText(R.string.dsd_indvidual_question_two);

        btn_question_three = (Button) findViewById(R.id.btn_question_three);
        btn_question_three.setOnClickListener(this);
        btn_question_three.setText(R.string.dsd_indvidual_question_three);

        btn_question_four = (Button) findViewById(R.id.btn_question_four);
        btn_question_four.setOnClickListener(this);
        btn_question_four.setText(R.string.dsd_indvidual_question_four);
        btn_question_four.setVisibility(View.GONE);

        btn_question_five = (Button) findViewById(R.id.btn_question_five);
        btn_question_five.setOnClickListener(this);
        btn_question_five.setText(R.string.dsd_indvidual_question_five);

        btn_question_six = (Button) findViewById(R.id.btn_question_six);
        btn_question_six.setOnClickListener(this);
        btn_question_six.setText(R.string.dsd_indvidual_question_six);

        btn_question_seven = (Button) findViewById(R.id.btn_question_seven);
        btn_question_seven.setOnClickListener(this);
        btn_question_seven.setText(R.string.dsd_indvidual_question_seven);

        btn_question_eight = (Button) findViewById(R.id.btn_question_eight);
        btn_question_eight.setOnClickListener(this);
        btn_question_eight.setText(R.string.dsd_indvidual_question_eight);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        btn_save.setBackgroundResource(R.drawable.finish_background);

        btn_completed = (Button) findViewById(R.id.btn_completed);
        btn_completed.setVisibility(View.GONE);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        btn_submit.setVisibility(View.GONE);
        btn_submit.setBackgroundResource(R.drawable.finish_background);

        btn_dsd = (Button) findViewById(R.id.btn_dsd);
        btn_dsd.setOnClickListener(this);
        btn_dsd.setVisibility(View.GONE);

        if (dsdIndividual.dateCreated != null) {
            btn_submit.setVisibility(View.VISIBLE);
            btn_dsd.setVisibility(View.VISIBLE);
        }

        if (dsdIndividual.dateSubmitted != null) {
            btn_submit.setVisibility(View.GONE);
            btn_save.setVisibility(View.GONE);
            btn_completed.setVisibility(View.VISIBLE);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == btn_question_one.getId()) {
            questionOne();
        }

        if (v.getId() == btn_question_two.getId()) {
            questionTwo();
        }

        if (v.getId() == btn_question_three.getId()) {
            questionThree();
        }

        if (v.getId() == btn_question_four.getId()) {
            questionFour();
        }

        if (v.getId() == btn_question_five.getId()) {
            questionFive();
        }

        if (v.getId() == btn_question_six.getId()) {
            questionSix();
        }

        if (v.getId() == btn_question_seven.getId()) {
            questionSeven();
        }

        if (v.getId() == btn_question_eight.getId()) {
            questionEight();
        }

        if (v.getId() == btn_dsd.getId()) {
            Intent intent = new Intent(DSDIndividualActivity.this, DSDCoupleActivity.class);
            intent.putExtra(AppUtil.DSD_ID, dsdIndividual.getId());
            startActivity(intent);
            finish();
        }

        if (v.getId() == btn_save.getId()) {
            if (validate()) {
                dsdIndividual.facility = (Facility) facility.getSelectedItem();
                dsdIndividual.period = (Period) period.getSelectedItem();
                dsdIndividual.dateCreated = AppUtil.getDate(dateCreated.getText().toString());
                dsdIndividual.name = name.getText().toString();
                dsdIndividual.testedFHS = AppUtil.getLongValue(testedFHS.getText().toString());
                dsdIndividual.positiveTestedFHS = AppUtil.getLongValue(positiveTestedFHS.getText().toString());
                dsdIndividual.testedOPD = AppUtil.getLongValue(testedOPD.getText().toString());
                dsdIndividual.positiveTestedOPD = AppUtil.getLongValue(positiveTestedOPD.getText().toString());
                dsdIndividual.testedOutreach = AppUtil.getLongValue(testedOutreach.getText().toString());
                dsdIndividual.positiveTestedOutreach = AppUtil.getLongValue(positiveTestedOutreach.getText().toString());
                dsdIndividual.testedMaternity = AppUtil.getLongValue(testedMaternity.getText().toString());
                dsdIndividual.positiveTestedMaternity = AppUtil.getLongValue(positiveTestedMaternity.getText().toString());
                dsdIndividual.testedANC = AppUtil.getLongValue(testedANC.getText().toString());
                dsdIndividual.positiveTestedANC = AppUtil.getLongValue(positiveTestedANC.getText().toString());

                if (dsdIndividual.getId() == null) {
                    DSDIndividual checkDuplicate = DSDIndividual.getDSDIndividual(dsdIndividual.facility.getId(), dsdIndividual.period.getId());
                    if (checkDuplicate == null) {
                        dsdIndividual.save();
                        AppUtil.createShortNotification(DSDIndividualActivity.this, "Saved");
                    } else {
                        AppUtil.createShortNotification(DSDIndividualActivity.this, "Failed to save duplicate Entry Detected");
                    }
                } else {
                    dsdIndividual.save();
                    AppUtil.createShortNotification(DSDIndividualActivity.this, "Saved");
                }
            } else {
                return;
            }
        }

        if (v.getId() == dateCreated.getId()) {
            datePickerDialog.show();

        }

        if (v.getId() == btn_submit.getId()) {
            new AlertDialog.Builder(context)
                    .setMessage("Are you sure you want to submit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (validate()) {
                                dsdIndividual.dateSubmitted = new Date();
                                dsdIndividual.save();
                                AppUtil.createLongNotification(DSDIndividualActivity.this, "Submitted for Upload to Server");
                                Intent intent = new Intent(DSDIndividualActivity.this, DSDIndiviudalListActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

        }
    }

    private void updateLabel(Date date) {
        dateCreated.setText(AppUtil.getStringDate(date));
    }

    public boolean validate() {
        boolean valid = true;

        String name = dateCreated.getText().toString().toString();

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
                .setMessage("Exit Form?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        AppUtil.createLongNotification(DSDIndividualActivity.this, "Submitted for Upload to Server");
                        Intent intent = new Intent(DSDIndividualActivity.this, DSDIndiviudalListActivity.class);
                        startActivity(intent);
                        finish();

                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void questionOne() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_one);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion1()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion1()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne1));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne1));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour1));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour1));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine1));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour1));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen1));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen1));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen1));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen1));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour1));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour1));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine1));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine1));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus1));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus1));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne1 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour1 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine1 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen1 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen1 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour1 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine1 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus1 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion1()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne1 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour1 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine1 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen1 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen1 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour1 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine1 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus1 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion1()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne1 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne1 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour1 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour1 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine1 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine1 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen1 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen1 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen1 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen1 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour1 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour1 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine1 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine1 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus1 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus1 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionTwo() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_two);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion2()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion2()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne2));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne2));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour2));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour2));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine2));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour2));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen2));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen2));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen2));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen2));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour2));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour2));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine2));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine2));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus2));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus2));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne2 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour2 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine2 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen2 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen2 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour2 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine2 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus2 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion2()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne2 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour2 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine2 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen2 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen2 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour2 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine2 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus2 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion2()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne2 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne2 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour2 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour2 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine2 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine2 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen2 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen2 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen2 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen2 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour2 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour2 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine2 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine2 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus2 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus2 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionThree() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_three);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion3()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion3()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne3));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne3));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour3));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour3));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine3));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour3));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen3));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen3));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen3));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen3));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour3));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour3));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine3));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine3));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus3));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus3));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne3 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour3 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine3 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen3 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen3 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour3 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine3 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus3 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion3()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne3 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour3 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine3 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen3 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen3 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour3 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine3 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus3 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion3()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne3 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne3 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour3 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour3 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine3 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine3 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen3 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen3 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen3 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen3 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour3 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour3 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine3 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine3 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus3 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus3 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionFour() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_four);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion4()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion4()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne4));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne4));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour4));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour4));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine4));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour4));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen4));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen4));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen4));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen4));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour4));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour4));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine4));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine4));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus4));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus4));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne4 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour4 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine4 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen4 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen4 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour4 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine4 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus4 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion4()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne4 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour4 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine4 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen4 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen4 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour4 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine4 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus4 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion4()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne4 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne4 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour4 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour4 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine4 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine4 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen4 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen4 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen4 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen4 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour4 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour4 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine4 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine4 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus4 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus4 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionFive() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_five);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion5()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion5()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne5));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne5));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour5));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour5));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine5));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour5));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen5));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen5));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen5));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen5));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour5));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour5));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine5));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine5));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus5));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus5));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne5 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour5 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine5 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen5 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen5 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour5 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine5 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus5 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion5()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne5 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour5 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine5 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen5 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen5 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour5 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine5 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus5 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion5()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne5 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne5 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour5 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour5 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine5 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine5 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen5 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen5 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen5 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen5 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour5 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour5 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine5 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine5 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus5 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus5 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionSix() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_six);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion6()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion6()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne6));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne6));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour6));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour6));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine6));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour6));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen6));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen6));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen6));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen6));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour6));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour6));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine6));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine6));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus6));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus6));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne6 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour6 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine6 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen6 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen6 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour6 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine6 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus6 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion6()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne6 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour6 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine6 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen6 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen6 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour6 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine6 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus6 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion6()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne6 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne6 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour6 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour6 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine6 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine6 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen6 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen6 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen6 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen6 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour6 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour6 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine6 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine6 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus6 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus6 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionSeven() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_seven);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion7()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion7()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne7));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne7));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour7));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour7));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine7));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour7));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen7));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen7));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen7));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen7));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour7));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour7));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine7));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine7));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus7));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus7));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne7 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour7 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine7 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen7 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen7 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour7 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine7 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus7 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion7()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne7 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour7 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine7 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen7 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen7 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour7 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine7 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus7 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion7()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne7 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne7 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour7 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour7 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine7 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine7 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen7 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen7 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen7 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen7 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour7 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour7 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine7 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine7 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus7 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus7 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionEight() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dsd_question_activity);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_eight);

        final TextView maleTotal = (TextView) dialog.findViewById(R.id.maleTotal);
        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion8()));

        final TextView femaleTotal = (TextView) dialog.findViewById(R.id.femaleTotal);
        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion8()));

        final EditText maleLessThanOne = (EditText) dialog.findViewById(R.id.maleLessThanOne);
        final EditText femaleLessThanOne = (EditText) dialog.findViewById(R.id.femaleLessThanOne);
        final EditText maleOneToFour = (EditText) dialog.findViewById(R.id.maleOneToFour);
        final EditText femaleOneToFour = (EditText) dialog.findViewById(R.id.femaleOneToFour);
        final EditText maleFiveToNine = (EditText) dialog.findViewById(R.id.maleFiveToNine);
        final EditText femaleFiveToNine = (EditText) dialog.findViewById(R.id.femaleFiveToNine);
        final EditText maleTenToFourteen = (EditText) dialog.findViewById(R.id.maleTenToFourteen);
        final EditText femaleTenToFourteen = (EditText) dialog.findViewById(R.id.femaleTenToFourteen);
        final EditText maleFifteenToNineteen = (EditText) dialog.findViewById(R.id.maleFifteenToNineteen);
        final EditText femaleFifteenToNineteen = (EditText) dialog.findViewById(R.id.femaleFifteenToNineteen);
        final EditText maleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.maleTwentyToTwentyFour);
        final EditText femaleTwentyToTwentyFour = (EditText) dialog.findViewById(R.id.femaleTwentyToTwentyFour);
        final EditText maleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.maleTwentyFiveToFortyNine);
        final EditText femaleTwentyFiveToFortyNine = (EditText) dialog.findViewById(R.id.femaleTwentyFiveToFortyNine);
        final EditText maleFiftyPlus = (EditText) dialog.findViewById(R.id.maleFiftyPlus);
        final EditText femaleFiftyPlus = (EditText) dialog.findViewById(R.id.femaleFiftyPlus);

        if (dsdIndividual != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.maleLessThanOne8));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdIndividual.femaleLessThanOne8));
            maleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.maleOneToFour8));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour8));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.maleFiveToNine8));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdIndividual.femaleOneToFour8));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.maleTenToFourteen8));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdIndividual.femaleTenToFourteen8));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.maleFifteenToNineteen8));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdIndividual.femaleFifteenToNineteen8));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyToTwentyFour8));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyToTwentyFour8));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.maleTwentyFiveToFortyNine8));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdIndividual.femaleTwentyFiveToFortyNine8));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.maleFiftyPlus8));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdIndividual.femaleFiftyPlus8));
        }

        List<EditText> list = new ArrayList<>();
        list.add(maleLessThanOne);
        list.add(maleOneToFour);
        list.add(maleFiveToNine);
        list.add(maleTenToFourteen);
        list.add(maleFifteenToNineteen);
        list.add(maleTwentyToTwentyFour);
        list.add(maleTwentyFiveToFortyNine);
        list.add(maleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.maleLessThanOne8 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                        dsdIndividual.maleOneToFour8 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                        dsdIndividual.maleFiveToNine8 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                        dsdIndividual.maleTenToFourteen8 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                        dsdIndividual.maleFifteenToNineteen8 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                        dsdIndividual.maleTwentyToTwentyFour8 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.maleTwentyFiveToFortyNine8 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.maleFiftyPlus8 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());

                        maleTotal.setText(AppUtil.getLongValue(dsdIndividual.maleQuestion8()));
                    }

                }
            });
        }

        list = new ArrayList<>();
        list.add(femaleLessThanOne);
        list.add(femaleOneToFour);
        list.add(femaleFiveToNine);
        list.add(femaleTenToFourteen);
        list.add(femaleFifteenToNineteen);
        list.add(femaleTwentyToTwentyFour);
        list.add(femaleTwentyFiveToFortyNine);
        list.add(femaleFiftyPlus);

        for (EditText editText : list) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {

                        dsdIndividual.femaleLessThanOne8 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());
                        dsdIndividual.femaleOneToFour8 = AppUtil.getLongValue(femaleOneToFour.getText().toString());
                        dsdIndividual.femaleFiveToNine8 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());
                        dsdIndividual.femaleTenToFourteen8 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());
                        dsdIndividual.femaleFifteenToNineteen8 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());
                        dsdIndividual.femaleTwentyToTwentyFour8 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());
                        dsdIndividual.femaleTwentyFiveToFortyNine8 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());
                        dsdIndividual.femaleFiftyPlus8 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                        femaleTotal.setText(AppUtil.getLongValue(dsdIndividual.femaleQuestion8()));
                    }

                }
            });
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdIndividual.maleLessThanOne8 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdIndividual.femaleLessThanOne8 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdIndividual.maleOneToFour8 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdIndividual.femaleOneToFour8 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdIndividual.maleFiveToNine8 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdIndividual.femaleFiveToNine8 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdIndividual.maleTenToFourteen8 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdIndividual.femaleTenToFourteen8 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdIndividual.maleFifteenToNineteen8 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdIndividual.femaleFifteenToNineteen8 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdIndividual.maleTwentyToTwentyFour8 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdIndividual.femaleTwentyToTwentyFour8 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdIndividual.maleTwentyFiveToFortyNine8 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdIndividual.femaleTwentyFiveToFortyNine8 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdIndividual.maleFiftyPlus8 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdIndividual.femaleFiftyPlus8 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                upDateForm();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void upDateForm() {

        btn_question_one.setText(this.getString(R.string.dsd_indvidual_question_one)
                + " [ " + (dsdIndividual.maleQuestion1() + dsdIndividual.femaleQuestion1()) + " ]");

        btn_question_two.setText(this.getString(R.string.dsd_indvidual_question_two)
                + " [ " + (dsdIndividual.maleQuestion2() + dsdIndividual.femaleQuestion2()) + " ]");

        btn_question_three.setText(this.getString(R.string.dsd_indvidual_question_three)
                + " [ " + (dsdIndividual.maleQuestion3() + dsdIndividual.femaleQuestion3()) + " ]");

        btn_question_four.setText(this.getString(R.string.dsd_indvidual_question_four)
                + " [ " + (dsdIndividual.maleQuestion3() + dsdIndividual.femaleQuestion4()) + " ]");

        btn_question_five.setText(this.getString(R.string.dsd_indvidual_question_five)
                + " [ " + (dsdIndividual.maleQuestion5() + dsdIndividual.femaleQuestion5()) + " ]");

        btn_question_six.setText(this.getString(R.string.dsd_indvidual_question_six)
                + " [ " + (dsdIndividual.maleQuestion6() + dsdIndividual.femaleQuestion6()) + " ]");

        btn_question_seven.setText(this.getString(R.string.dsd_indvidual_question_seven)
                + " [ " + (dsdIndividual.maleQuestion7() + dsdIndividual.femaleQuestion7()) + " ]");

        btn_question_eight.setText(this.getString(R.string.dsd_indvidual_question_eight)
                + " [ " + (dsdIndividual.maleQuestion8() + dsdIndividual.femaleQuestion8()) + " ]");

    }
}

