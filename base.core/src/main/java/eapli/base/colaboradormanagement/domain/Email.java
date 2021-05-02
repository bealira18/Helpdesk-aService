package eapli.base.colaboradormanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Email implements ValueObject, Serializable, Comparable<Email>{

    private String email;

    protected Email(){

    }

    public Email(final String email){
        Preconditions.nonNull(email);
        if(!email.contains("@"))
            throw new IllegalArgumentException("Email inválido");
        this.email=email;
    }

    public static Email valueOf(final String email) {
        return new Email(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }

    @Override
    public int compareTo(Email o) {
        return this.email.compareTo(o.email);
    }

    @Override
    public String toString() {
        return "Email: "+email;
    }
}
