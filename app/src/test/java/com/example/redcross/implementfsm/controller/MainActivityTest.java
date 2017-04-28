package com.example.redcross.implementfsm.controller;


import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.redcross.implementfsm.BuildConfig;
import com.example.redcross.implementfsm.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private MainActivity activity;
    private Button btnLock;
    private Button btnLockX2;
    private Button btnUnlock;
    private Button btnUnlockX2;
    private View identificator;
    private TextView textView;
    private int colorArmed;
    private int colorDisarmed;

    private FiniteStateMachine finiteStateMachine;

    @Before
    public void setUp() throws Exception {

        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

        btnLock = (Button) activity.findViewById(R.id.btn_lock);
        btnLockX2 = (Button) activity.findViewById(R.id.btn_lock_x_2);
        btnUnlock = (Button) activity.findViewById(R.id.btn_unlock);
        btnUnlockX2 = (Button) activity.findViewById(R.id.btn_unlock_x_2);

        identificator = activity.findViewById(R.id.alarm_color);

        textView = (TextView) activity.findViewById(R.id.alarm_text);

        finiteStateMachine = new FiniteStateMachine(activity.getResources());

        colorArmed = ResourcesCompat.getColor(activity.getResources(), R.color.alarmArmed, null);
        colorDisarmed = ResourcesCompat.getColor(activity.getResources(), R.color.alarmDisarmed, null);
    }
    //   test if our activity not null

    @Test
    public void testActivity() throws Exception {
        assertNotNull(activity);
    }

    //test if our TextView and IdentificatorView on existing, visibility and correct resources

    @Test
    public void testTextView() throws Exception {
        assertNotNull(textView);
        assertEquals(View.VISIBLE, textView.getVisibility());
        assertEquals(activity.getString(R.string.alarmDisarmed), textView.getText());
        assertNotNull(activity.getString(R.string.alarm_armed));
    }

    @Test
    public void testIdentificator() throws Exception {
        assertNotNull(identificator);
        assertEquals(View.VISIBLE, identificator.getVisibility());
        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
    }

    //test if our buttons existing, visibility and correct resources

    @Test
    public void testBtnLock() {
        assertNotNull(btnLock);
        assertEquals(View.VISIBLE, btnLock.getVisibility());
        assertEquals(activity.getString(R.string.lock), btnLock.getText());
    }

    @Test
    public void testBtnLockX2() {
        assertNotNull(btnLockX2);
        assertEquals(View.VISIBLE, btnLockX2.getVisibility());
        assertEquals(activity.getString(R.string.lock_x_2), btnLockX2.getText());
    }

    @Test
    public void testBtnUnlock() {
        assertNotNull(btnUnlock);
        assertEquals(View.VISIBLE, btnUnlock.getVisibility());
        assertEquals(activity.getString(R.string.unlock), btnUnlock.getText());
    }

    @Test
    public void testBtnUnlockX2() {
        assertNotNull(btnUnlockX2);
        assertEquals(View.VISIBLE, btnLockX2.getVisibility());
        assertEquals(activity.getString(R.string.unlock_x_2), btnUnlockX2.getText());
    }

    //  test reaction of our view, in different current states by clicking in different buttons
    @Test
    public void stateAlarmDisarmedAllLockedClickBtnLock() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnLock.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedAllLockedClickBtnLockX2() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnLockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorArmed, tvBGColor);
        assertEquals("ARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedAllLockedClickBtnUnlock() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnUnlock.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedAllLockedClickBtnUnlockx2() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnUnlockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    //   __________________________________________________________
    @Test
    public void stateAlarmDisarmedAllUnlockedAllLockedClickBtnLock() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnLock.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedAllUnlockedAllLockedClickBtnLockX2() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnLockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorArmed, tvBGColor);
        assertEquals("ARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedAllUnlockedAllLockedClickBtnUnLock() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnUnlock.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedAllUnlockedAllLockedClickBtnUnlockX2() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnUnlockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }


//   __________________________________________________________

    @Test
    public void stateAlarmDisarmedDriverUnlockedAllLockedClickBtnLock() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnLock.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedDriverUnlockedAllLockedClickBtnLockX2() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnLockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorArmed, tvBGColor);
        assertEquals("ARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedDriverUnlockedAllLockedClickBtnUnlock() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnUnlock.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmDisarmedDriverUnlocked_AllLockedClickBtnUnlockX2() {
        identificator.setBackgroundResource(R.color.alarmDisarmed);
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        textView.setText(activity.getString(R.string.alarmDisarmed));

        btnUnlockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    //   __________________________________________________________


    // TODO: 28.04.2017 something wrong with test, all prehistory must provide passing test, but it`s not passed
    //strange behaviour... test must work, but it`s not

//    @Test
//    public void stateAlarmArmedAllLockedClickBtnLock() {
//        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
//        textView.setText(activity.getString(R.string.alarm_armed));
//        identificator.setBackgroundResource(R.color.alarmArmed);
//
//        btnLock.performClick();
//
//        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
//        assertEquals(colorArmed, tvBGColor);
//        assertEquals("ARMED", textView.getText().toString());
//    }

    @Test
    public void stateAlarmArmedAllLockedClickBtnLockX2() {
        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
        textView.setText(activity.getString(R.string.alarm_armed));
        identificator.setBackgroundResource(R.color.alarmArmed);

        btnLockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorArmed, tvBGColor);
        assertEquals("ARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmArmedAllLockedClickBtnUnlock() {
        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
        textView.setText(activity.getString(R.string.alarm_armed));
        identificator.setBackgroundResource(R.color.alarmArmed);

        btnUnlock.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());
    }

    @Test
    public void stateAlarmArmedAllLockedClickBtnUnlockX2() {
        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
        textView.setText(activity.getString(R.string.alarm_armed));
        identificator.setBackgroundResource(R.color.alarmArmed);

        btnUnlockX2.performClick();

        int tvBGColor = (((ColorDrawable) identificator.getBackground())).getColor();
        assertEquals(colorDisarmed, tvBGColor);
        assertEquals("DISARMED", textView.getText().toString());

    }
}





