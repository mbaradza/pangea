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
import zw.co.ncmp.util.AppUtil;

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
    @Column(name = "name")
    public String name;

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
    @Column(name = "maleFiftyPlus1")
    public Long maleFiftyPlus1;

    @Expose
    @Column(name = "femaleFiftyPlus1")
    public Long femaleFiftyPlus1;

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
    @Column(name = "maleFiftyPlus2")
    public Long maleFiftyPlus2;

    @Expose
    @Column(name = "femaleFiftyPlus2")
    public Long femaleFiftyPlus2;

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
    @Column(name = "maleFiftyPlus3")
    public Long maleFiftyPlus3;

    @Expose
    @Column(name = "femaleFiftyPlus3")
    public Long femaleFiftyPlus3;

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
    @Column(name = "maleFiftyPlus4")
    public Long maleFiftyPlus4;

    @Expose
    @Column(name = "femaleFiftyPlus4")
    public Long femaleFiftyPlus4;

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
    @Column(name = "maleFiftyPlus5")
    public Long maleFiftyPlus5;

    @Expose
    @Column(name = "femaleFiftyPlus5")
    public Long femaleFiftyPlus5;

    @Expose
    @Column(name = "testedOPD")
    public Long testedOPD;

    @Expose
    @Column(name = "positiveTestedOPD")
    public Long positiveTestedOPD;

    @Expose
    @Column(name = "testedOutreach")
    public Long testedOutreach;

    @Expose
    @Column(name = "positiveTestedOutreach")
    public Long positiveTestedOutreach;

    @Column(name = "testedMaternity")
    public Long testedMaternity;

    @Column(name = "positiveTestedMaternity")
    public Long positiveTestedMaternity;

    @SerializedName("testedPNC")
    @Expose
    @Column(name = "testedANC")
    public Long testedANC;

    @SerializedName("positiveTestedPNC")
    @Expose
    @Column(name = "positiveTestedANC")
    public Long positiveTestedANC;

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

    @SerializedName("testedVIACCentre")
    @Expose
    @Column(name = "testedVIAC")
    public Long testedVIAC;

    @Expose
    @Column(name = "testedVMMC")
    public Long testedVMMC;

    @Expose
    @Column(name = "positiveTestedVMMC")
    public Long positiveTestedVMMC;

    @SerializedName("positiveTestedVIACCentre")
    @Expose
    @Column(name = "positiveTestedVIAC")
    public Long positiveTestedVIAC;

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

    public static List<MonthReportForm> getFilesToUpload() {
        return new Select()
                .from(MonthReportForm.class)
                .where("serverId is null")
                .where("date_submitted is not null")
                .execute();
    }

    public static List<MonthReportForm> getAll() {
        return new Select()
                .from(MonthReportForm.class)
                .orderBy("date_created ASC")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(MonthReportForm.class).execute();
    }

    @Override
    public String toString() {
        return "Register Form";
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

    public Long maleQuestion1() {
        return AppUtil.getLong(maleLessThanOne1) + AppUtil.getLong(maleOneToFour1) +
                AppUtil.getLong(maleFiveToNine1) + AppUtil.getLong(maleTenToFourteen1) +
                AppUtil.getLong(maleFifteenToNineteen1) + AppUtil.getLong(maleTwentyToTwentyFour1) +
                AppUtil.getLong(maleTwentyFiveToFortyNine1) + AppUtil.getLong(maleFiftyPlus1);
    }

    public Long femaleQuestion1() {
        return AppUtil.getLong(femaleLessThanOne1) + AppUtil.getLong(femaleOneToFour1) +
                AppUtil.getLong(femaleFiveToNine1) + AppUtil.getLong(femaleTenToFourteen1) +
                AppUtil.getLong(femaleFifteenToNineteen1) + AppUtil.getLong(femaleTwentyToTwentyFour1) +
                AppUtil.getLong(femaleTwentyFiveToFortyNine1) + AppUtil.getLong(femaleFiftyPlus1);
    }

    public Long maleQuestion2() {
        return AppUtil.getLong(maleLessThanOne2) + AppUtil.getLong(maleOneToFour2) +
                AppUtil.getLong(maleFiveToNine2) + AppUtil.getLong(maleTenToFourteen2) +
                AppUtil.getLong(maleFifteenToNineteen2) + AppUtil.getLong(maleTwentyToTwentyFour2) +
                AppUtil.getLong(maleTwentyFiveToFortyNine2) + AppUtil.getLong(maleFiftyPlus2);
    }

    public Long femaleQuestion2() {
        return AppUtil.getLong(femaleLessThanOne2) + AppUtil.getLong(femaleOneToFour2) +
                AppUtil.getLong(femaleFiveToNine2) + AppUtil.getLong(femaleTenToFourteen2) +
                AppUtil.getLong(femaleFifteenToNineteen2) + AppUtil.getLong(femaleTwentyToTwentyFour2) +
                AppUtil.getLong(femaleTwentyFiveToFortyNine2) + AppUtil.getLong(femaleFiftyPlus2);
    }

    public Long maleQuestion3() {
        return AppUtil.getLong(maleLessThanOne3) + AppUtil.getLong(maleOneToFour3) +
                AppUtil.getLong(maleFiveToNine3) + AppUtil.getLong(maleTenToFourteen3) +
                AppUtil.getLong(maleFifteenToNineteen3) + AppUtil.getLong(maleTwentyToTwentyFour3) +
                AppUtil.getLong(maleTwentyFiveToFortyNine3) + AppUtil.getLong(maleFiftyPlus3);
    }

    public Long femaleQuestion3() {
        return AppUtil.getLong(femaleLessThanOne3) + AppUtil.getLong(femaleOneToFour3) +
                AppUtil.getLong(femaleFiveToNine3) + AppUtil.getLong(femaleTenToFourteen3) +
                AppUtil.getLong(femaleFifteenToNineteen3) + AppUtil.getLong(femaleTwentyToTwentyFour3) +
                AppUtil.getLong(femaleTwentyFiveToFortyNine3) + AppUtil.getLong(femaleFiftyPlus3);
    }

    public Long maleQuestion4() {
        return AppUtil.getLong(maleLessThanOne4) + AppUtil.getLong(maleOneToFour4) +
                AppUtil.getLong(maleFiveToNine4) + AppUtil.getLong(maleTenToFourteen4) +
                AppUtil.getLong(maleFifteenToNineteen4) + AppUtil.getLong(maleTwentyToTwentyFour4) +
                AppUtil.getLong(maleTwentyFiveToFortyNine4) + AppUtil.getLong(maleFiftyPlus4);
    }

    public Long femaleQuestion4() {
        return AppUtil.getLong(femaleLessThanOne4) + AppUtil.getLong(femaleOneToFour4) +
                AppUtil.getLong(femaleFiveToNine4) + AppUtil.getLong(femaleTenToFourteen4) +
                AppUtil.getLong(femaleFifteenToNineteen4) + AppUtil.getLong(femaleTwentyToTwentyFour4) +
                AppUtil.getLong(femaleTwentyFiveToFortyNine4) + AppUtil.getLong(femaleFiftyPlus4);
    }

    public Long maleQuestion5() {
        return AppUtil.getLong(maleLessThanOne5) + AppUtil.getLong(maleOneToFour5) +
                AppUtil.getLong(maleFiveToNine5) + AppUtil.getLong(maleTenToFourteen5) +
                AppUtil.getLong(maleFifteenToNineteen5) + AppUtil.getLong(maleTwentyToTwentyFour5) +
                AppUtil.getLong(maleTwentyFiveToFortyNine5) + AppUtil.getLong(maleFiftyPlus5);
    }

    public Long femaleQuestion5() {
        return AppUtil.getLong(femaleLessThanOne5) + AppUtil.getLong(femaleOneToFour5) +
                AppUtil.getLong(femaleFiveToNine5) + AppUtil.getLong(femaleTenToFourteen5) +
                AppUtil.getLong(femaleFifteenToNineteen5) + AppUtil.getLong(femaleTwentyToTwentyFour5) +
                AppUtil.getLong(femaleTwentyFiveToFortyNine5) + AppUtil.getLong(femaleFiftyPlus5);
    }
}
