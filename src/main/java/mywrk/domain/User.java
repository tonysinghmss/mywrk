package mywrk.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import mywrk.validation.PasswordMatches;
import mywrk.validation.ValidEmail;

@PasswordMatches
public class User {
	@NotBlank(message = "Username cannot be empty.")
	@Size(min = 5, max = 16, message = "Username should be aleast 5 characters long and atmost 16 characters long.")
	private String userName;
	@NotBlank(message = "Password cannot be empty.")
	@Size(min = 8, message = "Password should be atleast 8 characters.")
	private String password;
	private String matchingPassword;
	@ValidEmail
	@NotBlank(message = "Email cannot be empty.")
	private String email;
	@NotBlank(message = "First name cannot be empty.")
	@Size(min = 5, max = 16, message = "First name should be aleast 5 characters long and atmost 16 characters long.")
	private String firstName;
	private String lastName;
	
	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [");
		if (userName != null) {
			builder.append("userName=");
			builder.append(userName);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (lastName != null) {
			builder.append("lastName=");
			builder.append(lastName);
		}
		builder.append("]");
		return builder.toString();
	}

}
