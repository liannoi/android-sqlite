package org.itstep.liannoi.spot.infrastructure.primitives;

import org.itstep.liannoi.spot.application.common.interfaces.Randomise;

import java.util.Random;

public final class RandomClient implements Randomise {
    private Random random;

    public RandomClient() {
        random = new Random();
    }

    @Override
    public float random(float min, float max) {
        return min + random.nextFloat() * (max - min);
    }
}
