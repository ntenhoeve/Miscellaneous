package nth.packml.gui.statepane;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import nth.packml.gui.PackMLStateMachine;
import nth.packml.state.State;

public class StatePane extends Pane {

	public StatePane(PackMLStateMachine stateMachine) {
		setTranslateX(730);
		setTranslateY(220);

		addStageIndicators(stateMachine);
	}

	private void addStageIndicators(PackMLStateMachine stateMachine) {
		addStateLabel();

		addNewStateIndicator(stateMachine, State.UNHOLDING, 1, 0);
		addNewStateIndicator(stateMachine, State.HELD, 2, 0);
		addNewStateIndicator(stateMachine, State.HOLDING, 3, 0);

		addNewStateIndicator(stateMachine, State.IDLE, 0, 1);
		addNewStateIndicator(stateMachine, State.STARTING, 1, 1);
		addNewStateIndicator(stateMachine, State.EXECUTE, 2, 1);
		addNewStateIndicator(stateMachine, State.COMPLETING, 3, 1);
		addNewStateIndicator(stateMachine, State.COMPLETE, 4, 1);

		addNewStateIndicator(stateMachine, State.RESETTING, 0, 2);
		addNewStateIndicator(stateMachine, State.UNSUSPENDING, 1, 2);
		addNewStateIndicator(stateMachine, State.SUSPENDED, 2, 2);
		addNewStateIndicator(stateMachine, State.SUSPENDING, 3, 2);

		addNewStateIndicator(stateMachine, State.STOPPED, 0, 4);
		addNewStateIndicator(stateMachine, State.STOPPING, 1, 4);

		addNewStateIndicator(stateMachine, State.CLEARING, 2, 5);
		addNewStateIndicator(stateMachine, State.ABORTED, 3, 5);
		addNewStateIndicator(stateMachine, State.ABORTING, 4, 5);
	}

	private void addStateLabel() {
		getChildren().add(new Label("State:"));

	}

	private void addNewStateIndicator(PackMLStateMachine stateMachine, State state, int gridColumn, int gridRow) {
		StateIndicator indicator = new StateIndicator(stateMachine, state);
		getChildren().add(indicator);
		indicator.setLayoutX(gridColumn * 100);
		indicator.setLayoutY((gridRow * 50) + 20);
	}

}
