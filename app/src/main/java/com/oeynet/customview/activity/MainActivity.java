package com.oeynet.customview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.oeynet.customview.R;
import com.oeynet.customview.model.PieData;
import com.oeynet.customview.view.PieChart;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private com.oeynet.customview.view.PieChart picchart;
    private List<PieData> mDatas = new ArrayList<>();
    private Button btnpart;
    private Button btncount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        initListener();
    }

    private void initListener() {
        this.btncount.setOnClickListener(this);
        this.btnpart.setOnClickListener(this);
    }

    private void initViews() {
        this.picchart = (PieChart) findViewById(R.id.pic_chart);
        this.btncount = (Button) findViewById(R.id.btn_count);
        this.btnpart = (Button) findViewById(R.id.btn_part);
    }

    private void initData() {

        for (int i = 0; i < 6; i++) {
            mDatas.add(new PieData((float) (10+Math.random()*90)));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_count:
                picchart.setmStartAngle(45);
                picchart.setData(mDatas, PieChart.COUNT);
                break;
            case R.id.btn_part:
                picchart.setmStartAngle(180);
                picchart.setData(mDatas, PieChart.PART);
                break;
        }
    }
}
