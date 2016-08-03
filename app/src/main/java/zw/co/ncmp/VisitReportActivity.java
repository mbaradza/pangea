package zw.co.ncmp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import zw.co.ncmp.business.ActionTakenCategory;
import zw.co.ncmp.business.CaseFile;
import zw.co.ncmp.business.MentorShipFocusArea;
import zw.co.ncmp.business.MentorVisitReport;
import zw.co.ncmp.util.AppUtil;

public class VisitReportActivity extends MenuBar implements View.OnClickListener {

    TextView txt_caseFile_name;
    Spinner focusAreas;
    EditText hours;
    EditText minutes;
    EditText comments;

    TextView txt_other;
    EditText others;
    EditText action_taken;
    EditText observation;
    EditText recommendations;

    Button btn_save;
    CaseFile caseFile;
    private MentorVisitReport mentorVisitReport;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visit_report_activity);

        Intent intent = getIntent();
        Long id = intent.getLongExtra(AppUtil.ID, 0);
        Long caseFile_id = intent.getLongExtra(AppUtil.CASE_ID, 0);

        listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<ActionTakenCategory> adapter = new ArrayAdapter<>(this, R.layout.list_item, ActionTakenCategory.getAll());
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(false);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        txt_caseFile_name = (TextView) findViewById(R.id.txt_name);

        hours = (EditText) findViewById(R.id.hours);
        minutes = (EditText) findViewById(R.id.minutes);
        comments = (EditText) findViewById(R.id.comments);
        txt_other = (TextView) findViewById(R.id.txt_other);
        others = (EditText) findViewById(R.id.others);
        action_taken = (EditText) findViewById(R.id.action_taken);
        recommendations = (EditText) findViewById(R.id.recommendations);
        observation = (EditText) findViewById(R.id.observation);

        others.setVisibility(View.GONE);
        txt_other.setVisibility(View.GONE);

        if (id != 0) {
            mentorVisitReport = MentorVisitReport.get(id);
            caseFile = CaseFile.get(mentorVisitReport.caseFile.getId());
            hours.setText(String.valueOf(mentorVisitReport.hours));
            minutes.setText(String.valueOf(mentorVisitReport.minutes));
            comments.setText(mentorVisitReport.comments);
            others.setText(mentorVisitReport.others);
            action_taken.setText(mentorVisitReport.action_taken);
            recommendations.setText(mentorVisitReport.recommendations);
            observation.setText(mentorVisitReport.observation);

            int i = 0;
            for (MentorShipFocusArea s : MentorShipFocusArea.getAll()) {
                if (mentorVisitReport.focusAreas.equals(focusAreas.getItemAtPosition(i))) {
                    focusAreas.setSelection(i);
                    break;
                }
                i++;
            }

            for (MentorShipFocusArea s : MentorShipFocusArea.getAll()) {
                if (s.name == "Other") {
                    others.setVisibility(View.VISIBLE);
                    txt_other.setVisibility(View.VISIBLE);
                    break;
                }
            }

            txt_caseFile_name.setText("SITE SUPPORT REPORT : " + AppUtil.getStringDate(caseFile.dateCreated) + " - " + caseFile.facility.name);
            setSupportActionBar(createToolBar("Update Activity"));
        } else {
            caseFile = CaseFile.get(caseFile_id);
            mentorVisitReport = new MentorVisitReport();
            mentorVisitReport.caseFile = caseFile;
            txt_caseFile_name.setText("SITE SUPPORT REPORT : " + AppUtil.getStringDate(caseFile.dateCreated) + " - " + caseFile.facility.name);
            setSupportActionBar(createToolBar("Add New Activity"));
        }

        ArrayAdapter<MentorShipFocusArea> focusAreaArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, MentorShipFocusArea.getAll());
        focusAreaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        focusAreas.setAdapter(focusAreaArrayAdapter);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

        if (caseFile.dateSubmitted != null) {
            btn_save.setVisibility(View.GONE);
        } else {
            btn_save.setVisibility(View.VISIBLE);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btn_save.getId()) {
            if (validate()) {
                mentorVisitReport.hours = AppUtil.getInputValue(hours.getText().toString());
                mentorVisitReport.minutes = AppUtil.getInputValue(minutes.getText().toString());
                mentorVisitReport.comments = comments.getText().toString();
                mentorVisitReport.focusAreas = (List<MentorShipFocusArea>) focusAreas.getSelectedItem();
                mentorVisitReport.others = others.getText().toString();
                mentorVisitReport.action_taken = action_taken.getText().toString();
                mentorVisitReport.recommendations = recommendations.getText().toString();
                mentorVisitReport.observation = observation.getText().toString();
                mentorVisitReport.save();
                Intent intent = new Intent(this, CaseFileViewActivity.class);
                intent.putExtra(AppUtil.CASE_ID, caseFile.getId());
                startActivity(intent);
                finish();
                return;
            } else {
                return;
            }
        }
    }

    public boolean validate() {
        boolean valid = true;

        String name = comments.toString().toString();

        if (name.isEmpty()) {
            comments.setError("Required");
            valid = false;
        } else {
            comments.setError(null);
        }
        return valid;
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(VisitReportActivity.this, CaseFileViewActivity.class);
        intent.putExtra(AppUtil.CASE_ID, caseFile.getId());
        startActivity(intent);
        finish();
    }
}
