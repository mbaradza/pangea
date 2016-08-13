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

import zw.co.ncmp.business.Facility;
import zw.co.ncmp.business.Period;
import zw.co.ncmp.business.TXTNew;
import zw.co.ncmp.util.AppUtil;

public class TXTNewActivity extends MenuBar implements View.OnClickListener {

    private TXTNew txtNew;

    Spinner facility;
    Spinner period;
    EditText dateCreated;

    Button btn_save;
    Button btn_completed;
    Button btn_submit;

    Button btn_question_one;
    Button btn_question_two;
    Button btn_question_three;
    Button btn_question_four;

    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.txt_new_form_activity);

        Intent intent = getIntent();
        Long txtNew_id = intent.getLongExtra(AppUtil.ID, 0);

        facility = (Spinner) findViewById(R.id.facility);
        period = (Spinner) findViewById(R.id.period);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                updateLabel(newDate.getTime());
            }

        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        dateCreated = (EditText) findViewById(R.id.dateCreated);
        dateCreated.setOnClickListener(this);

        if (txtNew_id != 0) {
            txtNew = TXTNew.get(txtNew_id);

            updateLabel(txtNew.dateCreated);

            int i = 0;
            for (Facility s : Facility.getAll()) {
                if (txtNew.facility.equals(facility.getItemAtPosition(i))) {
                    facility.setSelection(i);
                    break;
                }
                i++;
            }

            i = 0;
            for (Period s : Period.getAll()) {
                if (txtNew.period.equals(period.getItemAtPosition(i))) {
                    period.setSelection(i);
                    break;
                }
                i++;
            }

            setSupportActionBar(createToolBar("TX_NEW: DSD"));
        } else {
            txtNew = new TXTNew();
            setSupportActionBar(createToolBar("TX_NEW: DSD"));
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
        btn_question_one.setText(R.string.txt_new_question_one);

        btn_question_two = (Button) findViewById(R.id.btn_question_two);
        btn_question_two.setOnClickListener(this);
        btn_question_two.setText(R.string.txt_new_question_two);

        btn_question_three = (Button) findViewById(R.id.btn_question_three);
        btn_question_three.setOnClickListener(this);
        btn_question_three.setText(R.string.txt_new_question_three);

        btn_question_four = (Button) findViewById(R.id.btn_question_four);
        btn_question_four.setOnClickListener(this);
        btn_question_four.setText(R.string.txt_new_question_four);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        btn_save.setBackgroundResource(R.drawable.finish_background);

        btn_completed = (Button) findViewById(R.id.btn_completed);
        btn_completed.setVisibility(View.GONE);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        btn_submit.setVisibility(View.GONE);
        btn_submit.setBackgroundResource(R.drawable.finish_background);

        if (txtNew.dateCreated != null) {
            btn_submit.setVisibility(View.VISIBLE);
        }

        if (txtNew.dateSubmitted != null) {
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

        if (v.getId() == btn_save.getId()) {
            if (validate()) {
                txtNew.facility = (Facility) facility.getSelectedItem();
                txtNew.period = (Period) period.getSelectedItem();
                txtNew.dateCreated = AppUtil.getDate(dateCreated.getText().toString());

                txtNew.save();
                btn_submit.setVisibility(View.VISIBLE);
                AppUtil.createShortNotification(TXTNewActivity.this, "Saved");
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
                                txtNew.dateSubmitted = new Date();
                                txtNew.save();
                                btn_completed.setVisibility(View.VISIBLE);
                                btn_submit.setVisibility(View.GONE);
                                btn_save.setVisibility(View.GONE);
                                AppUtil.createLongNotification(TXTNewActivity.this, "Submitted for Upload to Server");
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
        dialog.getWindow().setBackgroundDrawable(null);
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

        if (txtNew != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(txtNew.maleLessThanOne1));
            femaleLessThanOne.setText(AppUtil.getLongValue(txtNew.femaleLessThanOne1));
            maleOneToFour.setText(AppUtil.getLongValue(txtNew.maleOneToFour1));
            femaleOneToFour.setText(AppUtil.getLongValue(txtNew.femaleOneToFour1));
            maleFiveToNine.setText(AppUtil.getLongValue(txtNew.maleFiveToNine1));
            femaleFiveToNine.setText(AppUtil.getLongValue(txtNew.femaleOneToFour1));
            maleTenToFourteen.setText(AppUtil.getLongValue(txtNew.maleTenToFourteen1));
            femaleTenToFourteen.setText(AppUtil.getLongValue(txtNew.femaleTenToFourteen1));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleFifteenToNineteen1));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.femaleFifteenToNineteen1));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleTwentyToTwentyFour1));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.femaleTwentyToTwentyFour1));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleTwentyFiveToFortyNine1));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.femaleTwentyFiveToFortyNine1));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleFiftyPlus1));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleFiftyPlus1));
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                txtNew.maleLessThanOne1 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                txtNew.femaleLessThanOne1 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                txtNew.maleOneToFour1 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                txtNew.femaleOneToFour1 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                txtNew.maleFiveToNine1 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                txtNew.femaleFiveToNine1 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                txtNew.maleTenToFourteen1 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                txtNew.femaleTenToFourteen2 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                txtNew.maleFifteenToNineteen1 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                txtNew.femaleFifteenToNineteen1 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                txtNew.maleTwentyToTwentyFour1 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                txtNew.femaleTwentyToTwentyFour1 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                txtNew.maleTwentyFiveToFortyNine1 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                txtNew.femaleTwentyFiveToFortyNine1 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                txtNew.maleFiftyPlus1 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                txtNew.femaleFiftyPlus1 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

        Button cancelButton = (Button) dialog.findViewById(R.id.btn_back);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });
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

        if (txtNew != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(txtNew.maleLessThanOne2));
            femaleLessThanOne.setText(AppUtil.getLongValue(txtNew.femaleLessThanOne2));
            maleOneToFour.setText(AppUtil.getLongValue(txtNew.maleOneToFour2));
            femaleOneToFour.setText(AppUtil.getLongValue(txtNew.femaleOneToFour2));
            maleFiveToNine.setText(AppUtil.getLongValue(txtNew.maleFiveToNine2));
            femaleFiveToNine.setText(AppUtil.getLongValue(txtNew.femaleOneToFour2));
            maleTenToFourteen.setText(AppUtil.getLongValue(txtNew.maleTenToFourteen2));
            femaleTenToFourteen.setText(AppUtil.getLongValue(txtNew.femaleTenToFourteen2));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleFifteenToNineteen2));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.femaleFifteenToNineteen2));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(txtNew.maleTwentyToTwentyFour2));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(txtNew.femaleTwentyToTwentyFour2));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(txtNew.maleTwentyFiveToFortyNine2));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(txtNew.femaleTwentyFiveToFortyNine2));
            maleFiftyPlus.setText(AppUtil.getLongValue(txtNew.maleFiftyPlus2));
            femaleFiftyPlus.setText(AppUtil.getLongValue(txtNew.maleFiftyPlus2));
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                txtNew.maleLessThanOne2 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                txtNew.femaleLessThanOne2 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                txtNew.maleOneToFour2 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                txtNew.femaleOneToFour2 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                txtNew.maleFiveToNine2 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                txtNew.femaleFiveToNine2 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                txtNew.maleTenToFourteen2 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                txtNew.femaleTenToFourteen2 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                txtNew.maleFifteenToNineteen2 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                txtNew.femaleFifteenToNineteen2 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                txtNew.maleTwentyToTwentyFour2 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                txtNew.femaleTwentyToTwentyFour2 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                txtNew.maleTwentyFiveToFortyNine2 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                txtNew.femaleTwentyFiveToFortyNine2 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                txtNew.maleFiftyPlus2 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                txtNew.femaleFiftyPlus2 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

                dialog.dismiss();
            }
        });

        dialog.setCancelable(true);
        dialog.show();

        Button cancelButton = (Button) dialog.findViewById(R.id.btn_back);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });
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

        if (txtNew != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(txtNew.maleLessThanOne3));
            femaleLessThanOne.setText(AppUtil.getLongValue(txtNew.femaleLessThanOne3));
            maleOneToFour.setText(AppUtil.getLongValue(txtNew.maleOneToFour3));
            femaleOneToFour.setText(AppUtil.getLongValue(txtNew.femaleOneToFour3));
            maleFiveToNine.setText(AppUtil.getLongValue(txtNew.maleFiveToNine3));
            femaleFiveToNine.setText(AppUtil.getLongValue(txtNew.femaleOneToFour3));
            maleTenToFourteen.setText(AppUtil.getLongValue(txtNew.maleTenToFourteen3));
            femaleTenToFourteen.setText(AppUtil.getLongValue(txtNew.femaleTenToFourteen3));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleFifteenToNineteen3));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.femaleFifteenToNineteen3));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(txtNew.maleTwentyToTwentyFour3));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(txtNew.femaleTwentyToTwentyFour3));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(txtNew.maleTwentyFiveToFortyNine3));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(txtNew.femaleTwentyFiveToFortyNine3));
            maleFiftyPlus.setText(AppUtil.getLongValue(txtNew.maleFiftyPlus3));
            femaleFiftyPlus.setText(AppUtil.getLongValue(txtNew.femaleFiftyPlus3));
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                txtNew.maleLessThanOne3 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                txtNew.femaleLessThanOne3 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                txtNew.maleOneToFour3 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                txtNew.femaleOneToFour3 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                txtNew.maleFiveToNine3 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                txtNew.femaleFiveToNine3 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                txtNew.maleTenToFourteen3 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                txtNew.femaleTenToFourteen3 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                txtNew.maleFifteenToNineteen3 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                txtNew.femaleFifteenToNineteen3 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                txtNew.maleTwentyToTwentyFour3 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                txtNew.femaleTwentyToTwentyFour3 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                txtNew.maleTwentyFiveToFortyNine3 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                txtNew.femaleTwentyFiveToFortyNine3 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                txtNew.maleFiftyPlus3 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                txtNew.femaleFiftyPlus3 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

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

    public void questionFour() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dsd_question_activity);
        dialog.setTitle(R.string.dsd_indvidual_question_four);

        TextView txt_name = (TextView) dialog.findViewById(R.id.txt_name);
        txt_name.setText(R.string.dsd_indvidual_question_four);

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

        if (txtNew != null) {
            maleLessThanOne.setText(AppUtil.getLongValue(txtNew.maleLessThanOne4));
            femaleLessThanOne.setText(AppUtil.getLongValue(txtNew.femaleLessThanOne4));
            maleOneToFour.setText(AppUtil.getLongValue(txtNew.maleOneToFour4));
            femaleOneToFour.setText(AppUtil.getLongValue(txtNew.femaleOneToFour4));
            maleFiveToNine.setText(AppUtil.getLongValue(txtNew.maleFiveToNine4));
            femaleFiveToNine.setText(AppUtil.getLongValue(txtNew.femaleOneToFour4));
            maleTenToFourteen.setText(AppUtil.getLongValue(txtNew.maleTenToFourteen4));
            femaleTenToFourteen.setText(AppUtil.getLongValue(txtNew.femaleTenToFourteen4));
            maleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.maleFifteenToNineteen4));
            femaleFifteenToNineteen.setText(AppUtil.getLongValue(txtNew.femaleFifteenToNineteen4));
            maleTwentyToTwentyFour.setText(AppUtil.getLongValue(txtNew.maleTwentyToTwentyFour4));
            femaleTwentyToTwentyFour.setText(AppUtil.getLongValue(txtNew.femaleTwentyToTwentyFour4));
            maleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(txtNew.maleTwentyFiveToFortyNine4));
            femaleTwentyFiveToFortyNine.setText(AppUtil.getLongValue(txtNew.femaleTwentyFiveToFortyNine4));
            maleFiftyPlus.setText(AppUtil.getLongValue(txtNew.maleFiftyPlus4));
            femaleFiftyPlus.setText(AppUtil.getLongValue(txtNew.femaleFiftyPlus4));
        }

        Button saveButton = (Button) dialog.findViewById(R.id.btn_next);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                txtNew.maleLessThanOne4 = AppUtil.getLongValue(maleLessThanOne.getText().toString());
                txtNew.femaleLessThanOne4 = AppUtil.getLongValue(femaleLessThanOne.getText().toString());

                txtNew.maleOneToFour4 = AppUtil.getLongValue(maleOneToFour.getText().toString());
                txtNew.femaleOneToFour4 = AppUtil.getLongValue(femaleOneToFour.getText().toString());

                txtNew.maleFiveToNine4 = AppUtil.getLongValue(maleFiveToNine.getText().toString());
                txtNew.femaleFiveToNine4 = AppUtil.getLongValue(femaleFiveToNine.getText().toString());

                txtNew.maleTenToFourteen4 = AppUtil.getLongValue(maleTenToFourteen.getText().toString());
                txtNew.femaleTenToFourteen4 = AppUtil.getLongValue(femaleTenToFourteen.getText().toString());

                txtNew.maleFifteenToNineteen4 = AppUtil.getLongValue(maleFifteenToNineteen.getText().toString());
                txtNew.femaleFifteenToNineteen4 = AppUtil.getLongValue(femaleFifteenToNineteen.getText().toString());

                txtNew.maleTwentyToTwentyFour4 = AppUtil.getLongValue(maleTwentyToTwentyFour.getText().toString());
                txtNew.femaleTwentyToTwentyFour4 = AppUtil.getLongValue(femaleTwentyToTwentyFour.getText().toString());

                txtNew.maleTwentyFiveToFortyNine4 = AppUtil.getLongValue(maleTwentyFiveToFortyNine.getText().toString());
                txtNew.femaleTwentyFiveToFortyNine4 = AppUtil.getLongValue(femaleTwentyFiveToFortyNine.getText().toString());

                txtNew.maleFiftyPlus4 = AppUtil.getLongValue(maleFiftyPlus.getText().toString());
                txtNew.femaleFiftyPlus4 = AppUtil.getLongValue(femaleFiftyPlus.getText().toString());

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

