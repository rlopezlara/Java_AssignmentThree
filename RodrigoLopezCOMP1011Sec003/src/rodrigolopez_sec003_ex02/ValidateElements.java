package rodrigolopez_sec003_ex02;

public class ValidateElements {
	
	
	public static boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Z][a-zA-Z]*");
     } 
    public static boolean validateAddress(String address) {
        return address.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
     }
    public static boolean validateProvince(String province) {
        return province.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
     }
    public static boolean validateCity(String city) {
        return city.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
     } 
    public static boolean validatePhoneNumber(String phoneNumber) {               
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }
    public static boolean validatePostCode(String postCode) {         
        return postCode.matches("[A-Za-z]\\d[A-Za-z] ?\\d[A-Za-z]\\d");
    }
    public static boolean validateEmail(String email) {         
        return email.matches("^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
    }
}
