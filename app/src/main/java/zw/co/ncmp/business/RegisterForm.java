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
@Table(name = "monthly_report_form")
public class RegisterForm extends Model {

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

    //TXT_NEW - Last Four Questions
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
    @Column(name = "pmtctSTATP12DisaggregationP14")
    public Long pmtctSTATP12DisaggregationP14;

    @Expose
    @Column(name = "pmtctSTATP12DisaggregationP17")
    public Long pmtctSTATP12DisaggregationP17;

    @Expose
    @Column(name = "pmtctSTATP12DisaggregationP5")
    public Long pmtctSTATP12DisaggregationP5;

    public static RegisterForm get(Long id) {
        return new Select().from(RegisterForm.class).where("Id = ?", id).executeSingle();
    }

    public static RegisterForm getRegisterForm(Long id) {
        return new Select().from(RegisterForm.class).where("serverId = ?", id).executeSingle();
    }

    public static List<RegisterForm> getAll() {
        return new Select()
                .from(RegisterForm.class)
                .orderBy("date_created ASC")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(RegisterForm.class).execute();
    }

    @Override
    public String toString() {
        return "Register Form";
    }


}
