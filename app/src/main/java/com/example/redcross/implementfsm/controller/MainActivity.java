package com.example.redcross.implementfsm.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.redcross.implementfsm.R;

public class MainActivity extends AppCompatActivity {

    private View colorAlarm;
    private TextView textAlarm;
    private FiniteStateMachine finiteStateMachine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorAlarm = findViewById(R.id.alarm_color);
        textAlarm = (TextView) findViewById(R.id.alarm_text);

        finiteStateMachine = new FiniteStateMachine(getResources());
        Toast.makeText(this, finiteStateMachine.getCurrentState(), Toast.LENGTH_LONG).show();
    }

    // method perform user clicks
    public void action(View view) {
        switch (view.getId()) {
            case R.id.btn_lock:
                finiteStateMachine.lock();
                alarmIndicator();
                Toast.makeText(this, finiteStateMachine.getCurrentState(), Toast.LENGTH_LONG).show();
                break;

            case R.id.btn_lock_x_2:
                finiteStateMachine.lockX2();
                alarmIndicator();
                Toast.makeText(this, finiteStateMachine.getCurrentState(), Toast.LENGTH_LONG).show();
                break;

            case R.id.btn_unlock:
                finiteStateMachine.unLock();
                alarmIndicator();
                Toast.makeText(this, finiteStateMachine.getCurrentState(), Toast.LENGTH_LONG).show();
                break;

            case R.id.btn_unlock_x_2:
                finiteStateMachine.unLockX2();
                alarmIndicator();
                Toast.makeText(this, finiteStateMachine.getCurrentState(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    //method check when program must update View
    protected void alarmIndicator() {
        if (finiteStateMachine.getCurrentState().equals(finiteStateMachine.getIndicatorAlarmState())) {
            colorAlarm.setBackgroundResource(R.color.alarmArmed);
            textAlarm.setText(getString(R.string.alarm_armed));
        } else {
            colorAlarm.setBackgroundResource(R.color.alarmDisarmed);
            textAlarm.setText(getString(R.string.alarmDisarmed));
        }
    }
}







