package com.tiago.helpdesk.domain.enums;

public enum Prioridade {

	/*
	 * O motivo da criação de perfis enumerados dessa forma é que, se um
	 * dia, alguém precisasse mexer no código e acrescentar uma nova prioridade
	 * como por exemplo URGENTE, e essa prioridade viesse após a prioridade
	 * BAIXA, no sistema as prioridades antigas são (BAIXA, MEDIA, ALTA) e ficaria
	 * (BAIXA, URGENTE, MEDIA, ALTA). Como não estava identificada a posição da prioridade antes
	 * o chamado que fosse cadastrado antes como prioridade MEDIA (posição 1) do sistema, ficaria
	 * como URGENTE. Pois a nova ordem seria: BAIXA(0), URGENTE(1), MEDIA(2) ALTA(3).
	 * Por isso é importante deixar no código uma posição já padronizada, para evitar esses problemas.
	 * */
	
	BAIXA(0, "BAIXA"),
	MEDIA(1, "MEDIA"),
	ALTA(2, "ALTA");
	
	private Integer codigo;
	private String descricao;
	
	private Prioridade(Integer codigo, String descricao) {
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
	
	public static Prioridade toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Prioridade x : Prioridade.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade inválida");
		
	}
	
}
