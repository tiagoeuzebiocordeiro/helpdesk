package com.tiago.helpdesk.domain.enums;

public enum Perfil {

	/*
	 * O motivo da criação de perfis enumerados dessa forma é que, se um
	 * dia, alguém precisasse mexer no código e acrescentar um novo cargo (role)
	 * como por exemplo GESTOR, e esse cargo viesse após a role
	 * ADMIN, no sistema as roles antigas são (ADMIN, CLIENTE, TECNICO) e ficaria
	 * (ADMIN, GESTOR, CLIENTE TECNICO). Como não estava identificada a posição da role antes
	 * a pessoa que fosse cadastrada como CLIENTE (posição 1) do sistema, ficaria
	 * como GESTOR. Pois a nova ordem seria: ADMIN (0), GESTOR(1), CLIENTE(2) TECNICO(3).
	 * Por isso é importante deixar no código uma posição já padronizada, para evitar esses problemas.
	 * */
	
	ADMIN(0, "ROLE_ADMIN"),
	CLIENTE(1, "ROLE_CLIENTE"),
	TECNICO(2, "ROLE_TECNICO");
	
	private Integer codigo;
	private String descricao;
	
	private Perfil(Integer codigo, String descricao) {
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
	
	public static Perfil toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (Perfil x : Perfil.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil inválido");
		
	}
	
}
