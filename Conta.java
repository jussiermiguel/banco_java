package bancoAvocado;

public class Conta {
	private String nomeUsuario;
	private String tipoConta;
	private float saldo = 0;
	private float valorDeposito = 0;
	private float valorSaque = 0;

	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getDeposito() {
		return valorDeposito;
	}
	public void setValorDeposito(float valorDeposito) {
		this.valorDeposito = valorDeposito;
	}
	public float getValorSaque() {
		return valorSaque;
	}
	public void setSaque(float valorSaque) {
		this.valorSaque = valorSaque;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public float valorConta() {
		saldo = saldo + valorDeposito + valorSaque;
		return saldo;
		
	}
	
	public float fazerDeposito(float valorDeposito) {
		//saldo += valorDeposito;
		this.valorDeposito = valorDeposito;
		saldo = saldo + valorDeposito;
		return saldo;
	}
	public float fazerSaque(float valorSaque) {
		//saldo -= valorSaque;
		this.valorSaque = valorSaque;
		saldo = saldo - valorSaque;
		return saldo;
	}

	
}