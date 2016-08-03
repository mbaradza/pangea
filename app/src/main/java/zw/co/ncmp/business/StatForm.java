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

/**
 * Created by tdhlakama on 4/8/2016.
 */
@Table(name = "stat_form")
public class StatForm  extends Model {

    @SerializedName("id")
    @Expose
    @Column(name = "serverId", unique = true)
    public Long serverId;

    @Expose
    @Column(name = "facility_id")
    public Facility facility;

    @Column(name = "date_created")
    public Date dateCreated;

    @SerializedName("datec")
    @Expose
    public String serverCreatedDate;

    @Expose
    @Column(name = "name")
    public String name;

    @Expose
    @Column(name = "period_id")
    public Period period;

    @Expose
    @Column(name = "numerator")
    public Long numerator;

    @Expose
    @Column(name = "denominator")
    public Long denominator;

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
    @Column(name = "maleTwentyPlus")
    public Long maleTwentyPlus;

    @Expose
    @Column(name = "femaleTwentyPlus")
    public Long femaleTwentyPlus;

    @Expose
    @Column(name = "knownHIV")
    public Long knownHIV;

    @Expose
    @Column(name = "positiveHIV")
    public Long positiveHIV;

    @Expose
    @Column(name = "negativeHIV")
    public Long negativeHIV;

    public StatForm() {
        super();
    }

    public static StatForm get(Long id) {
        return new Select().from(StatForm.class).where("Id = ?", id).executeSingle();
    }

    public static StatForm getStatForm(Long id) {
        return new Select().from(StatForm.class).where("serverId = ?", id).executeSingle();
    }

    public static List<StatForm> getAll() {
        return new Select()
                .from(StatForm.class)
                .orderBy("name ASC")
               .execute();
    }

    public static int getCount() {
        return new Select()
                .distinct()
                .from(StatForm.class)
                .count();
    }

    public static List<StatForm> getFilesToUpload(Long id) {
        return new Select()
                .from(StatForm.class)
                .where("facility_id = ?", id)
                .where("serverId is null")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(StatForm.class).execute();
    }

    public static StatForm fromJson(JSONObject jsonObject) {
        StatForm i = new StatForm();
        try {
            i.serverId = jsonObject.getLong("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return i;
    }

    public static ArrayList<StatForm> fromJson(JSONArray jsonArray) {
        ArrayList<StatForm> list = new ArrayList<StatForm>(jsonArray.length());
        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject item = null;
            try {
                item = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            StatForm business = StatForm.fromJson(item);
            if (business != null) {
                list.add(business);
            }
        }

        return list;
    }

    public static final TypeToken<List<StatForm>> LIST =
            new TypeToken<List<StatForm>>() {
            };


    @Override
    public String toString() {
        return name;
    }
}
