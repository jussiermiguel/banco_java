package bancoAvocado;

public class ContaPF extends Conta{
	public ContaPF() {
		setTipoConta("PF");
	}
	
	public float valorConta(float saldo, float valorDeposito, float valorSaque) {
		saldo = saldo + valorDeposito + valorSaque;
		return saldo;
		
	}
    @Override
    public float fazerDeposito(float valorDeposito) {
        return super.fazerDeposito(valorDeposito);
    }

    @Override
    public float fazerSaque(float valorSaque) {
        return super.fazerSaque(valorSaque * 1.25f);
    }
	/*
	public float fazerDeposito(float saldo, float valorDeposito) {
		saldo = (saldo + valorDeposito);
		return saldo;
	}
	
	public float fazerSaque(float saldo, float valorSaque) {
		saldo = (saldo - valorSaque) * 1.25f;
		return saldo;
	}*/
	
}