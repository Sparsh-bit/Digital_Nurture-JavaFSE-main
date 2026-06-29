public class SecretLogic {
    public void authenticate(String password) {
        if (password.equals("SuperSecret123")) {
            System.out.println("Access Granted");
        }
    }
}