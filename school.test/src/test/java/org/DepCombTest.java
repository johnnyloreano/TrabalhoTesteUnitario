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
    public void testAddGasolinajao() {
        int res;
        res = this.depComb.recebeGasolina(900);
        assertEquals(900, res);
        res = this.depComb.recebeGasolina(10000);
        assertEquals(9000, res);
        res = this.depComb.recebeGasolina(1000); //ok
        assertEquals(0, res);
        res = this.depComb.recebeGasolina(-1);
        assertEquals(-1, res);
    }
    //------------------------------------------

    @Test
    public void testAddGasolina1() {
        int res;
        depComb = new DepComb(10000, 100, 100, 100);
        res = this.depComb.recebeGasolina(1000);
        assertEquals(0, res);
    }
    
    @Test
    public void testAddGasolina2() {
        int res;
        depComb = new DepComb(300, 100, 100, 100);
        res = this.depComb.recebeGasolina(9000);
        assertEquals(300, res);
    }

    @Test
    public void testAddGasolina3() {
        int res;
        depComb = new DepComb(1000, 100, 100, 100);
        res = this.depComb.recebeGasolina(-1);
        assertEquals(-1, res);
    }

    @Test
    public void testAddGasolina4() {
        int res;
        depComb = new DepComb(10000, 100, 100, 100);
        res = this.depComb.recebeGasolina(100);
        assertEquals(0, res);
    }

    @Test
    public void testAddGasolina5() {
        int res;
        depComb = new DepComb(9900, 100, 100, 100);
        res = this.depComb.recebeGasolina(1000);
        assertEquals(100, res);
    }

    //------------------------------------------

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
        //------------------------------------------

        public void testAddAlcool1() {
            int res;
            depComb = new DepComb(100, 100, 1250, 1250); //2500
            res = this.depComb.recebeAlcool(1000);
            assertEquals(0, res);
        }

        public void testAddAlcool2() {
            int res;
            depComb = new DepComb(100, 100, 1000, 1000); //2000
            res = this.depComb.recebeAlcool(300);
            assertEquals(300, res);
        }

        public void testAddAlcool3() {
            int res;
            depComb = new DepComb(100, 100, 1250, 1250); //2500
            res = this.depComb.recebeAlcool(-1);
            assertEquals(-1, res);
        }

        public void testAddAlcool4() {
            int res;
            depComb = new DepComb(100, 100, 1250, 1250); //2500
            res = this.depComb.recebeAlcool(100);
            assertEquals(0, res);
        }

        public void testAddAlcool5() {
            int res;
            depComb = new DepComb(100, 100, 1200, 1200); //2400
            res = this.depComb.recebeAlcool(1000);
            assertEquals(100, res);
        }

        public void testAddAlcool6() {
            int res;
            depComb = new DepComb(100, 100, 1200, 1200); //2400
            res = this.depComb.recebeAlcool(99);
            assertEquals(98, res);//coloca 49 em cada tanque
        }

        //------------------------------------------

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

    public void testAddAditivo1() {
        int res;
        depComb = new DepComb(100, 500, 100, 100);
        res = this.depComb.recebeAlcool(1000);
        assertEquals(0, res);
    }

    public void testAddAditivo2() {
        int res;
        depComb = new DepComb(100, 200, 100, 100);
        res = this.depComb.recebeAlcool(300);
        assertEquals(300, res);
    }

    public void testAddAditivo3() {
        int res;
        depComb = new DepComb(100, 500, 100, 100); 
        res = this.depComb.recebeAlcool(-1);
        assertEquals(-1, res);
    }

    public void testAddAditivo4() {
        int res;
        depComb = new DepComb(100, 500, 100, 100); 
        res = this.depComb.recebeAlcool(100);
        assertEquals(0, res);
    }

    public void testAddAditivo5() {
        int res;
        depComb = new DepComb(100, 400, 100, 100); 
        res = this.depComb.recebeAlcool(1000);
        assertEquals(100, res);
    }
    

        //------------------------------------------

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