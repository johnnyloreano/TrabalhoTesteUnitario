package org;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepCombTest {

    DepComb depComb;

    @BeforeEach
    void init() {
        depComb = new DepComb(100, 100, 100, 100);
    }

    @Test
    public void testAddGasolina() {
        int res;
        res = this.depComb.recebeGasolina(900);
        assertEquals(900, res);
        res = this.depComb.recebeGasolina(100);
        assertEquals(100, res);
        res = this.depComb.recebeGasolina(10000);
        assertEquals(8900, res);
        res = this.depComb.recebeGasolina(-1);
        assertEquals(-1, res);
    }

    @Test
    public void testAddAlcool() {
        int res;
        res = this.depComb.recebeAlcool(2000);
        assertEquals(2000, res);
        res = this.depComb.recebeAlcool(500);
        assertEquals(300, res);
        res = this.depComb.recebeAlcool(300);
        assertEquals(0, res);
        res = this.depComb.recebeAlcool(-1);
        assertEquals(-1, res);
    }

    @Test
    public void testAddAditivo() {
        int res;
        res = this.depComb.recebeAditivo(250);
        assertEquals(250, res);
        res = this.depComb.recebeAditivo(500);
        assertEquals(150, res);
        res = this.depComb.recebeAditivo(100);
        assertEquals(0, res);
        res = this.depComb.recebeAditivo(-1);
        assertEquals(-1, res);
    }
}