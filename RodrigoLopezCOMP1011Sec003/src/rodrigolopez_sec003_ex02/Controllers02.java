package rodrigolopez_sec003_ex02;

import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controllers02 implements Initializable{

    @FXML
    private TextField address;

    @FXML
    private CheckBox basket;

    @FXML
    private Button btnDisplay;

    @FXML
    private RadioButton bussinessAnalyst;

    @FXML
    private TextField city;

    @FXML
    private RadioButton compScience;

    @FXML
    private TextField firstName;

    @FXML
    private CheckBox football;

    @FXML
    private TextArea outputDisplay;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField postCode;
    
    @FXML
    private TextField email;

    @FXML
    private TextField province;

    @FXML
    private CheckBox studentCoun;

    @FXML
    private ChoiceBox<String> subjectsList;
//    creating array for the type of major
   private String[] forCompScience = {"Python", "Swift", "PHP", "Database"};
   
   private String[] forBusinessAnalyst = {"Process Management", "Supply Chain", "Resource Planning"}; 
   
   private ToggleGroup majorToggleGroup; // initialize toogle
   
	@Override
    public void initialize(URL arg0, ResourceBundle arg1) {
		 majorToggleGroup = new ToggleGroup();
	        compScience.setToggleGroup(majorToggleGroup);
	        bussinessAnalyst.setToggleGroup(majorToggleGroup);

	        majorToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
	            updateSubjectsList();
	        }); 
	        updateSubjectsList();
    }
	private void updateSubjectsList() {
        subjectsList.getItems().clear();
        if (compScience.isSelected()) {
            subjectsList.getItems().addAll(forCompScience);
        } else if (bussinessAnalyst.isSelected()) {
            subjectsList.getItems().addAll(forBusinessAnalyst);
        } else {
            subjectsList.getItems().add("Choose a student's major!");
        }
    }

    @FXML
    private CheckBox swimming;

    @FXML
    private CheckBox volley;

    @FXML
    private CheckBox volunteer;
    
    
    @FXML
    private void displayValues() {
      try {  
    	    	  
    	  // setting up the variables
    	String firstNameText = firstName.getText();
    	String addressText = address.getText();
    	String provinceText = province.getText();
    	String cityText = city.getText();    	
        String phoneNumberText = phoneNumber.getText();
        String postCodeText = postCode.getText();
        String emailText = email.getText();   
     
             //validation process 
		if(!ValidateElements.validateFirstName(firstNameText)){
				outputDisplay.setText("Invalid first name");
				return;
			}
			String toPrintName = firstNameText;
		
		 if(!ValidateElements.validateAddress(addressText)){
				outputDisplay.setText("Invalid format address");
				return;
		}
		 String toPrintAddress = addressText;
		 
		 if(!ValidateElements.validateProvince(provinceText)){
			outputDisplay.setText("Invalid format province");
			return;
		}
		 String toPrintprovince = provinceText;
		 
		 if(!ValidateElements.validateCity(cityText)){
			outputDisplay.setText("Invalid format city");
			return;
		}
		 String toPrintCity = cityText;
		 
		if(!ValidateElements.validatePhoneNumber(phoneNumberText)){
			outputDisplay.setText("Invalid format Phone Number");
			return;
		}
		String toPrintPhoneNumber = phoneNumberText;
		
		if(!ValidateElements.validatePostCode(postCodeText)){
			outputDisplay.setText("Invalid format Postal Code");
			return;
		}
		String toPrintpostCode = postCodeText;

		if(!ValidateElements.validateEmail(emailText)){
			outputDisplay.setText("Invalid format email");
			return;
		}
		String toPrintEmail = emailText;
		
		
		String activities = "";// store the variables selected
		
//		print a messagge if non value is selected
		 if(!basket.isSelected() && !football.isSelected() && !swimming.isSelected() && !volley.isSelected() && !volunteer.isSelected()){
			 outputDisplay.setText("You have to choose at leat one activity!");
			 return;
		 } 
		
		 // store the value selected
		if (basket.isSelected()) {
			activities += basket.getText() + ", ";
        }
        if (football.isSelected()) {
        	activities += football.getText()+ ", ";
        }
        if (swimming.isSelected()) {
        	activities += swimming.getText()+ ", ";
        }
        if (volley.isSelected()) {
        	activities += volley.getText()+ ", ";
        }
        if (volunteer.isSelected()) {
        	activities += volunteer.getText()+ ", ";       	
        }
		 
        
        String majorAndSubject = ""; // to store the type of major
        
        // if the user do not select anything
        if (!compScience.isSelected() && !bussinessAnalyst.isSelected()) {
        	 outputDisplay.setText("You have to select a major");
			 return;
        }
        
//       if the user do not select any value of the list
        if (subjectsList.getValue() == null) {
        	outputDisplay.setText("Please enter a suject!");
			 return;
        }
        
//        depends of what major chose the display list show
        if (compScience.isSelected() || bussinessAnalyst.isSelected()) {
            if (compScience.isSelected()) {
                majorAndSubject += compScience.getText();
            } else {
                majorAndSubject += bussinessAnalyst.getText();
            }
            majorAndSubject += " Your selected subject is: " + subjectsList.getValue();
        }
        ///printing the information
        
        String result = String.format("Your name is: %s, your address is: %s, your province is: %s, your city is: %s,%n" +
                "Your phone number is: %s, your postal code is: %s, your email is: %s, " +
                "%nYour selected activities are: %s \nyour student major is in: %s",
                toPrintName, toPrintAddress, toPrintprovince, toPrintCity, toPrintPhoneNumber,
                toPrintpostCode, toPrintEmail, activities, majorAndSubject);
        
        outputDisplay.setText(result);
        
        
        // Cleaning the fields when the button is pressed
        
        firstName.setText("");
        address.setText("");
        province.setText("");
        city.setText("");
        phoneNumber.setText("");
        postCode.setText("");
        email.setText("");

        basket.setSelected(false);
        football.setSelected(false);
        swimming.setSelected(false);
        volley.setSelected(false);
        volunteer.setSelected(false);
        compScience.setSelected(false);
        bussinessAnalyst.setSelected(false);
        
        subjectsList.getSelectionModel().clearSelection();
        
      }catch(Exception e) {
    	  outputDisplay.setText("An error occurred: " + e.getMessage());
          e.printStackTrace();
      }
    }
       

}

