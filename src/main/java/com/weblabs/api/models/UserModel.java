package com.weblabs.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity(name="users")
public class UserModel {

	@Id @Column(name="user_id") public long userId;
	public String username;
	public String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="users_auths", 
    joinColumns=
        @JoinColumn(name="user_id", referencedColumnName="user_id"),
    inverseJoinColumns=
        @JoinColumn(name="auth_id", referencedColumnName="auth_id")
    )
	public List<AuthModel> authorities;
}
