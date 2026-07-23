package com.example.demo.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity

public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 15)
	private String username;

	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid email address")
	private String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 255)
	private String password;

	@Transient
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotBlank(message = "Re Enter TO Confirm Password")
	private String confirmpassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public Login(Long id, @NotBlank(message = "Username is required") @Size(min = 3, max = 20) String username,
			@NotBlank(message = "Email is required") @Email(message = "Enter a valid email address") String email,
			@NotBlank(message = "Password is required") @Size(min = 6, max = 15) String password,
			@NotBlank(message = "Re Enter TO Confirm Password") String confirmpassword) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public Login() {
		super();
	}

}
