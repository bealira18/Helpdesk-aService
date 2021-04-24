package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import java.io.Serializable;

public class Email implements ValueObject, Serializable, Comparable<Email>{
    private String email;


    @Override
    public int compareTo(Email o) {
        return 0;
    }
}
