package eapli.base.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Email implements ValueObject, Serializable, Comparable<Email>{

    private String email;

    protected Email(){}

    public Email(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Email o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Email: "+email;
    }
}
