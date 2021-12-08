import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ReaderTest {

    @Test
    public void isempty(){
        ATB atb1 = Mockito.mock(ATB.class);
        Assertions.assertTrue(ATB.isEmpty(atb1));
        ATB atb2 = new ATB("dsfdsf", 32.54, 12);
        Assertions.assertFalse(ATB.isEmpty(atb2));

        Silpo slp1 = Mockito.mock(Silpo.class);
        Assertions.assertTrue(Silpo.isEmpty(slp1));
        Silpo slp2 = new Silpo("dsfdsf", 32.54, 12);
        Assertions.assertFalse(Silpo.isEmpty(slp2));

    }

}
