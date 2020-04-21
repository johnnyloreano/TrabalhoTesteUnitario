package org;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

    @Test
    public void testEncomendaCombustivelEmergencial(){
        int[] res = this.depComb.encomendaCombustivel(3000, true);
        assertArrayEquals(new int[]{-1,0,0,0}, res);

        res = this.depComb.encomendaCombustivel(200, true);
        assertArrayEquals(new int[]{0,-1,0,0}, res);

        this.depComb.recebeGasolina(2500);
        res = this.depComb.encomendaCombustivel(900, true);
        assertArrayEquals(new int[]{0,0,-1,0}, res);

        res = this.depComb.encomendaCombustivel(-1, true);
        assertArrayEquals(new int[]{-2,0,0,0}, res);

        res = this.depComb.encomendaCombustivel(0, true);
        assertArrayEquals(new int[]{-2,0,0,0}, res);

        this.depComb.recebeAditivo(300);
        this.depComb.recebeAlcool(2000);

        res = this.depComb.encomendaCombustivel(200, true);
        assertArrayEquals(new int[]{390,2460,1075,1075}, res);
    }

    @Test
    public void testEncomendaCombustivelNaoEmergencial(){

        int[] res = this.depComb.encomendaCombustivel(2500, false);
        assertArrayEquals(new int[]{-1,0,0,0}, res);

        this.depComb.recebeAditivo(300);
        res = this.depComb.encomendaCombustivel(3573, false);
        assertArrayEquals(new int[]{0,-1,0,0}, res);

        this.depComb.recebeGasolina(5000);
        res = this.depComb.encomendaCombustivel(2500, false);
        assertArrayEquals(new int[]{0,0,-1,0}, res);

        res = this.depComb.encomendaCombustivel(-1, false);
        assertArrayEquals(new int[]{-2,0,0,0}, res);

        res = this.depComb.encomendaCombustivel(0, false);
        assertArrayEquals(new int[]{-2,0,0,0}, res);
        
        this.depComb.recebeAlcool(2000);


        res = this.depComb.encomendaCombustivel(200, false);
        assertArrayEquals(new int[]{390 ,4960,1075,1075}, res);



    }
}