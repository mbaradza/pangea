package zw.co.ncmp.business;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by tdhlakama on 2/6/2016.
 */
@Table(name = "dsd_individual")
public class DSDIndividual extends Model {

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
    @Column(name = "question1")
    public DSDQuestion question1;

    @Expose
    @Column(name = "question2")
    public DSDQuestion question2;

    @Expose
    @Column(name = "question3")
    public DSDQuestion question3;

    @Expose
    @Column(name = "question4")
    public DSDQuestion question4;

    @Expose
    @Column(name = "question5")
    public DSDQuestion question5;
    @Expose
    @Column(name = "question6")
    public DSDQuestion question6;

    @Expose
    @Column(name = "question7")
    public DSDQuestion question7;
    @Expose
    @Column(name = "question8")
    public DSDQuestion question8;

    @Expose
    @Column(name = "question9")
    public DSDQuestion question9;

    @Expose
    @Column(name = "question10")
    public DSDQuestion question10;

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

    public static DSDIndividual get(Long id) {
        return new Select().from(DSDIndividual.class).where("Id = ?", id).executeSingle();
    }

    public static DSDIndividual getDSDIndividual(Long id) {
        return new Select().from(DSDIndividual.class).where("serverId = ?", id).executeSingle();
    }

    public static List<DSDIndividual> getAll() {
        return new Select()
                .from(DSDIndividual.class)
                .orderBy("date_created ASC")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(DSDIndividual.class).execute();
    }

    @Override
    public String toString() {
        return "HTC_TST: DSD- Couples";
    }


}
