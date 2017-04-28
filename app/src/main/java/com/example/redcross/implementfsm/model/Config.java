package com.example.redcross.implementfsm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Config {

    @SerializedName("defaultState")
    @Expose
    private String defaultState;
    @SerializedName("turningAlarmState")
    @Expose
    private String turningAlarmState;
    @SerializedName("StateTransitions")
    @Expose
    private List<StateTransition> stateTransitions = null;

    public String getDefaultState() {
        return defaultState;
    }

    public String getTurningAlarmState() {
        return turningAlarmState;
    }

    public List<StateTransition> getStateTransitions() {
        return stateTransitions;
    }
}


