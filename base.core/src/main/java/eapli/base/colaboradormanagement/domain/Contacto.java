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
    private String contacto;

    protected Contacto(){
    }

    public Contacto(String contacto) {
        //Preconditions.nonNull(contacto);
        //if(!verificaContacto(contacto))
        //    throw new IllegalArgumentException("Contacto inválido");
        this.contacto = contacto;
    }

    public static Contacto valueOf(final String contacto) {
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
        return this.contacto.compareTo(o.contacto);
    }

    public String obterContacto() {
        return contacto;
    }

    public void mudarContacto(String contacto) {
        this.contacto = contacto;
    }

    public boolean verificaContacto(String contacto){

        if(contacto.isEmpty())
            return false;

        Pattern p = Pattern.compile("(9[1236][0-9]) ?([0-9]{3}) ?([0-9]{3})");

        // Pattern class contains matcher() method
        // to find matching between given number
        // and regular expression
        Matcher m = p.matcher(contacto);

        if(m.matches())
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Contacto: "+contacto;
    }
}
