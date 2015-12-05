package pt.belele.project.ann;

import com.github.neuralnetworks.training.TrainingInputProviderImpl;


public class BetInputProvider extends TrainingInputProviderImpl {
	private static final long serialVersionUID = 5067933748794269003L;

	private float[][] input;
	private float[] target;

	public BetInputProvider(float[][] input, float[] target) {
		super();
		this.input = input;
		this.target = target;
	}

	public int getInputSize() {
		return input.length;
	}

	public float[] getNextInput() {
		return input[currentInput % input.length];
	}

	public float[] getNextTarget() {
		float[] nextTarget = new float[1];
		nextTarget[0] = target[currentInput % target.length];
		return nextTarget;
	}
}
