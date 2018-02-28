package com.aaron.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.aaron.demo.R;
import com.aaron.demo.adapter.EditTextAdapter;
import com.aaron.demo.model.EditModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron
 * on 2018/2/26
 */

public class MainActivity extends Activity {

    private ListView mListView;
    private EditTextAdapter mAdapter;

    private List<EditModel> mListModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv_edit);
        mListModel = new ArrayList<>();

        EditModel editModel;
        for (int i = 0; i < 30; i++) {
            editModel = new EditModel();
            editModel.setLabel("第" + i + "个item：");
            mListModel.add(editModel);
        }

        mAdapter = new EditTextAdapter(this,mListModel);
        mListView.setAdapter(mAdapter);
    }
}
