package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;
import br.calebe.ticketmachine.core.Troco;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    private int qtd_valor;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};
    private Troco troco = null;
    

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean getTroco() {
        System.out.println("Saldo = " + this.saldo);
        if(this.saldo > 0){
            troco = new Troco(this.saldo);
            Iterator it;
            it = troco.getIterator();

            System.out.println("Devolvendo Troco: " + this.saldo);

            while(it.hasNext()){
                System.out.println("Processando...");
                it.next();
            }

            return true;
        }else{
            return false;
        }
    }

    public String solicitaBilhete(Integer qtdBilhete){
        
        if((qtdBilhete*this.valor) <= this.saldo){
            for(int i = 1; i <= qtdBilhete; i++){
                this.saldo -= this.valor;
                System.out.println("Impriminto Bilhete " + i);
            }
            return "Bilhetes comprados com sucesso!";
        }else{
            return "Saldo Insuficiente";
        }
    }
    
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }else{
            String result = "*****************\n";
            result += "*** R$ " + saldo + ",00 ****\n";
            result += "*****************\n";
            return result;
        }
    }
}