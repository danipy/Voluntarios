package mx.voluntarios.enums;

public enum UserRole {
	VOLUNTEER("ROLE_VOLUNTEER"), ONG("ROLE_ONG");

	private String role;

	UserRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

}
