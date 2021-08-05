/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
/**
 *
 * @author sajawal
 */
public interface DBConnection {
    void testConnection() throws SQLException;
    void closeDBConnection() throws SQLException;
    ResultSet login(String username, String password)throws SQLException;
    String createStaffAcc(String staffid, String firstName, String surname, String jobTitle, String password, String email);
    String addCustomerAcc(String accountNo,String accountName, String title, String firstName, String surname, String address,String postcode, String city, String phoneNo, String valuedCustomer, String email);
    String addNewTask(int taskId, String location, String shelfslot, float price, int duration, String taskDescription, float StartTime);
    String addNewJob(String jobId, float due_amount,String urgent_job, String accountNo,String jobDescription, String date);
    boolean updateCustInfo(String accountNo,String accountName,String title,String firstName,String surname,String address,String postcode,String city,String phoneNo,String valuedCustomer, String status);
    String updateStaffAcc(String staffid, String firstName, String surname, String jobTitle, String password, String email);
    boolean updateJob(String jobId,float due_amount, String urgent_job, String accountNo, String jobDescription, String date); 
    boolean updateTask(int taskId, String location, String shelfslot, float price, int duration, String taskDescription, float StartTime,String TaskCompleted); 
    ResultSet displayAllJob() throws SQLException; //this displays all jobs works fine
    ResultSet displaySomeJob(String CustomerAccount_accountNo) throws SQLException;    
    ResultSet displayAllCust() throws SQLException; //this displays all customers this gets the customer information, sajawal done   
    ResultSet displaySomeCust(String valuedCustomer) throws SQLException;//this displays the valued customers or not
    ResultSet displayAllStaff() throws SQLException;
    ResultSet displaySomeStaff(String jobTitle) throws SQLException;
    ResultSet displayAllTask() throws SQLException;
    ResultSet displaySomeTask(String location) throws SQLException;
    
    ResultSet displayAllTasksForJob(String jobId) throws SQLException;//done
    
    boolean addTAsking(String jobId, String taskId, String fullName, String staffID);
    
    ResultSet displayAllTasksForJobsNoInput() throws SQLException;
    
    boolean CommenceATask(String completedBy, String JobId, String taskId);
    boolean CommenceATaskA(String startTime, String taskId);
    
    
    ResultSet displayIndividualPerfReport(String date, String datee) throws SQLException; //this is part A of indivdual report
    ResultSet displayInPerfReportTotalEffort(String date, String datee) throws SQLException;//this is part B of indivdual report
    
    ResultSet displaySummaryPerfReport1parta(String dateOne, String dateTwo) throws SQLException; //this is summary performance report table 1 part A
    ResultSet displaySummaryPerfReport1partb(String dateOne, String dateTwo) throws SQLException; //this is summary performance report table 1 part B
    
    ResultSet displaySummaryPerfReportdayTwoA(String dateOne, String dateTwo) throws SQLException;//DayTwo Part A
    ResultSet displaySummaryPerfReportdayTwoB( String dateOne, String dateTwo) throws SQLException;//DayTwo Part B
    
    ResultSet displaySummaryPerfReportdayThreeA( String dateOne, String dateTwo) throws SQLException; //DayThree part A
    ResultSet displaySummaryPerfReportdayThreeB( String dateOne, String dateTwo) throws SQLException;
    
    ResultSet displaySummaryPerfReportfinal1(String dateOne, String dateTwo) throws SQLException;//finsl things for period
    
    
    ResultSet displayCustomerSalesReport(String accountNo,String dateOne, String dateTwo) throws SQLException;//coded done
    
    ResultSet forgotPassword(String staffId)throws SQLException; //done and works
    
    ResultSet displayPaymentInfo(String customerId) throws SQLException; // done and works 
    ResultSet displayPaymenttotal(String customerId, String jobId) throws SQLException;
    
    boolean updateTaskPiro(String jobId, String taskId, String urgentTask);
    boolean updateJobPiro(String jobId, String urgentTask);
    
    
    boolean deleteCusAccount(String accountNo);//done
    boolean deleteTask(int taskId);//done
    ResultSet newJobAlert() throws SQLException; //done
    ResultSet displayJobAlert() throws SQLException;//done
    boolean newJobAlertUpdate(); //done
    ResultSet DisplaychangeTaskpirAlert() throws SQLException;//done
    boolean updateChangeTaskPirAlert();
    
    ResultSet changeTaskpirAlert() throws SQLException;
    
    String displaylerable(String customerId, String jobId);
    boolean inputCasPayment(String amountPaid,String customerId, String paymentDate);
    boolean inputCardPayment(String expiryDate,String type, String last_digits, String customerNo, String amountPaid, String paymentDate, String jobId, String pin);
    
    ResultSet jobDeadlineAlert() throws SQLException;//done
    
    boolean completeTask(String taskId, String jobId);
    
     ResultSet remindersDebtors() throws SQLException; //sends email to debtors
     
     ResultSet GenerateremindersLetter() throws SQLException;//for testiong
     
     boolean removeTasking(String jobId, String taskId);//this deletes the task
     
     public boolean completeJob(String jobId);
     ResultSet completeJobcheck(String jobId);
     
     ResultSet displayFixedTotal(String customerId, String jobId) throws SQLException;
     
     ResultSet displayvariableTotal(String accountNo, String jobId, String volumeDiscountId) throws SQLException;
     
    
 ///////////////////////Discount////////////////
     ResultSet setVariableDiscount(String discountRate, int discountID) throws SQLException;
    ResultSet setFixedDiscount(String discountRate, int discountID) throws SQLException;
    ResultSet setFlexibleDiscount(String discountRate, int discountID) throws SQLException;
    boolean updateDiscountType(String discountID, String accountNo, String discountType);
    boolean updateVariableDiscountType(String volumeDiscountId,  String discountID,String discountRate, String volume);
    boolean updateFixedDiscountType(String discountRate, String discountID);
    boolean updateFlexibleDiscountType(String discountRate, String taskID, String discountID);   
     


    
}
