import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class practice {
    public static void main(String[] args) {
        CustomerCreateRequest request = new CustomerCreateRequest("Amina Khan", "amina.khan@example.com");
        Customer entity = request.toEntity();
        System.out.println(entity);
    }

    public record Customer(Long id, String fullName, String email) {
    }

    public record CustomerCreateRequest(
            @NotBlank(message = "fullName is required")
            @Size(min = 2, max = 100, message = "fullName must be between 2 and 100 characters")
            String fullName,

            @NotBlank(message = "email is required")
            @Email(message = "email must be valid")
            String email
    ) {
        public CustomerCreateRequest {
            fullName = fullName == null ? null : fullName.trim();
            email = email == null ? null : email.trim();
        }

        public Customer toEntity() {
            return new Customer(null, fullName, email);
        }
    }
}