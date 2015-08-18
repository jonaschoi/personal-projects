package org.fcbcfv.fcbcfvapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static org.fcbcfv.fcbcfvapp.R.id.ddl_form;
import static org.fcbcfv.fcbcfvapp.R.id.ddl_list;
import static org.fcbcfv.fcbcfvapp.R.id.web_view;

/**
 * @author Jonas Choi
 */

public class MenuScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        findViewById(ddl_form).setOnClickListener(this);
        findViewById(web_view).setOnClickListener(this);
        findViewById(ddl_list).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case ddl_form:
                startActivity(new Intent(this, AttendanceForm.class));
                break;
            case ddl_list:
                startActivity(new Intent(this, AttendanceView.class));
                break;
            case web_view:
                startActivity(new Intent(this, RoadmapContent.class));
                break;
        }
    }
}
