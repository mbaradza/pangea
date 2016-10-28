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
 * Created by tdhla on 10/25/2016.
 */
@Table(name = "supplementary_indicator_form")
public class SupplementaryIndicatorForm extends Model {

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
    @Column(name = "estimatedFacilityCatchmentPopulation")
    public Long estimatedFacilityCatchmentPopulation;

    @Expose
    @Column(name = "numberOfActivePreARTPatients")
    public Long numberOfActivePreARTPatients;

    @Expose
    @Column(name = "opdNumberOfPatientsInPastMonth")
    public Long opdNumberOfPatientsInPastMonth;

    @Expose
    @Column(name = "opdNumberOfPatientsWithKnownHIVPositiveStatusOnEntry")
    public Long opdNumberOfPatientsWithKnownHIVPositiveStatusOnEntry;

    @Expose
    @Column(name = "opdNumberOfPatientsTestedForHIVInPastMonth")
    public Long opdNumberOfPatientsTestedForHIVInPastMonth;

    @Expose
    @Column(name = "opdNumberOfPatientsTestedPositiveInPastMonth")
    public Long opdNumberOfPatientsTestedPositiveInPastMonth;

    @Expose
    @Column(name = "stiNumberOfPatientsInPastMonth")
    public Long stiNumberOfPatientsInPastMonth;

    @Expose
    @Column(name = "stiNumberOfPatientsWithKnownHIVPositiveStatusOnEntry")
    public Long stiNumberOfPatientsWithKnownHIVPositiveStatusOnEntry;

    @Expose
    @Column(name = "stiNumberOfPatientsTestedForHIVInPastMonth")
    public Long stiNumberOfPatientsTestedForHIVInPastMonth;

    @Expose
    @Column(name = "stiNumberOfPatientsTestedPositiveInPastMonth")
    public Long stiNumberOfPatientsTestedPositiveInPastMonth;

    @Expose
    @Column(name = "inPatientNumberOfPatientsInPastMonth")
    public Long inPatientNumberOfPatientsInPastMonth;

    @Expose
    @Column(name = "inPatientNumberOfPatientsWithKnownHIVPositiveStatusOnEntry")
    public Long inPatientNumberOfPatientsWithKnownHIVPositiveStatusOnEntry;

    @Expose
    @Column(name = "inPatientNumberOfPatientsTestedForHIVInPastMonth")
    public Long inPatientNumberOfPatientsTestedForHIVInPastMonth;

    @Expose
    @Column(name = "inPatientNumberOfPatientsTestedPositiveInPastMonth")
    public Long inPatientNumberOfPatientsTestedPositiveInPastMonth;

    @Column(name = "date_submitted", notNull = false)
    public Date dateSubmitted;

    public SupplementaryIndicatorForm() {
        super();
    }

    public static SupplementaryIndicatorForm get(Long id) {
        return new Select().from(SupplementaryIndicatorForm.class).where("Id = ?", id).executeSingle();
    }

    public static SupplementaryIndicatorForm getSupplementaryIndicatorForm(Long id) {
        return new Select().from(SupplementaryIndicatorForm.class).where("serverId = ?", id).executeSingle();
    }

    public static List<SupplementaryIndicatorForm> getAll() {
        return new Select()
                .from(SupplementaryIndicatorForm.class)
                .orderBy("name ASC")
                .execute();
    }

    public static int getCount() {
        return new Select()
                .distinct()
                .from(SupplementaryIndicatorForm.class)
                .count();
    }

    public static List<SupplementaryIndicatorForm> getFilesToUpload() {
        return new Select()
                .from(SupplementaryIndicatorForm.class)
                .where("serverId is null")
                .where("date_submitted is not null")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(SupplementaryIndicatorForm.class).execute();
    }

    public static SupplementaryIndicatorForm fromJson(JSONObject jsonObject) {
        SupplementaryIndicatorForm i = new SupplementaryIndicatorForm();
        try {
            i.serverId = jsonObject.getLong("id");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return i;
    }

    public static ArrayList<SupplementaryIndicatorForm> fromJson(JSONArray jsonArray) {
        ArrayList<SupplementaryIndicatorForm> list = new ArrayList<SupplementaryIndicatorForm>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = null;
            try {
                item = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            SupplementaryIndicatorForm business = SupplementaryIndicatorForm.fromJson(item);
            if (business != null) {
                list.add(business);
            }
        }

        return list;
    }

    public static final TypeToken<List<SupplementaryIndicatorForm>> LIST =
            new TypeToken<List<SupplementaryIndicatorForm>>() {
            };


    @Override
    public String toString() {
        return name;
    }
}
