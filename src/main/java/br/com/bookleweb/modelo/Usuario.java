package br.com.bookleweb.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.bookleweb.util.CriptografiaSenha;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@NotNull(message="{usuario.matricula.vazio}")
	private Integer matricula;
	
	private String nome;
	
	private String email;
	
	@NotEmpty(message="{usuario.senha.vazio}")
	private String senha;
	
	private String permissao ;
	
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = CriptografiaSenha.md5(senha);
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
