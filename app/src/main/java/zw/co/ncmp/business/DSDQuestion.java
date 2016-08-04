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
import java.util.List;

/**
 * Created by tdhlakama on 4/8/2016.
 */
@Table(name = "dsd_question")
public class DSDQuestion extends Model {

    @SerializedName("id")
    @Expose
    @Column(name = "serverId", unique = true)
    public Long serverId;

    @Expose
    @Column(name = "name")
    public String name;

    @Expose
    @Column(name = "maleLessThanOne")
    public Long maleLessThanOne;

    @Expose
    @Column(name = "femaleLessThanOne")
    public Long femaleLessThanOne;

    @Expose
    @Column(name = "maleOneToFour")
    public Long maleOneToFour;

    @Expose
    @Column(name = "femaleOneToFour")
    public Long femaleOneToFour;

    @Expose
    @Column(name = "maleFiveToNine")
    public Long maleFiveToNine;

    @Expose
    @Column(name = "femaleFiveToNine")
    public Long femaleFiveToNine;

    @Expose
    @Column(name = "maleTenToFourteen")
    public Long maleTenToFourteen;

    @Expose
    @Column(name = "femaleTenToFourteen")
    public Long femaleTenToFourteen;

    @Expose
    @Column(name = "maleFifteenToNineteen")
    public Long maleFifteenToNineteen;

    @Expose
    @Column(name = "femaleFifteenToNineteen")
    public Long femaleFifteenToNineteen;

    @Expose
    @Column(name = "maleTwentyToTwentyFour")
    public Long maleTwentyToTwentyFour;

    @Expose
    @Column(name = "femaleTwentyToTwentyFour")
    public Long femaleTwentyToTwentyFour;

    @Expose
    @Column(name = "maleTwentyFiveToFortyNine")
    public Long maleTwentyFiveToFortyNine;

    @Expose
    @Column(name = "femaleTwentyFiveToFortyNine")
    public Long femaleTwentyFiveToFortyNine;

    @Expose
    @Column(name = "malefiftyPlus")
    public Long malefiftyPlus;

    @Expose
    @Column(name = "femalefiftyPlus")
    public Long femalefiftyPlus;

    public DSDQuestion() {
        super();
    }

    public static DSDQuestion get(Long id) {
        return new Select().from(DSDQuestion.class).where("Id = ?", id).executeSingle();
    }

    public static DSDQuestion getDSDQuestion(Long id) {
        return new Select().from(DSDQuestion.class).where("serverId = ?", id).executeSingle();
    }

    public static List<DSDQuestion> getAll() {
        return new Select()
                .from(DSDQuestion.class)
                .orderBy("name ASC")
                .execute();
    }

    public static int getCount() {
        return new Select()
                .distinct()
                .from(DSDQuestion.class)
                .count();
    }

    public static List<DSDQuestion> getFilesToUpload(Long id) {
        return new Select()
                .from(DSDQuestion.class)
                .where("facility_id = ?", id)
                .where("serverId is null")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(DSDQuestion.class).execute();
    }

    public static DSDQuestion fromJson(JSONObject jsonObject) {
        DSDQuestion i = new DSDQuestion();
        try {
            i.serverId = jsonObject.getLong("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return i;
    }

    public static ArrayList<DSDQuestion> fromJson(JSONArray jsonArray) {
        ArrayList<DSDQuestion> list = new ArrayList<DSDQuestion>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = null;
            try {
                item = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            DSDQuestion business = DSDQuestion.fromJson(item);
            if (business != null) {
                list.add(business);
            }
        }

        return list;
    }

    public static final TypeToken<List<DSDQuestion>> LIST =
            new TypeToken<List<DSDQuestion>>() {
            };


    @Override
    public String toString() {
        return name;
    }

    public Long getTotalNumberOfClients() {
        return getMaleTotalNumberOfClients() + getFemaleTotalNumberOfClients();
    }

    public Long getMaleTotalNumberOfClients() {
        return maleLessThanOne + maleOneToFour + maleFiveToNine
                + maleTenToFourteen + maleFifteenToNineteen + maleTwentyToTwentyFour + maleTwentyFiveToFortyNine +
                maleTwentyFiveToFortyNine + malefiftyPlus;
    }

    public Long getFemaleTotalNumberOfClients() {
        return femaleLessThanOne + femaleOneToFour + femaleFiveToNine
                + femaleTenToFourteen + femaleFifteenToNineteen + femaleTwentyToTwentyFour + femaleTwentyFiveToFortyNine +
                femaleTwentyFiveToFortyNine + femalefiftyPlus;
    }

    public String getMaleTotal() {
        return "Males: " + getMaleTotalNumberOfClients() + " Sub-Total";
    }

    public String getFemaleTotal() {
        return "Females: " + getFemaleTotalNumberOfClients() + " Sub-Total";
    }

}
