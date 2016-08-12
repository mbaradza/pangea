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
@Table(name = "dsd_couple")
public class DSDCouple extends Model {

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
    @Column(name = "testedFHS")
    public Long testedFHS;

    @Expose
    @Column(name = "positiveTestedFHS")
    public Long positiveTestedFHS;

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

    @Expose
    @Column(name = "testedMaternity")
    public Long testedMaternity;

    @Expose
    @Column(name = "positiveTestedMaternity")
    public Long positiveTestedMaternity;

    @Expose
    @Column(name = "testedANC")
    public Long testedANC;

    @Expose
    @Column(name = "positiveTestedANC")
    public Long positiveTestedANC;

    @Column(name = "date_submitted", notNull = false)
    public Date dateSubmitted;

    public static DSDCouple get(Long id) {
        return new Select().from(DSDCouple.class).where("Id = ?", id).executeSingle();
    }

    public static DSDCouple getDSDCouple(Long id) {
        return new Select().from(DSDCouple.class).where("serverId = ?", id).executeSingle();
    }

    public static List<DSDCouple> getAll() {
        return new Select()
                .from(DSDCouple.class)
                .orderBy("date_created ASC")
                .execute();
    }

    public static List<DSDCouple> getFilesToUpload(Long id) {
        return new Select()
                .from(DSDCouple.class)
                .where("facility_id = ?", id)
                .where("serverId is null")
                .where("date_submitted is not null")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(DSDCouple.class).execute();
    }

    @Override
    public String toString() {
        return "HTC_TST: DSD- Individuals";
    }

    public static DSDCouple fromJson(JSONObject jsonObject) {
        DSDCouple i = new DSDCouple();
        try {
            i.serverId = jsonObject.getLong("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return i;
    }

    public static ArrayList<DSDCouple> fromJson(JSONArray jsonArray) {
        ArrayList<DSDCouple> list = new ArrayList<DSDCouple>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = null;
            try {
                item = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            DSDCouple business = DSDCouple.fromJson(item);
            if (business != null) {
                list.add(business);
            }
        }

        return list;
    }

    public static final TypeToken<List<DSDCouple>> LIST =
            new TypeToken<List<DSDCouple>>() {
            };

    public String Question1() {
        return R.string.dsd_couple_question_one + " " +
                maleLessThanOne1 + maleOneToFour1 + maleOneToFour2 +
                maleFiveToNine1 + maleTenToFourteen1 + maleFifteenToNineteen1 +
                maleTwentyToTwentyFour1 + maleTwentyFiveToFortyNine1 + maleFiftyPlus1;
    }

    public String Question2() {
        return R.string.dsd_couple_question_one + " " +
                maleLessThanOne2 + maleOneToFour2 + maleOneToFour2 +
                maleFiveToNine2 + maleTenToFourteen2 + maleFifteenToNineteen2 +
                maleTwentyToTwentyFour2 + maleTwentyFiveToFortyNine2 + maleFiftyPlus2;
    }

    public String Question3() {
        return R.string.dsd_couple_question_one + " " +
                maleLessThanOne3 + maleOneToFour3 + maleOneToFour3 +
                maleFiveToNine3 + maleTenToFourteen3 + maleFifteenToNineteen3 +
                maleTwentyToTwentyFour3 + maleTwentyFiveToFortyNine3 + maleFiftyPlus3;
    }

}
