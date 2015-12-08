package pt.belele.project.business.ann;

import com.github.neuralnetworks.training.TrainingInputProviderImpl;

public class BetInputProvider extends TrainingInputProviderImpl {

    private static final long serialVersionUID = 5067933748794269003L;

    private final float[][] input;
    private final float[] target;

    public BetInputProvider(float[][] input, float[] target) {
	super();
	this.input = input;
	this.target = target;
    }

    @Override
    public int getInputSize() {
	return input.length;
    }

    @Override
    public float[] getNextInput() {
	return input[currentInput % input.length];
    }

    @Override
    public float[] getNextTarget() {
	float[] nextTarget = new float[1];
	nextTarget[0] = target[currentInput % target.length];
	return nextTarget;
    }
}
