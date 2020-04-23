package org;

public class DepComb {
    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tGasolina;
    private int tAditivo;
    private int tAlcool1;
    private int tAlcool2;

    public DepComb(int tGasolina,int tAditivo,int tAlcool1,int tAlcool2){
        this.tGasolina = tGasolina;
        this.tAditivo = tAditivo;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;
    }

    public int gettGasolina(){ return tGasolina; }
    public int gettAditivo(){ return tAditivo; }
    public int gettAlcool1(){ return tAlcool1; }
    public int gettAlcool2(){ return tAlcool2; }

    public int recebeAditivo(int qtdade){
        if(qtdade<0)return -1;
        int maxAdd=MAX_ADITIVO - tAditivo;
        if(qtdade<=maxAdd){
            //se a qtdade for menor ou igual ao maximo adicionavel, adiciona e retorna.
            tAditivo+=qtdade;
            return qtdade;
        }
        // se nao adiciona o maximo e retorna.
        tAditivo+=maxAdd;
        return maxAdd;
    }

    public int recebeGasolina(int qtdade){
        if(qtdade<0)return -1;
        int maxAdd=MAX_GASOLINA - tGasolina;
        if(qtdade<=maxAdd){
            //se a qtdade for menor ou igual ao maximo adicionavel, adiciona e retorna.
            tGasolina+=qtdade;
            return qtdade;
        }
        // se nao adiciona o maximo e retorna.
        tGasolina+=maxAdd;
        return maxAdd;
    }

    public int recebeAlcool(int qtdade){
        if(qtdade<=0)return -1;
        if(qtdade%2==1)qtdade--;//se for impar nao da pra armazenar 1 litro porque tem que manter a mesma quantidade em 2 tanques
        int maxAdd = MAX_ALCOOL - (tAlcool1 + tAlcool2);
        if(qtdade<=maxAdd){
            //se a qtdade for menor ou igual ao maximo adicionavel, adiciona e retorna.
            tAlcool1+=qtdade/2;
            tAlcool2+=qtdade/2;
            return qtdade;
        }
        // se nao adiciona o maximo e retorna.
        tAlcool1+=maxAdd/2;
        tAlcool2+=maxAdd/2;
        return maxAdd;
    }

    public int[] encomendaCombustivel(int qtdade,boolean emerg){
        if(qtdade<0){
            //valor invalido
            int[] ret = {-2,0,0,0};
            return ret;
        }
        int[] ret = new int[4];//aditivo, gasolina, alc1, alc2.
        //reais valores a se trabalhar
        double rGasolina=tGasolina;
        double rAditivo=tAditivo;
        double rAlcool=tAlcool1+tAlcool2;
        if(!emerg){
            //se nao for emergencia diz que o real valor é ele mesmo - 25% que tem que guardar.
            rGasolina-=MAX_GASOLINA*0.25;
            rAditivo-=MAX_ADITIVO*0.25;
            rAlcool-=MAX_ALCOOL*0.25;
        }
        double precisaGasolina=qtdade*0.7;
        double precisaAditivo=qtdade*0.05;
        double precisaAlcool=qtdade*0.25;
        if(rAditivo<precisaAditivo || rGasolina<precisaGasolina || rAlcool<precisaAlcool){
            //se algum ou alguns sao insuficientes, descobre quais preenche com -1 e retorna.
            if(rAditivo<precisaAditivo)ret[0]=-1;
            else ret[0]=0;
            if(rGasolina<precisaGasolina)ret[1]=-1;
            else ret[1]=0;
            if(rAlcool<precisaAlcool)ret[2]=-1;
            else ret[2]=0;
            ret[3]=0;
            return ret;
        }
        //se nao preenche normal e subtrai os valores corretos.
        tAditivo-=(int)precisaAditivo;
        ret[0]=tAditivo;
        tGasolina-=(int)precisaGasolina;
        ret[1]=tGasolina;
        tAlcool1-=(int)(precisaAlcool/2);
        ret[2]=tAlcool1;
        tAlcool2-=(int)(precisaAlcool/2);
        ret[3]=tAlcool2;
        return ret;
    }
    
    @Override
    public String toString() {
        return "DepComb [tAditivo=" + tAditivo +
               ", tAlcool1=" + tAlcool1 +
               ", tAlcool2=" + tAlcool2 + 
               ", tGasolina="+ tGasolina + "]";
    }
}