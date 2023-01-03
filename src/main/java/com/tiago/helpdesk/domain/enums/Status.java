package com.tiago.helpdesk.domain.enums;

public enum Status {

	/*
	 * O motivo da criação de perfis enumerados dessa forma é que, se um
	 * dia, alguém precisasse mexer no código e acrescentar um novo status
	 * como por exemplo CANCELADO, e esse status viesse após o status
	 * ABERTO, no sistema os status antigos são (ABERTO, ANDAMENTO, ENCERRADO) e ficaria
	 * (ABERTO, CANCELADO, ANDAMENTO, ENCERRADO). Como não estava identificada a posição do status antes
	 * o chamado que fosse cadastrado antes como ANDAMENTO (posição 1) do sistema, ficaria
	 * como CANCELADO. Pois a nova ordem seria: ABERTO (0), CANCELADO(1), ANDAMENTO(2) ENCERRADO(3).
	 * Por isso é importante deixar no código uma posição já padronizada, para evitar esses problemas.
	 * */
	
	ABERTO(0, "STATUS_"),
	ANDAMENTO(1, "STATUS_ANDAMENTO"),
	ENCERRADO(2, "STATUS_ENCERRADO");
	
	private Integer codigo;
	private String descricao;
	
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Status toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Status x : Status.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status inválido");
		
	}
	
}
