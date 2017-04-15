package org.deeplearning4j.nn.updater;

import org.deeplearning4j.nn.api.Model;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.Layer;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.updater.graph.ComputationGraphUpdater;
import org.nd4j.linalg.learning.GradientUpdater;

/**
 *
 *
 * @author Adam Gibson
 */
public class UpdaterCreator {

    private UpdaterCreator() {}

    public static org.deeplearning4j.nn.api.Updater getUpdater(Model layer) {
        if (layer instanceof MultiLayerNetwork) {
            return new MultiLayerUpdater((MultiLayerNetwork) layer);
        } else if(layer instanceof ComputationGraph){
            return new ComputationGraphUpdater((ComputationGraph)layer);
        } else {
            return new LayerUpdater();
        }
    }

}
