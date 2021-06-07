package pedidomanagement.domain;

import eapli.base.pedidomanagement.domain.Feedback;
import org.junit.Test;

public class DarFeedbackTeste {

    @Test(expected = IllegalArgumentException.class)
    public void VerificaFeedbackCumpreLimites() {
        Feedback feedback=new Feedback(9);
    }

}
