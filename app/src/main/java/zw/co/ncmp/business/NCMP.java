package zw.co.ncmp.business;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by tdhlakama on 1/19/2016.
 */
public class NCMP extends android.app.Application {

    public static Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        Configuration dbConfiguration = new Configuration.Builder(this).setDatabaseName("ncmp.db").create();
        ActiveAndroid.initialize(dbConfiguration);
        bus = new Bus(ThreadEnforcer.MAIN);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    public static Bus getInstance() {
        return bus;
    }
}
