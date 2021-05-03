package eapli.base.colaboradormanagement.domain;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
public class Contacto implements ValueObject, Serializable, Comparable<Contacto> {
    private long contacto;

    protected Contacto(){
    }

    public Contacto(long contacto) {
        Preconditions.nonNull(contacto);
        Preconditions.nonNegative(contacto);
        if(verificaContacto(contacto))
            throw new IllegalArgumentException("Contacto inválido");
        this.contacto = contacto;
    }

    public static Contacto valueOf(final Long contacto) {
        return new Contacto(contacto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto contacto1 = (Contacto) o;
        return contacto == contacto1.contacto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contacto);
    }

    @Override
    public int compareTo(Contacto o) {
        if(this.contacto==o.contacto)
            return 0;
        else if(this.contacto>o.contacto){
            return 1;
        }
        return -1;
    }

    public boolean verificaContacto(Long contacto){

        Pattern p = Pattern.compile("9(1/2/3/6)[0-9]{7}");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher m = p.matcher(contacto.toString());
        return (m.find() && m.group().equals(contacto.toString()));

    }

    @Override
    public String toString() {
        return "Contacto: "+contacto;
    }
}
