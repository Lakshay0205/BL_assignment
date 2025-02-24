import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed.");
    }

    public void performPublicTask(){
        System.out.println("Public task performed.");
    }
}

class UserContext {
    private String role;

    public UserContext(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

public class RoleBasedAccessControl {

    public static void main(String[] args) {
        AdminService adminService = new AdminService();

        UserContext adminUser = new UserContext("ADMIN");
        UserContext regularUser = new UserContext("USER");

        invokeMethod(adminService, "performAdminTask", adminUser);
        invokeMethod(adminService, "performAdminTask", regularUser);
        invokeMethod(adminService, "performPublicTask", regularUser);

    }

    public static void invokeMethod(Object obj, String methodName, UserContext userContext) {
        try {
            Method method = obj.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (userContext.getRole().equals(roleAllowed.value())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                method.invoke(obj); // Allow access if no RoleAllowed annotation
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}