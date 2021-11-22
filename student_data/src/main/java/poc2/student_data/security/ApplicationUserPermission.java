package poc2.student_data.security;

public enum ApplicationUserPermission {
	STUDENT_READ("student:read"), STUDENT_WRITE("student:write");

	private final String permission;


	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}


	public String getPermission() {
		return permission;
	}

}
