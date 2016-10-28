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
@Table(name = "screen_form")
public class ScreenForm  extends Model {

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
    @Column(name = "specimentSent")
    public Long specimentSent;

    @Expose
    @Column(name = "tbStatus")
    public Long tbStatus;

    @Expose
    @Column(name = "smear")
    public Long smear;

    @Expose
    @Column(name = "xpert")
    public Long xpert;

    @Expose
    @Column(name = "others")
    public Long others;

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

    @Column(name = "date_submitted", notNull = false)
    public Date dateSubmitted;

    public ScreenForm() {
        super();
    }

    public static ScreenForm get(Long id) {
        return new Select().from(ScreenForm.class).where("Id = ?", id).executeSingle();
    }

    public static ScreenForm getScreenForm(Long id) {
        return new Select().from(ScreenForm.class).where("serverId = ?", id).executeSingle();
    }

    public static List<ScreenForm> getAll() {
        return new Select()
                .from(ScreenForm.class)
                .orderBy("name ASC")
                .execute();
    }

    public static int getCount() {
        return new Select()
                .distinct()
                .from(ScreenForm.class)
                .count();
    }

    public static List<ScreenForm> getFilesToUpload() {
        return new Select()
                .from(ScreenForm.class)
                .where("serverId is null")
                .where("date_submitted is not null")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(ScreenForm.class).execute();
    }

    public static ScreenForm fromJson(JSONObject jsonObject) {
        ScreenForm i = new ScreenForm();
        try {
            i.serverId = jsonObject.getLong("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return i;
    }

    public static ArrayList<ScreenForm> fromJson(JSONArray jsonArray) {
        ArrayList<ScreenForm> list = new ArrayList<ScreenForm>(jsonArray.length());
        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject item = null;
            try {
                item = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            ScreenForm business = ScreenForm.fromJson(item);
            if (business != null) {
                list.add(business);
            }
        }

        return list;
    }

    public static final TypeToken<List<ScreenForm>> LIST =
            new TypeToken<List<ScreenForm>>() {
            };


    @Override
    public String toString() {
        return name;
    }
}
