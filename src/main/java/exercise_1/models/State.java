package exercise_1.models;

import exercise_1.types.StateValue;

public class State {
	
    private StateValue stateValue;

    public State() {
        this.reset();
    }

    public void reset() {
        this.stateValue = StateValue.STORE_SELECTOR;
    }

    public void setState(StateValue stateValue) {
        this.stateValue = stateValue;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }
}
