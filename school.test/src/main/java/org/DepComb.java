public class DepComb {
    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tGasolina;
    private int tAditivo;
    private int tAlcool1;
    private int tAlcool2;

    public DepComb(int tGasolina, int tAditivo, int tAlcool1, int tAlcool2) {
        this.tGasolina = tGasolina;
        this.tAditivo = tAditivo;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
    }

    public int gettGasolina() {
        return tGasolina;
    }

    public int gettAditivo() {
        return tAditivo;
    }

    public int gettAlcool1() {
        return tAlcool1;
    }

    public int gettAlcool2() {
        return tAlcool2;
    }

    public int recebeAditivo(int qtdade) {
        if (qtdade < 0)
            return -1;
        if (this.gettAditivo() == DepComb.MAX_ADITIVO)
            return 0;
        if (qtdade + this.gettAditivo() > DepComb.MAX_ADITIVO) {
            int total = qtdade + this.gettAditivo();
            int remainder = total % DepComb.MAX_ADITIVO;
            int canAdd = DepComb.MAX_ADITIVO * remainder;
            this.tAditivo += canAdd;
            return canAdd;
        }

        return this.gettAditivo();
    }

    public int recebeGasolina(int qtdade) {
        if (qtdade < 0)
            return -1;
        if (this.gettGasolina() == DepComb.MAX_GASOLINA)
            return 0;
        if (qtdade + this.gettGasolina() > DepComb.MAX_GASOLINA) {
            int total = qtdade + this.gettGasolina();
            int remainder = total % DepComb.MAX_GASOLINA;
            int canAdd = DepComb.MAX_GASOLINA * remainder;
            this.tGasolina += canAdd;
            return canAdd;
        }

    }

    public int recebeAlcool(int qtdade) {
        if (qtdade < 0)
            return -1;
        int totalSomado = this.gettAlcool1() + this.gettAlcool2();
        if (totalSomado == DepComb.MAX_ALCOOL)
            return 0;
        if (qtdade + totalSomado > DepComb.MAX_ALCOOL) {
            int total = qtdade + totalSomado;
            int remainder = total % DepComb.MAX_ALCOOL;
            int canAdd = DepComb.MAX_ALCOOL * remainder;
            this.tAlcool1 += canAdd / 2;
            this.tAlcool2 += canAdd / 2;
            return canAdd;
        }
    }

    public int[] encomendaCombustivel(int qtdade, boolean emerg) {
        int[] productRemainder = new int[3];
        int qtdGasolina;
        int qtdAlcool;
        int qtdAditivo;
        
        qtdGasolina = (int) (qtdade * 0.70);
        qtdAlcool =   (int) (qtdade * 0.25);
        qtdAditivo =  (int) (qtdade * 0.05);

        if(emerg){


        }
        else{
            if(this.gettGasolina() - qtdGasolina < DepComb.MAX_GASOLINA * 0.25 )
                productRemainder[0] = -1;
        }
        return null;
    }

    @Override
    public String toString() {
        return "DepComb [tAditivo=" + tAditivo + ", tAlcool1=" + tAlcool1 + ", tAlcool2=" + tAlcool2 + ", tGasolina="
                + tGasolina + "]";
    }
}