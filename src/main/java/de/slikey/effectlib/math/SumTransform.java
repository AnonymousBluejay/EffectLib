package de.slikey.effectlib.math;

import java.util.Collection;

import org.bukkit.configuration.ConfigurationSection;

public class SumTransform implements Transform {

    private Collection<Transform> inputs;

    @Override
    public void load(ConfigurationSection parameters) {
        inputs = Transforms.loadTransformList(parameters, "inputs");
    }

    @Override
    public double get(double t) {
        double value = 0;
        for (Transform transform : inputs) {
            value += transform.get(t);
        }
        return value;
    }

}
