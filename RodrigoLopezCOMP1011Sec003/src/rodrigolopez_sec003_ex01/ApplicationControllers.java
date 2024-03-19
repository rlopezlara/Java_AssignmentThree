package rodrigolopez_sec003_ex01;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationControllers{


	@FXML
   private Button btnCalculateInterest;
 
	@FXML
     private TextField duration;
 
	@FXML
     private TextField interestRate;
 
	@FXML
    private TextField loanAmount;
	
	@FXML
    private TextField showInterest;

    @FXML
    private TextField number;

    @FXML
    private TextField showFactorial;

    @FXML
    private Button btbCalculate;

    @FXML
    private void showResult(ActionEvent event) {
        
    	try {
            if (!number.getText().isEmpty()) {
                int num = Integer.parseInt(number.getText());

                
                Factorial factorialTask = new Factorial(num); // initial the thread

                 
                ExecutorService executorService = Executors.newCachedThreadPool();
                executorService.execute(() -> {
                    factorialTask.run();
                    Platform.runLater(() -> showFactorial.setText(factorialTask.getResult().toString()));
                });
                
                
                executorService.shutdown();
                
            } else {
            	
                showFactorial.setText("No value entered");
                
            }
            
            
            if (!loanAmount.getText().isEmpty() && !interestRate.getText().isEmpty() && !duration.getText().isEmpty()) {
                double amount = Double.parseDouble(loanAmount.getText());
                double rate = Double.parseDouble(interestRate.getText());
                int dur = Integer.parseInt(duration.getText());

               
                CarLoanCalculator carLoanTask = new CarLoanCalculator(amount, rate, dur);// create a thread

               
                ExecutorService executorService2 = Executors.newCachedThreadPool();
                executorService2.execute(() -> {
                    carLoanTask.run();
                    Platform.runLater(() -> showInterest.setText(String.valueOf(carLoanTask.calculateFinalAmount())));
                });
                executorService2.shutdown();
            }else {
            	
            	showInterest.setText("No value entered");
            	
            }
            
        } catch (NumberFormatException e) {
          
            showFactorial.setText("Invalid input");
            showInterest.setText("Invalid input");
        }
        
        }
  
    
    }

