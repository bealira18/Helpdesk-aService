package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Feedback implements ValueObject, Serializable, Comparable<Feedback> {

    private int feedback;

    @Override
    public int compareTo(Feedback o) {
        return 0;
    }
}
