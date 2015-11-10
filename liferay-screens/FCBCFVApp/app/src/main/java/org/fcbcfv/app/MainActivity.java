package org.fcbcfv.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.liferay.mobile.screens.auth.login.LoginListener;
import com.liferay.mobile.screens.auth.login.LoginScreenlet;
import com.liferay.mobile.screens.context.User;

import org.fcbcfv.fcbcfvapp.R;

/**
 * @author Jonas Choi
 */

public class MainActivity extends AppCompatActivity implements LoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.acitivty_main);

        LoginScreenlet loginScreenlet =
                (LoginScreenlet) findViewById(R.id.login_default);

        loginScreenlet.setListener(this);

        setDefaultValuseForUserAndPassword();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onLoginSuccess(User user) {

        System.out.println("Login is OK: " + user.getAttributes());

        startActivity(new Intent(this, RoadmapContent.class));
    }

    @Override
    public void onLoginFailure(Exception e) {

    }

    private void setDefaultValuseForUserAndPassword() {
        EditText login = (EditText) findViewById(R.id.liferay_login);
        login.setText(R.string.default_user);

        EditText password = (EditText) findViewById(R.id.liferay_password);
        password.setText(R.string.default_password);
    }
}
