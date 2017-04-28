package com.example.redcross.implementfsm.controller;


import android.content.res.Resources;
import com.example.redcross.implementfsm.R;
import com.example.redcross.implementfsm.model.Config;
import com.example.redcross.implementfsm.model.StateTransition;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

//Finite State Machine based on config.json file in raw directory
class FiniteStateMachine {
    private String jsonConfig; // String in which we read json file with input Steam
    private String currentState; // Demonstrate in which state FSM at current moment
    private String indicatorAlarmState; // this string we receive from json, it show in which state we must update view
    private Config config; // Model class in which we parse our JSON file
    private Map<String, StateTransition> map; // map simplify our transition between state

    //constructor fsm
    FiniteStateMachine(Resources resources)  {
        initFSM(resources);
    }

    void initFSM(Resources resources) {
        getJson(resources);
        createObjectFromJSON(jsonConfig);
        convertToMap();
    }

    //reading JSON from res, and write it to String
    private void getJson(Resources resources) {
        InputStream is = resources.openRawResource(R.raw.fsm_config);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        jsonConfig = writer.toString();
    }

    //parse Json into Java Object by Gson
    private void createObjectFromJSON(String jsonString)   {
        config = new Gson().fromJson(jsonString, Config.class);
        currentState = config.getDefaultState();
        indicatorAlarmState = config.getTurningAlarmState();
    }

    //convert FSM dependency into map
    private void convertToMap() {
        map = new HashMap<>();
        for (int i = 0; i < config.getStateTransitions().size(); i++) {
            StateTransition stateTransition = config.getStateTransitions().get(i);
            map.put(stateTransition.getStartState(), stateTransition);
        }
    }

    // methods from user action
    void lock() {
        currentState = (map.get(currentState).getActionLock());
    }

    void lockX2() {
        currentState = (map.get(currentState).getActionLockX2());
    }

    void unLock() {
        currentState = (map.get(currentState).getActionUnlock());
    }

    void unLockX2() {
        currentState = (map.get(currentState).getActionUnlockX2());
    }

    // our getters
    String getIndicatorAlarmState() {
        return indicatorAlarmState;
    }

    String getCurrentState() {
        return currentState;
    }

    // it`s method for tests, but i guess it`s not a best practice
    // TODO: 28.04.2017 Figure out how to change this method, maybe by mock object
    void setCurrentState(String state) {
        currentState = state;
    }
}


