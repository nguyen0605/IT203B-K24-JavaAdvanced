package btkha2;

@FunctionalInterface
interface PasswordValidator {
    boolean isValid(String password);
}
