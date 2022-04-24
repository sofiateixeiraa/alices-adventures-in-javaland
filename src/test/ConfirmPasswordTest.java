package test;

import jframe.ConfirmPassword;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfirmPasswordTest {

    public static final String VALUEOK = "VALUEOK";

    @Test
    public void confirmPasswordOk() {
        assertTrue(ConfirmPassword.confirmPass(VALUEOK,VALUEOK));
    }

    @Test
    public void confirmPasswordError() {
        assertFalse(ConfirmPassword.confirmPass(VALUEOK, "SOMETHING ELSE"));
    }


}