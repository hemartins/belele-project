/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.belele.project.business.ann;

import com.amd.aparapi.Kernel.EXECUTION_MODE;
import com.github.neuralnetworks.architecture.NeuralNetworkImpl;
import com.github.neuralnetworks.architecture.types.NNFactory;
import com.github.neuralnetworks.calculation.OutputError;
import com.github.neuralnetworks.input.MultipleNeuronsOutputError;
import com.github.neuralnetworks.training.TrainerFactory;
import com.github.neuralnetworks.training.backpropagation.BackPropagationTrainer;
import com.github.neuralnetworks.training.events.EarlyStoppingListener;
import com.github.neuralnetworks.training.random.MersenneTwisterRandomInitializer;
import com.github.neuralnetworks.training.random.NNRandomInitializer;
import com.github.neuralnetworks.util.Environment;

/**
 *
 * @author P056913
 */
public class Ann {

    public static float[][] MLPSigmoidBP(float[][] input, float[][] test, float[] target) {
	// execution mode
	Environment.getInstance().setExecutionMode(EXECUTION_MODE.SEQ);
	Environment.getInstance().setUseDataSharedMemory(false);
	Environment.getInstance().setUseWeightsSharedMemory(false);

	float[][] results = new float[test.length][5];
	for (int i = 0; i < 5; i++) {
	    // create the network
	    NeuralNetworkImpl mlp = NNFactory.mlpSigmoid(new int[]{4,
		4 * 2 + 2, 1}, true);

	    // training and testing data providers
	    BetInputProvider trainInputProvider = new BetInputProvider(input,
		    target);
	    BetInputProvider testInputProvider = new BetInputProvider(test,
		    target);

	    OutputError outputError = new MultipleNeuronsOutputError();

	    // trainer
	    BackPropagationTrainer<?> bpt = TrainerFactory
		    .backPropagation(mlp, trainInputProvider,
			    testInputProvider, outputError,
			    new NNRandomInitializer(
				    new MersenneTwisterRandomInitializer(
					    -0.01f, 0.01f), 0.5f), 0.02f, 0.7f,
			    0f, 0f, 0f, 150, 1, 2000);

	    OutputListener ltt = new OutputListener();

	    // log data
	    bpt.addEventListener(ltt);

	    // early stopping
	    bpt.addEventListener(new EarlyStoppingListener(testInputProvider,
		    100, 0.015f));

	    // train
	    bpt.train();

	    // test
	    bpt.test();

	    for (int j = 0; j < ltt.getOutput().length; j++) {
		results[j][i] = ltt.getOutput()[j];
	    }
	}

	return results;
    }
}
