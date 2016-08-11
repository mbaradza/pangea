package zw.co.ncmp.business;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zw.co.ncmp.R;

/**
 * Created by tdhlakama on 2/6/2016.
 */
@Table(name = "monthly_report_form")
public class MonthReportForm extends Model {

    @SerializedName("id")
    @Expose
    @Column(name = "serverId", unique = true)
    public Long serverId;

    @Expose
    @Column(name = "facility_id")
    public Facility facility;

    @Expose
    @Column(name = "period_id")
    public Period period;

    @Column(name = "date_created")
    public Date dateCreated;

    @SerializedName("datec")
    @Expose
    public String serverCreatedDate;

    @Expose
    @Column(name = "maleLessThanOne1")
    public Long maleLessThanOne1;

    @Expose
    @Column(name = "femaleLessThanOne1")
    public Long femaleLessThanOne1;

    @Expose
    @Column(name = "maleOneToFour1")
    public Long maleOneToFour1;

    @Expose
    @Column(name = "femaleOneToFour1")
    public Long femaleOneToFour1;

    @Expose
    @Column(name = "maleFiveToNine1")
    public Long maleFiveToNine1;

    @Expose
    @Column(name = "femaleFiveToNine1")
    public Long femaleFiveToNine1;

    @Expose
    @Column(name = "maleTenToFourteen1")
    public Long maleTenToFourteen1;

    @Expose
    @Column(name = "femaleTenToFourteen1")
    public Long femaleTenToFourteen1;

    @Expose
    @Column(name = "maleFifteenToNineteen1")
    public Long maleFifteenToNineteen1;

    @Expose
    @Column(name = "femaleFifteenToNineteen1")
    public Long femaleFifteenToNineteen1;

    @Expose
    @Column(name = "maleTwentyToTwentyFour1")
    public Long maleTwentyToTwentyFour1;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour1")
    public Long femaleTwentyToTwentyFour1;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine1")
    public Long maleTwentyFiveToFortyNine1;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine1")
    public Long femaleTwentyFiveToFortyNine1;

    @Expose
    @Column(name = "malefiftyPlus1")
    public Long malefiftyPlus1;

    @Expose
    @Column(name = "femalefiftyPlus1")
    public Long femalefiftyPlus1;

    @Expose
    @Column(name = "maleLessThanOne2")
    public Long maleLessThanOne2;

    @Expose
    @Column(name = "femaleLessThanOne2")
    public Long femaleLessThanOne2;

    @Expose
    @Column(name = "maleOneToFour2")
    public Long maleOneToFour2;

    @Expose
    @Column(name = "femaleOneToFour2")
    public Long femaleOneToFour2;

    @Expose
    @Column(name = "maleFiveToNine2")
    public Long maleFiveToNine2;

    @Expose
    @Column(name = "femaleFiveToNine2")
    public Long femaleFiveToNine2;

    @Expose
    @Column(name = "maleTenToFourteen2")
    public Long maleTenToFourteen2;

    @Expose
    @Column(name = "femaleTenToFourteen2")
    public Long femaleTenToFourteen2;

    @Expose
    @Column(name = "maleFifteenToNineteen2")
    public Long maleFifteenToNineteen2;

    @Expose
    @Column(name = "femaleFifteenToNineteen2")
    public Long femaleFifteenToNineteen2;

    @Expose
    @Column(name = "maleTwentyToTwentyFour2")
    public Long maleTwentyToTwentyFour2;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour2")
    public Long femaleTwentyToTwentyFour2;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine2")
    public Long maleTwentyFiveToFortyNine2;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine2")
    public Long femaleTwentyFiveToFortyNine2;

    @Expose
    @Column(name = "malefiftyPlus2")
    public Long malefiftyPlus2;

    @Expose
    @Column(name = "femalefiftyPlus2")
    public Long femalefiftyPlus2;

    @Expose
    @Column(name = "maleLessThanOne3")
    public Long maleLessThanOne3;

    @Expose
    @Column(name = "femaleLessThanOne3")
    public Long femaleLessThanOne3;

    @Expose
    @Column(name = "maleOneToFour3")
    public Long maleOneToFour3;

    @Expose
    @Column(name = "femaleOneToFour3")
    public Long femaleOneToFour3;

    @Expose
    @Column(name = "maleFiveToNine3")
    public Long maleFiveToNine3;

    @Expose
    @Column(name = "femaleFiveToNine3")
    public Long femaleFiveToNine3;

    @Expose
    @Column(name = "maleTenToFourteen3")
    public Long maleTenToFourteen3;

    @Expose
    @Column(name = "femaleTenToFourteen3")
    public Long femaleTenToFourteen3;

    @Expose
    @Column(name = "maleFifteenToNineteen3")
    public Long maleFifteenToNineteen3;

    @Expose
    @Column(name = "femaleFifteenToNineteen3")
    public Long femaleFifteenToNineteen3;

    @Expose
    @Column(name = "maleTwentyToTwentyFour3")
    public Long maleTwentyToTwentyFour3;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour3")
    public Long femaleTwentyToTwentyFour3;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine3")
    public Long maleTwentyFiveToFortyNine3;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine3")
    public Long femaleTwentyFiveToFortyNine3;

    @Expose
    @Column(name = "malefiftyPlus3")
    public Long malefiftyPlus3;

    @Expose
    @Column(name = "femalefiftyPlus3")
    public Long femalefiftyPlus3;

    @Expose
    @Column(name = "maleLessThanOne4")
    public Long maleLessThanOne4;

    @Expose
    @Column(name = "femaleLessThanOne4")
    public Long femaleLessThanOne4;

    @Expose
    @Column(name = "maleOneToFour4")
    public Long maleOneToFour4;

    @Expose
    @Column(name = "femaleOneToFour4")
    public Long femaleOneToFour4;

    @Expose
    @Column(name = "maleFiveToNine4")
    public Long maleFiveToNine4;

    @Expose
    @Column(name = "femaleFiveToNine4")
    public Long femaleFiveToNine4;

    @Expose
    @Column(name = "maleTenToFourteen4")
    public Long maleTenToFourteen4;

    @Expose
    @Column(name = "femaleTenToFourteen4")
    public Long femaleTenToFourteen4;

    @Expose
    @Column(name = "maleFifteenToNineteen4")
    public Long maleFifteenToNineteen4;

    @Expose
    @Column(name = "femaleFifteenToNineteen4")
    public Long femaleFifteenToNineteen4;

    @Expose
    @Column(name = "maleTwentyToTwentyFour4")
    public Long maleTwentyToTwentyFour4;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour4")
    public Long femaleTwentyToTwentyFour4;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine4")
    public Long maleTwentyFiveToFortyNine4;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine4")
    public Long femaleTwentyFiveToFortyNine4;

    @Expose
    @Column(name = "malefiftyPlus4")
    public Long malefiftyPlus4;

    @Expose
    @Column(name = "femalefiftyPlus4")
    public Long femalefiftyPlus4;

    @Expose
    @Column(name = "maleLessThanOne5")
    public Long maleLessThanOne5;

    @Expose
    @Column(name = "femaleLessThanOne5")
    public Long femaleLessThanOne5;

    @Expose
    @Column(name = "maleOneToFour5")
    public Long maleOneToFour5;

    @Expose
    @Column(name = "femaleOneToFour5")
    public Long femaleOneToFour5;

    @Expose
    @Column(name = "maleFiveToNine5")
    public Long maleFiveToNine5;

    @Expose
    @Column(name = "femaleFiveToNine5")
    public Long femaleFiveToNine5;

    @Expose
    @Column(name = "maleTenToFourteen5")
    public Long maleTenToFourteen5;

    @Expose
    @Column(name = "femaleTenToFourteen5")
    public Long femaleTenToFourteen5;

    @Expose
    @Column(name = "maleFifteenToNineteen5")
    public Long maleFifteenToNineteen5;

    @Expose
    @Column(name = "femaleFifteenToNineteen5")
    public Long femaleFifteenToNineteen5;

    @Expose
    @Column(name = "maleTwentyToTwentyFour5")
    public Long maleTwentyToTwentyFour5;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour5")
    public Long femaleTwentyToTwentyFour5;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine5")
    public Long maleTwentyFiveToFortyNine5;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine5")
    public Long femaleTwentyFiveToFortyNine5;

    @Expose
    @Column(name = "malefiftyPlus5")
    public Long malefiftyPlus5;

    @Expose
    @Column(name = "femalefiftyPlus5")
    public Long femalefiftyPlus5;

    @Expose
    @Column(name = "maleLessThanOne6")
    public Long maleLessThanOne6;

    @Expose
    @Column(name = "femaleLessThanOne6")
    public Long femaleLessThanOne6;

    @Expose
    @Column(name = "maleOneToFour6")
    public Long maleOneToFour6;

    @Expose
    @Column(name = "femaleOneToFour6")
    public Long femaleOneToFour6;

    @Expose
    @Column(name = "maleFiveToNine6")
    public Long maleFiveToNine6;

    @Expose
    @Column(name = "femaleFiveToNine6")
    public Long femaleFiveToNine6;

    @Expose
    @Column(name = "maleTenToFourteen6")
    public Long maleTenToFourteen6;

    @Expose
    @Column(name = "femaleTenToFourteen6")
    public Long femaleTenToFourteen6;

    @Expose
    @Column(name = "maleFifteenToNineteen6")
    public Long maleFifteenToNineteen6;

    @Expose
    @Column(name = "femaleFifteenToNineteen6")
    public Long femaleFifteenToNineteen6;

    @Expose
    @Column(name = "maleTwentyToTwentyFour6")
    public Long maleTwentyToTwentyFour6;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour6")
    public Long femaleTwentyToTwentyFour6;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine6")
    public Long maleTwentyFiveToFortyNine6;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine6")
    public Long femaleTwentyFiveToFortyNine6;

    @Expose
    @Column(name = "malefiftyPlus6")
    public Long malefiftyPlus6;

    @Expose
    @Column(name = "femalefiftyPlus6")
    public Long femalefiftyPlus6;


    @Expose
    @Column(name = "maleLessThanOne7")
    public Long maleLessThanOne7;

    @Expose
    @Column(name = "femaleLessThanOne7")
    public Long femaleLessThanOne7;

    @Expose
    @Column(name = "maleOneToFour7")
    public Long maleOneToFour7;

    @Expose
    @Column(name = "femaleOneToFour7")
    public Long femaleOneToFour7;

    @Expose
    @Column(name = "maleFiveToNine7")
    public Long maleFiveToNine7;

    @Expose
    @Column(name = "femaleFiveToNine7")
    public Long femaleFiveToNine7;

    @Expose
    @Column(name = "maleTenToFourteen7")
    public Long maleTenToFourteen7;

    @Expose
    @Column(name = "femaleTenToFourteen7")
    public Long femaleTenToFourteen7;

    @Expose
    @Column(name = "maleFifteenToNineteen7")
    public Long maleFifteenToNineteen7;

    @Expose
    @Column(name = "femaleFifteenToNineteen7")
    public Long femaleFifteenToNineteen7;

    @Expose
    @Column(name = "maleTwentyToTwentyFour7")
    public Long maleTwentyToTwentyFour7;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour7")
    public Long femaleTwentyToTwentyFour7;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine7")
    public Long maleTwentyFiveToFortyNine7;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine7")
    public Long femaleTwentyFiveToFortyNine7;

    @Expose
    @Column(name = "malefiftyPlus7")
    public Long malefiftyPlus7;

    @Expose
    @Column(name = "femalefiftyPlus7")
    public Long femalefiftyPlus7;

    @Expose
    @Column(name = "maleLessThanOne8")
    public Long maleLessThanOne8;

    @Expose
    @Column(name = "femaleLessThanOne8")
    public Long femaleLessThanOne8;

    @Expose
    @Column(name = "maleOneToFour8")
    public Long maleOneToFour8;

    @Expose
    @Column(name = "femaleOneToFour8")
    public Long femaleOneToFour8;

    @Expose
    @Column(name = "maleFiveToNine8")
    public Long maleFiveToNine8;

    @Expose
    @Column(name = "femaleFiveToNine8")
    public Long femaleFiveToNine8;

    @Expose
    @Column(name = "maleTenToFourteen8")
    public Long maleTenToFourteen8;

    @Expose
    @Column(name = "femaleTenToFourteen8")
    public Long femaleTenToFourteen8;

    @Expose
    @Column(name = "maleFifteenToNineteen8")
    public Long maleFifteenToNineteen8;

    @Expose
    @Column(name = "femaleFifteenToNineteen8")
    public Long femaleFifteenToNineteen8;

    @Expose
    @Column(name = "maleTwentyToTwentyFour8")
    public Long maleTwentyToTwentyFour8;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour8")
    public Long femaleTwentyToTwentyFour8;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine8")
    public Long maleTwentyFiveToFortyNine8;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine8")
    public Long femaleTwentyFiveToFortyNine8;

    @Expose
    @Column(name = "malefiftyPlus8")
    public Long malefiftyPlus8;

    @Expose
    @Column(name = "femalefiftyPlus8")
    public Long femalefiftyPlus8;

    @Expose
    @Column(name = "testedOPD")
    public Long testedOPD;

    @Expose
    @Column(name = "positiveTestedOPD")
    public Long positiveTestedOPD;

    @Expose
    @Column(name = "testedInpatient")
    public Long testedInpatient;

    @Expose
    @Column(name = "positiveTestedInpatient")
    public Long positiveTestedInpatient;

    @Expose
    @Column(name = "testedPaediatric")
    public Long testedPaediatric;

    @Expose
    @Column(name = "positiveTestedPaediatric")
    public Long positiveTestedPaediatric;

    @Expose
    @Column(name = "testedPMTCT")
    public Long testedPMTCT;

    @Expose
    @Column(name = "positiveTestedPMTCT")
    public Long positiveTestedPMTCT;

    @Expose
    @Column(name = "testedSTI")
    public Long testedSTI;

    @Expose
    @Column(name = "positiveTestedSTI")
    public Long positiveTestedSTI;

    @Expose
    @Column(name = "testedTB")
    public Long testedTB;

    @Expose
    @Column(name = "positiveTestedTB")
    public Long positiveTestedTB;

    @Expose
    @Column(name = "pmtctEIDP30")
    public Long pmtctEIDP30;

    @Expose
    @Column(name = "pmtctEIDP31")
    public Long pmtctEIDP31;

    @Expose
    @Column(name = "pmtctEIDP4")
    public Long pmtctEIDP4;

    @Expose
    @Column(name = "pmtctEIDP5")
    public Long pmtctEIDP5;

    @Expose
    @Column(name = "pmtctEIDP14")
    public Long pmtctEIDP14;

    @Expose
    @Column(name = "pmtctEIDP17")
    public Long pmtctEIDP17;

    @Expose
    @Column(name = "pmtctSTATP2")
    public Long pmtctSTATP2;

    @Expose
    @Column(name = "pmtctSTATP5")
    public Long pmtctSTATP5;

    @Expose
    @Column(name = "pmtctSTATP13")
    public Long pmtctSTATP13;

    @Expose
    @Column(name = "pmtctSTATP1")
    public Long pmtctSTATP1;

    @Expose
    @Column(name = "pmtctSTATP12")
    public Long pmtctSTATP12;

    @Expose
    @Column(name = "pmtctSTATP12DisaggregationP4")
    public Long pmtctSTATP12DisaggregationP4;

    @Expose
    @Column(name = "pmtctSTATP12DisaggregationP5")
    public Long pmtctSTATP12DisaggregationP5;

    @Expose
    @Column(name = "pmtctSTATP12DisaggregationP14")
    public Long pmtctSTATP12DisaggregationP14;

    @Expose
    @Column(name = "pmtctSTATP12DisaggregationP17")
    public Long pmtctSTATP12DisaggregationP17;

    @Column(name = "date_submitted", notNull = false)
    public Date dateSubmitted;

    public static MonthReportForm get(Long id) {
        return new Select().from(MonthReportForm.class).where("Id = ?", id).executeSingle();
    }

    public static MonthReportForm getMonthReportForm(Long id) {
        return new Select().from(MonthReportForm.class).where("serverId = ?", id).executeSingle();
    }

    public static List<MonthReportForm> getAll() {
        return new Select()
                .from(MonthReportForm.class)
                .orderBy("date_created ASC")
                .execute();
    }

    public static List<MonthReportForm> getFilesToUpload(Long id) {
        return new Select()
                .from(MonthReportForm.class)
                .where("facility_id = ?", id)
                .where("serverId is null")
                .where("date_submitted is not null")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(MonthReportForm.class).execute();
    }

    @Override
    public String toString() {
        return "Monthly Report Form";
    }

    public static MonthReportForm fromJson(JSONObject jsonObject) {
        MonthReportForm i = new MonthReportForm();
        try {
            i.serverId = jsonObject.getLong("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return i;
    }

    public static ArrayList<MonthReportForm> fromJson(JSONArray jsonArray) {
        ArrayList<MonthReportForm> list = new ArrayList<MonthReportForm>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = null;
            try {
                item = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            MonthReportForm business = MonthReportForm.fromJson(item);
            if (business != null) {
                list.add(business);
            }
        }

        return list;
    }

    public static final TypeToken<List<MonthReportForm>> LIST =
            new TypeToken<List<MonthReportForm>>() {
            };


    public String Question1() {
        return R.string.register_question_one + " " +
                maleLessThanOne1 + maleOneToFour1 + maleOneToFour2 +
                maleFiveToNine1 + maleTenToFourteen1 + maleFifteenToNineteen1 +
                maleTwentyToTwentyFour1 + maleTwentyFiveToFortyNine1 + malefiftyPlus1;
    }

    public String Question2() {
        return R.string.register_question_one + " " +
                maleLessThanOne2 + maleOneToFour2 + maleOneToFour2 +
                maleFiveToNine2 + maleTenToFourteen2 + maleFifteenToNineteen2 +
                maleTwentyToTwentyFour2 + maleTwentyFiveToFortyNine2 + malefiftyPlus2;
    }

    public String Question3() {
        return R.string.register_question_one + " " +
                maleLessThanOne3 + maleOneToFour3 + maleOneToFour3 +
                maleFiveToNine3 + maleTenToFourteen3 + maleFifteenToNineteen3 +
                maleTwentyToTwentyFour3 + maleTwentyFiveToFortyNine3 + malefiftyPlus3;
    }

    public String Question4() {
        return R.string.register_question_one + " " +
                maleLessThanOne4 + maleOneToFour4 + maleOneToFour4 +
                maleFiveToNine4 + maleTenToFourteen4 + maleFifteenToNineteen4 +
                maleTwentyToTwentyFour4 + maleTwentyFiveToFortyNine4 + malefiftyPlus4;
    }

    public String Question5() {
        return R.string.register_question_one + " " +
                maleLessThanOne5 + maleOneToFour5 + maleOneToFour5 +
                maleFiveToNine5 + maleTenToFourteen5 + maleFifteenToNineteen5 +
                maleTwentyToTwentyFour5 + maleTwentyFiveToFortyNine5 + malefiftyPlus5;
    }

    public String Question6() {
        return R.string.register_question_one + " " +
                maleLessThanOne6 + maleOneToFour6 + maleOneToFour6 +
                maleFiveToNine6 + maleTenToFourteen6 + maleFifteenToNineteen6 +
                maleTwentyToTwentyFour6 + maleTwentyFiveToFortyNine6 + malefiftyPlus6;
    }

    public String Question7() {
        return R.string.register_question_one + " " +
                maleLessThanOne7 + maleOneToFour7 + maleOneToFour7 +
                maleFiveToNine7 + maleTenToFourteen7 + maleFifteenToNineteen7 +
                maleTwentyToTwentyFour7 + maleTwentyFiveToFortyNine7 + malefiftyPlus7;
    }

    public String Question8() {
        return R.string.register_question_one + " " +
                maleLessThanOne8 + maleOneToFour8 + maleOneToFour8 +
                maleFiveToNine8 + maleTenToFourteen8 + maleFifteenToNineteen8 +
                maleTwentyToTwentyFour8 + maleTwentyFiveToFortyNine8 + malefiftyPlus8;
    }

}
