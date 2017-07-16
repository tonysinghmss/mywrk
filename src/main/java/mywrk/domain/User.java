package mywrk.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@NotNull(message="Please give a username.")
	@Size(min = 5, max = 16)
	private String userName;
	@NotNull(message="Please give a password.")
	@Size(min = 8, message="Password should be atleast 8 characters.")
	private String password;
	@NotNull
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Wrong email!")
	private String email;
	@NotNull
	@Size(min = 5, max = 16)
	private String firstName;
	@Size(min = 5, max = 16)
	private String lastName;

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
