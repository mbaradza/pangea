package zw.co.ncmp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import zw.co.ncmp.adpater.DSDCoupleAdapter;
import zw.co.ncmp.business.DSDCouple;
import zw.co.ncmp.util.AppUtil;

public class DSDCoupleListActivity extends MenuBar implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_list_view);
        DSDCoupleAdapter adapter = (new DSDCoupleAdapter(this, new ArrayList<DSDCouple>(DSDCouple.getAll())));
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setEmptyView(findViewById(R.id.empty));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        setSupportActionBar(createToolBar("DSD Couple"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DSDCoupleListActivity.this, DSDCoupleActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DSDCouple item = (DSDCouple) parent.getAdapter().getItem(position);
        Intent intent = new Intent(DSDCoupleListActivity.this, DSDCoupleActivity.class);
        intent.putExtra(AppUtil.ID, item.getId());
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item_down = menu.findItem(R.id.action_refresh);
        item_down.setVisible(false);
        return true;
    }
}
