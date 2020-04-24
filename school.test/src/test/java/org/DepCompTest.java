package org;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepCombTest {

    DepComb depComb;

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
        assertEquals(9000, res);
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
    public void testAddAlcool1() {
        int res;
        depComb = new DepComb(100, 100, 1250, 1250); //2500
        res = this.depComb.recebeAlcool(1000);
        assertEquals(0, res);
    }
    @Test
    public void testAddAlcool2() {
        int res;
        depComb = new DepComb(100, 100, 1000, 1000); //2000
        res = this.depComb.recebeAlcool(300);
        assertEquals(300, res);
    }
    @Test
    public void testAddAlcool3() {
        int res;
        depComb = new DepComb(100, 100, 1250, 1250); //2500
        res = this.depComb.recebeAlcool(-1);
        assertEquals(-1, res);
    }
    @Test
    public void testAddAlcool4() {
        int res;
        depComb = new DepComb(100, 100, 1250, 1250); //2500
        res = this.depComb.recebeAlcool(100);
        assertEquals(0, res);
    }
    @Test
    public void testAddAlcool5() {
        int res;
        depComb = new DepComb(100, 100, 1200, 1200); //2400
        res = this.depComb.recebeAlcool(1000);
        assertEquals(100, res);
    }
    @Test
    public void testAddAlcool6() {
        int res;
        depComb = new DepComb(100, 100, 1200, 1200); //2400
        res = this.depComb.recebeAlcool(99);
        assertEquals(98, res);//coloca 49 em cada tanque
    }

    //------------------------------------------

    @Test
    public void testAddAditivo1() {
        int res;
        depComb = new DepComb(100, 500, 100, 100);
        res = this.depComb.recebeAditivo(1000);
        assertEquals(0, res);
    }
    @Test
    public void testAddAditivo2() {
        int res;
        depComb = new DepComb(100, 200, 100, 100);
        res = this.depComb.recebeAditivo(300);
        assertEquals(300, res);
    }
    @Test
    public void testAddAditivo3() {
        int res;
        depComb = new DepComb(100, 500, 100, 100);
        res = this.depComb.recebeAditivo(-1);
        assertEquals(-1, res);
    }
    @Test
    public void testAddAditivo4() {
        int res;
        depComb = new DepComb(100, 500, 100, 100);
        res = this.depComb.recebeAditivo(100);
        assertEquals(0, res);
    }
    @Test
    public void testAddAditivo5() {
        int res;
        depComb = new DepComb(100, 400, 100, 100);
        res = this.depComb.recebeAditivo(1000);
        assertEquals(100, res);
    }


    //------------------------------------------

    @Test
    public void testEncomendaCombustivelEmergencial1(){
        depComb = new DepComb(10000, 500, 1250, 1250); //todos os tanques cheios
        int[] res = this.depComb.encomendaCombustivel(1000, true);
        assertArrayEquals(new int[]{450,9300,1125,1125}, res);
    }

    @Test
    public void testEncomendaCombustivelEmergencial2(){
        depComb = new DepComb(10000, 0, 1250, 1250);
        int[] res = this.depComb.encomendaCombustivel(1000, true);
        assertArrayEquals(new int[]{-1,0,0,0}, res);
    }

    //-------------------------

    @Test
    public void testEncomendaCombustivelNaoEmergencial1(){
        depComb = new DepComb(10000, 500, 1250, 1250);
        int[] res = this.depComb.encomendaCombustivel(-1, false);
        assertArrayEquals(new int[]{-2,0,0,0}, res);
    }

    @Test
    public void testEncomendaCombustivelNaoEmergencial2(){
        depComb = new DepComb(10000, 500, 1250, 1250);
        int[] res = this.depComb.encomendaCombustivel(-1, false);
        assertArrayEquals(new int[]{-2,0,0,0}, res);
    }

    @Test
    public void testEncomendaCombustivelNaoEmergencial3(){
        depComb = new DepComb(0, 500, 1250, 1250);
        int[] res = this.depComb.encomendaCombustivel(1000, false);
        assertArrayEquals(new int[]{0,-1,0,0}, res);
    }

    @Test
    public void testEncomendaCombustivelNaoEmergencial4(){
        depComb = new DepComb(10000, 500, 0, 0);
        int[] res = this.depComb.encomendaCombustivel(1000, false);
        assertArrayEquals(new int[]{0,0,-1,0}, res);
    }

    @Test
    public void testEncomendaCombustivelNaoEmergencial5(){
        depComb = new DepComb(10000, 500, 1250, 1250);
        int[] res = this.depComb.encomendaCombustivel(1000, false);
        assertArrayEquals(new int[]{450,9300,1125,1125}, res);
    }
}