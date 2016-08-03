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
@Table(name = "txt_new")
public class TXTNew extends Model {

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

    public static TXTNew get(Long id) {
        return new Select().from(TXTNew.class).where("Id = ?", id).executeSingle();
    }

    public static TXTNew getTXTNew(Long id) {
        return new Select().from(TXTNew.class).where("serverId = ?", id).executeSingle();
    }

    public static List<TXTNew> getAll() {
        return new Select()
                .from(TXTNew.class)
                .orderBy("date_created ASC")
                .execute();
    }

    public static void deleteAll() {
        new Delete().from(TXTNew.class).execute();
    }

    @Override
    public String toString() {
        return "TX_NEW: DSD";
    }


}
