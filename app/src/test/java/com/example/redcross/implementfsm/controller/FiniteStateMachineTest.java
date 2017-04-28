package com.example.redcross.implementfsm.controller;


import com.example.redcross.implementfsm.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class FiniteStateMachineTest {
    private MainActivity activity;
    private FiniteStateMachine finiteStateMachine;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

        finiteStateMachine = new FiniteStateMachine(activity.getResources());
    }

    //________________ this 16 tests which testing our FSM transition methods
    @Test
    public void stateAlarmDisarmedAllUnlockedActionLock() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        finiteStateMachine.lock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_AllLocked");
    }

    @Test
    public void stateAlarmDisarmedAllUnlockedActionLockX2() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        finiteStateMachine.lockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmArmed_AllLocked");
    }

    @Test
    public void stateAlarmDisarmedAllUnlockedActionUnlock() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        finiteStateMachine.unLock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_AllUnlocked");
    }

    @Test
    public void stateAlarmDisarmedAllUnlockedActionUnlockX2() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllUnlocked");
        finiteStateMachine.unLockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_AllUnlocked");
    }

    //________________
    @Test
    public void stateAlarmDisarmedAllLockedActionLock() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        finiteStateMachine.lock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_AllLocked");
    }

    @Test
    public void stateAlarmDisarmedAllLockedActionLockX2() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        finiteStateMachine.lockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmArmed_AllLocked");
    }

    @Test
    public void statAlarmDisarmedAllLockedActionUnlock() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        finiteStateMachine.unLock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_driverUnlocked");
    }

    @Test
    public void stateAlarmDisarmed_AllLockedActionUnlockX2() {
        finiteStateMachine.setCurrentState("alarmDisarmed_AllLocked");
        finiteStateMachine.unLockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_AllUnlocked");
    }

    //________________
    @Test
    public void stateAlarmArmedAllLockedActionLock() {
        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
        finiteStateMachine.lock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmArmed_AllLocked");
    }

    @Test
    public void stateAlarmArmedAllLockedActionLockX2() {
        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
        finiteStateMachine.lockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmArmed_AllLocked");
    }

    @Test
    public void statAlarmArmedAllLockedActionUnlock() {
        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
        finiteStateMachine.unLock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_driverUnlocked");
    }

    @Test
    public void stateAlarmArmedAllLockedActionUnlockX2() {
        finiteStateMachine.setCurrentState("alarmArmed_AllLocked");
        finiteStateMachine.unLockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_AllUnlocked");
    }

    //________________
    @Test
    public void stateAlarmDisarmedDriverUnlockedActionLock() {
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        finiteStateMachine.lock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_AllLocked");
    }

    @Test
    public void stateAlarmDisarmedDriverUnlockedActionLockX2() {
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        finiteStateMachine.lockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmArmed_AllLocked");
    }

    @Test
    public void stateAlarmDisarmedDriverUnlockedActionUnlock() {
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        finiteStateMachine.unLock();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_driverUnlocked");
    }

    @Test
    public void stateAlarmDisarmedDriverUnlockedActionUnlockX2() {
        finiteStateMachine.setCurrentState("alarmDisarmed_driverUnlocked");
        finiteStateMachine.unLockX2();
        assertEquals(finiteStateMachine.getCurrentState(), "alarmDisarmed_driverUnlocked");
    }


}













