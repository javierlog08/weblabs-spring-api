package com.weblabs.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="auths")
public class AuthModel {

	@Id @Column(name="auth_id") public long authId;
	public String name;
}
