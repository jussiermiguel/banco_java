package bancoAvocado;

public class ContaPJ extends Conta{
	public ContaPJ() {
		setTipoConta("PJ");
	}
	public float valorConta(float saldo, float valorDeposito, float valorSaque) {
		saldo = saldo + valorDeposito + valorSaque;
		return saldo;
		
	}
	@Override
	public float fazerDeposito(float valorDeposito) {
		return super.fazerDeposito(valorDeposito*1.5f);
	}
	
	@Override
	public float fazerSaque(float valorSaque) {
		return super.fazerSaque(valorSaque);
	}
	/*
	public float fazerDeposito(float saldo, float valorDeposito) {
		saldo = (saldo + valorDeposito) * 1.5f;
		return saldo;
	}
	public float fazerSaque(float saldo, float saque) {
		saldo = (saldo - saque);
		return saldo;
	}*/
	
}
