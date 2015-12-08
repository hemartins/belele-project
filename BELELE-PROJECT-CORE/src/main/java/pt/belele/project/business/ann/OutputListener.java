package pt.belele.project.business.ann;

import com.github.neuralnetworks.events.TrainingEvent;
import com.github.neuralnetworks.events.TrainingEventListener;
import com.github.neuralnetworks.tensor.Matrix;
import com.github.neuralnetworks.training.Trainer;
import com.github.neuralnetworks.training.events.MiniBatchFinishedEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Time/error log
 */
public class OutputListener implements TrainingEventListener {

    private static final long serialVersionUID = 1L;

    private final List<Float> output;

    public OutputListener() {
	super();
	this.output = new ArrayList<>();
    }

    @Override
    public void handleEvent(TrainingEvent event) {
	if (event instanceof MiniBatchFinishedEvent) {
	    MiniBatchFinishedEvent mbe = (MiniBatchFinishedEvent) event;
	    if (mbe.getResults() != null) {
		Matrix input = (Matrix) mbe.getData().getInput();
		Trainer<?> t = (Trainer<?>) mbe.getSource();
		Matrix networkOutput = (Matrix) mbe.getResults().get(
			t.getNeuralNetwork().getOutputLayer());

		for (int i = 0; i < input.getColumns(); i++) {

		    for (int j = 0; j < networkOutput.getRows(); j++) {
			output.add(networkOutput.get(j, i));
		    }
		}
	    }
	}
    }

    public float[] getOutput() {
	float[] floatArray = new float[output.size()];
	int i = 0;

	for (Float f : output) {
	    floatArray[i++] = (f != null ? f : Float.NaN); // Or whatever
	    // default you want.
	}
	return floatArray;
    }
}
