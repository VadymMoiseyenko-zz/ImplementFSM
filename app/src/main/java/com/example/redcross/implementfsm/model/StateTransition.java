package com.example.redcross.implementfsm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StateTransition {

    @SerializedName("start_State")
    @Expose
    private String startState;
    @SerializedName("action_Lock")
    @Expose
    private String actionLock;
    @SerializedName("action_Lock_x_2")
    @Expose
    private String actionLockX2;
    @SerializedName("action_Unlock")
    @Expose
    private String actionUnlock;
    @SerializedName("action_Unlock_x_2")
    @Expose
    private String actionUnlockX2;

    public String getStartState() {
        return startState;
    }

    public String getActionLock() {
        return actionLock;
    }

    public String getActionLockX2() {
        return actionLockX2;
    }

    public String getActionUnlock() {
        return actionUnlock;
    }

    public String getActionUnlockX2() {
        return actionUnlockX2;
    }


}


