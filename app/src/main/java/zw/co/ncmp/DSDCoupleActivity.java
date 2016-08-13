package zw.co.ncmp;

import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import zw.co.ncmp.business.DSDCouple;
import zw.co.ncmp.business.Facility;
import zw.co.ncmp.business.Period;
import zw.co.ncmp.util.AppUtil;

public class DSDCoupleActivity extends MenuBar implements View.OnClickListener {

    private DSDCouple dsdCouple;

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

    Button btn_save;
    Button btn_completed;
    Button btn_submit;

    Button btn_question_one;
    Button btn_question_two;
    Button btn_question_three;

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsd_couple_activity);

        Intent intent = getIntent();
        Long dsdCouple_id = intent.getLongExtra(AppUtil.ID, 0);

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

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                updateLabel(newDate.getTime());
            }

        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        dateCreated = (EditText) findViewById(R.id.dateCreated);
        dateCreated.setOnClickListener(this);

        if (dsdCouple_id != 0) {
            dsdCouple = DSDCouple.get(dsdCouple_id);

            testedFHS.setText(AppUtil.getLongValue(dsdCouple.testedFHS));
            positiveTestedFHS.setText(AppUtil.getLongValue(dsdCouple.positiveTestedFHS));
            testedOPD.setText(AppUtil.getLongValue(dsdCouple.testedOPD));
            positiveTestedOPD.setText(AppUtil.getLongValue(dsdCouple.positiveTestedOPD));
            testedOutreach.setText(AppUtil.getLongValue(dsdCouple.testedOutreach));
            positiveTestedOutreach.setText(AppUtil.getLongValue(dsdCouple.positiveTestedOutreach));
            testedMaternity.setText(AppUtil.getLongValue(dsdCouple.testedMaternity));
            positiveTestedMaternity.setText(AppUtil.getLongValue(dsdCouple.positiveTestedMaternity));
            testedANC.setText(AppUtil.getLongValue(dsdCouple.testedANC));
            positiveTestedANC.setText(AppUtil.getLongValue(dsdCouple.positiveTestedANC));

            updateLabel(dsdCouple.dateCreated);

            int i = 0;
            for (Facility s : Facility.getAll()) {
                if (dsdCouple.facility.equals(facility.getItemAtPosition(i))) {
                    facility.setSelection(i);
                    break;
                }
                i++;
            }

            i = 0;
            for (Period s : Period.getAll()) {
                if (dsdCouple.period.equals(period.getItemAtPosition(i))) {
                    period.setSelection(i);
                    break;
                }
                i++;
            }

            setSupportActionBar(createToolBar("HTC_TST: DSD- Couples"));
        } else {
            dsdCouple = new DSDCouple();
            setSupportActionBar(createToolBar("HTC_TST: DSD- Couples"));
        }

        ArrayAdapter<Facility> facilityArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Facility.getAll());
        facilityArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facility.setAdapter(facilityArrayAdapter);

        ArrayAdapter<Period> periodArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Period.getAll());
        periodArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        period.setAdapter(periodArrayAdapter);

        btn_question_one = (Button) findViewById(R.id.btn_question_one);
        btn_question_one.setOnClickListener(this);
        btn_question_one.setText(R.string.dsd_couple_question_one);

        btn_question_two = (Button) findViewById(R.id.btn_question_two);
        btn_question_two.setOnClickListener(this);
        btn_question_two.setText(R.string.dsd_couple_question_two);

        btn_question_three = (Button) findViewById(R.id.btn_question_three);
        btn_question_three.setOnClickListener(this);
        btn_question_three.setText(R.string.dsd_couple_question_three);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        btn_save.setBackgroundResource(R.drawable.finish_background);

        btn_completed = (Button) findViewById(R.id.btn_completed);
        btn_completed.setVisibility(View.GONE);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        btn_submit.setVisibility(View.GONE);
        btn_submit.setBackgroundResource(R.drawable.finish_background);

        if (dsdCouple.dateCreated != null) {
            btn_submit.setVisibility(View.VISIBLE);
        }

        if (dsdCouple.dateSubmitted != null) {
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

        if (v.getId() == btn_save.getId()) {
            if (validate()) {
                dsdCouple.facility = (Facility) facility.getSelectedItem();
                dsdCouple.period = (Period) period.getSelectedItem();
                dsdCouple.dateCreated = AppUtil.getDate(dateCreated.getText().toString());

                dsdCouple.testedFHS = AppUtil.getLongValue(testedFHS.getText().toString());
                dsdCouple.positiveTestedFHS = AppUtil.getLongValue(positiveTestedFHS.getText().toString());
                dsdCouple.testedOPD = AppUtil.getLongValue(testedOPD.getText().toString());
                dsdCouple.positiveTestedOPD = AppUtil.getLongValue(positiveTestedOPD.getText().toString());
                dsdCouple.testedOutreach = AppUtil.getLongValue(testedOutreach.getText().toString());
                dsdCouple.positiveTestedOutreach = AppUtil.getLongValue(positiveTestedOutreach.getText().toString());
                dsdCouple.testedMaternity = AppUtil.getLongValue(testedMaternity.getText().toString());
                dsdCouple.positiveTestedMaternity = AppUtil.getLongValue(positiveTestedMaternity.getText().toString());
                dsdCouple.testedANC = AppUtil.getLongValue(testedANC.getText().toString());
                dsdCouple.positiveTestedANC = AppUtil.getLongValue(positiveTestedANC.getText().toString());

                dsdCouple.save();
                btn_submit.setVisibility(View.VISIBLE);
                AppUtil.createShortNotification(DSDCoupleActivity.this, "Saved");
            } else {
                return;
            }
        }

        if (v.getId() == btn_submit.getId()) {
            new AlertDialog.Builder(context)
                    .setMessage("Are you sure you want to submit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            if (validate()) {
                                dsdCouple.dateSubmitted = new Date();
                                dsdCouple.save();
                                btn_completed.setVisibility(View.VISIBLE);
                                btn_submit.setVisibility(View.GONE);
                                btn_save.setVisibility(View.GONE);
                                btn_completed.setVisibility(View.VISIBLE);
                                AppUtil.createLongNotification(DSDCoupleActivity.this, "Submitted for Upload to Server");
                            }
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();

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
                .setMessage("Are you sure you want to cancel?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void questionOne() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dsd_question_activity);
        dialog.setTitle(R.string.dsd_indvidual_question_one);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_one);

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

        if (dsdCouple != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdCouple.maleLessThanOne1));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdCouple.femaleLessThanOne1));
            maleOneToFour.setText(AppUtil.getLongValue(dsdCouple.maleOneToFour1));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdCouple.femaleOneToFour1));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdCouple.maleFiveToNine1));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdCouple.femaleOneToFour1));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdCouple.maleTenToFourteen1));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdCouple.femaleTenToFourteen1));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdCouple.maleFifteenToNineteen1));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdCouple.femaleFifteenToNineteen1));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdCouple.maleTwentyToTwentyFour1));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdCouple.femaleTwentyToTwentyFour1));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdCouple.maleTwentyFiveToFortyNine1));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdCouple.femaleTwentyFiveToFortyNine1));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdCouple.maleFiftyPlus1));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdCouple.femaleFiftyPlus1));
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdCouple.maleLessThanOne1 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdCouple.femaleLessThanOne1 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdCouple.maleOneToFour1 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdCouple.femaleOneToFour1 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdCouple.maleFiveToNine1 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdCouple.femaleFiveToNine1 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdCouple.maleTenToFourteen1 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdCouple.femaleTenToFourteen1 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdCouple.maleFifteenToNineteen1 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdCouple.femaleFifteenToNineteen1 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdCouple.maleTwentyToTwentyFour1 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdCouple.femaleTwentyToTwentyFour1 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdCouple.maleTwentyFiveToFortyNine1 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdCouple.femaleTwentyFiveToFortyNine1 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdCouple.maleFiftyPlus1 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdCouple.femaleFiftyPlus1 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                dialog.dismiss();
            }
        });

        Button cancelButton = (Button) dialog.findViewById(R.id.btn_back);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

    public void questionTwo() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dsd_question_activity);
        dialog.setTitle(R.string.dsd_indvidual_question_two);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_two);

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

        if (dsdCouple != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdCouple.maleLessThanOne2));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdCouple.femaleLessThanOne2));
            maleOneToFour.setText(AppUtil.getLongValue(dsdCouple.maleOneToFour2));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdCouple.femaleOneToFour2));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdCouple.maleFiveToNine2));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdCouple.femaleOneToFour2));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdCouple.maleTenToFourteen2));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdCouple.femaleTenToFourteen2));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdCouple.maleFifteenToNineteen2));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdCouple.femaleFifteenToNineteen2));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdCouple.maleTwentyToTwentyFour2));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdCouple.femaleTwentyToTwentyFour2));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdCouple.maleTwentyFiveToFortyNine2));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdCouple.femaleTwentyFiveToFortyNine2));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdCouple.maleFiftyPlus2));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdCouple.femaleFiftyPlus2));
        }


        Button saveButton = (Button) dialog.findViewById(R.id.btn_next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdCouple.maleLessThanOne2 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdCouple.femaleLessThanOne2 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdCouple.maleOneToFour2 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdCouple.femaleOneToFour2 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdCouple.maleFiveToNine2 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdCouple.femaleFiveToNine2 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdCouple.maleTenToFourteen2 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdCouple.femaleTenToFourteen2 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdCouple.maleFifteenToNineteen2 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdCouple.femaleFifteenToNineteen2 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdCouple.maleTwentyToTwentyFour2 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdCouple.femaleTwentyToTwentyFour2 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdCouple.maleTwentyFiveToFortyNine2 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdCouple.femaleTwentyFiveToFortyNine2 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdCouple.maleFiftyPlus2 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdCouple.femaleFiftyPlus2 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                dialog.dismiss();
            }
        });

        Button cancelButton = (Button) dialog.findViewById(R.id.btn_back);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();


    }

    public void questionThree() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dsd_question_activity);
        dialog.setTitle(R.string.dsd_indvidual_question_three);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_three);

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

        if (dsdCouple != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(dsdCouple.maleLessThanOne3));
            femaleLessThanOne.setText(AppUtil.getLongValue(dsdCouple.femaleLessThanOne3));
            maleOneToFour.setText(AppUtil.getLongValue(dsdCouple.maleOneToFour3));
            femaleOneToFour.setText(AppUtil.getLongValue(dsdCouple.femaleOneToFour3));
            maleFiveToNine.setText(AppUtil.getLongValue(dsdCouple.maleFiveToNine3));
            femaleFiveToNine.setText(AppUtil.getLongValue(dsdCouple.femaleOneToFour3));
            maleTenToFourteen.setText(AppUtil.getLongValue(dsdCouple.maleTenToFourteen3));
            femaleTenToFourteen.setText(AppUtil.getLongValue(dsdCouple.femaleTenToFourteen3));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(dsdCouple.maleFifteenToNineteen3));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(dsdCouple.femaleFifteenToNineteen3));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdCouple.maleTwentyToTwentyFour3));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(dsdCouple.femaleTwentyToTwentyFour3));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdCouple.maleTwentyFiveToFortyNine3));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(dsdCouple.femaleTwentyFiveToFortyNine3));
            maleFiftyPlus.setText(AppUtil.getLongValue(dsdCouple.maleFiftyPlus3));
            femaleFiftyPlus.setText(AppUtil.getLongValue(dsdCouple.femaleFiftyPlus3));
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                dsdCouple.maleLessThanOne3 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                dsdCouple.femaleLessThanOne3 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                dsdCouple.maleOneToFour3 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                dsdCouple.femaleOneToFour3 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                dsdCouple.maleFiveToNine3 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                dsdCouple.femaleFiveToNine3 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                dsdCouple.maleTenToFourteen3 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                dsdCouple.femaleTenToFourteen3 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                dsdCouple.maleFifteenToNineteen3 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                dsdCouple.femaleFifteenToNineteen3 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                dsdCouple.maleTwentyToTwentyFour3 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                dsdCouple.femaleTwentyToTwentyFour3 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                dsdCouple.maleTwentyFiveToFortyNine3 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                dsdCouple.femaleTwentyFiveToFortyNine3 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                dsdCouple.maleFiftyPlus3 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                dsdCouple.femaleFiftyPlus3 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                dialog.dismiss();
            }
        });

        Button cancelButton = (Button) dialog.findViewById(R.id.btn_back);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

    }

}

