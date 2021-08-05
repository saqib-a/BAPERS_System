/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DB.*;
import Entity.*;
import GUI.*;
import com.itextpdf.text.PageSize;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;


/**
 *
 * @author sajawal
 */
public class controller {

    static DBConnection conn = new MyDBConnection(); 
    static Staff st;

    public controller() {
    }

    static public boolean login(String Username, String password) { //this runs the login test
        ResultSet resultSet;
        boolean passed = false;
        try {
            resultSet = conn.login(Username, password);
            if (!resultSet.isBeforeFirst()) {
                System.out.println("WRONG login information entered");
                passed = false;
                conn.closeDBConnection();
            } else {
                resultSet.next();
                String staffId = resultSet.getString("staffId");
                String firstName = resultSet.getString("firstName");
                String surname = resultSet.getString("surname");
                String jobTitle = resultSet.getString("jobTitle");
                if (jobTitle.equals("Office Manager")) {
                    st = new OfficeManager(staffId, firstName, surname, jobTitle);
                    passed = true;
                } else if (jobTitle.equals("Shift Manager")) {
                    st = new ShiftManager(staffId, firstName, surname, jobTitle);
                    passed = true;
                } else if (jobTitle.equals("Development Technician") || jobTitle.equals("CopyRoom Technician") || jobTitle.equals("PackingRoom Technician") || jobTitle.equals("FinishingRoom Technician") ) {
                    st = new Technician(staffId, firstName, surname, jobTitle);
                    passed = true;
                } else if (jobTitle.equals("Receptionist")) {
                    st = new Receptionist(staffId, firstName, surname, jobTitle);
                    passed = true;
                }
                System.out.println(staffId + firstName + surname + jobTitle);
                conn.closeDBConnection();
            }
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION!");
        }

        return passed;
    }

    public static boolean addStaffAccount(String staffid, String firstName, String surname, String jobTitle, String password, String email) { //adds the staff account

        String addStaff = conn.createStaffAcc(staffid, firstName, surname, jobTitle, password, email);
        if (addStaff.equals("done")) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean addCustomerAcc(String accountNo, String accountName, String title, String firstName, String surname, String address, String postcode, String city, String phoneNo, String valuedCustomer, String email) {
        String addCust = conn.addCustomerAcc(accountNo, accountName, title, firstName, surname, address, postcode, city, phoneNo, valuedCustomer, email);//adds the customer account
        if (addCust.equals("done")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addTask(int taskId, String location, String shelfslot, float price, int duration, String taskDescription, float StartTime) {

        String addTask = conn.addNewTask(taskId, location, shelfslot, price, duration, taskDescription, StartTime);
        if (addTask.equals("done")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean addJob(String jobId, float due_amount, String urgent_job, String accountNo, String jobDescription, String date) {

        String addJob = conn.addNewJob(jobId, due_amount, urgent_job, accountNo, jobDescription, date); //adds the jobs
        if (addJob.equals("done")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean updateCustInfo(String accountNo, String accountName, String title, String firstName, String surname, String address, String postcode, String city, String phoneNo, String valuedCustomer, String status) {
        return conn.updateCustInfo(accountNo, accountName, title, firstName, surname, address, postcode, city, phoneNo, valuedCustomer, status); //fully working saj, uodates customer info
    }

    public static boolean updateStaffAcc(String staffid, String firstName, String surname, String jobTitle, String password, String email) {//updates the staff account
        String test = conn.updateStaffAcc(staffid, firstName, surname, jobTitle, password, email); //fully working saj
        if (test.equals("done")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean updateJob(String jobId, float due_amount, String urgent_job, String accountNo, String jobDescription, String date) {
        return conn.updateJob(jobId, due_amount, urgent_job, accountNo, jobDescription, date); //updates the job with the above information
    }

    public static boolean updateTask(int taskId, String location, String shelfslot, float price, int duration, String taskDescription, float StartTime, String TaskCompleted) {
        return conn.updateTask(taskId, location, shelfslot, price, duration, taskDescription, StartTime, TaskCompleted);//updates the task with the above information
    }
    public static boolean  addTAsking(String jobId, String taskId, String fullName, String staffID) {
        return  conn.addTAsking(jobId, taskId, fullName, staffID);//updates the job_has_task with the above information
    }

    public static ResultSet displayAllJob() { //this is called in the GUI to display all jobs
        try {
            return conn.displayAllJob();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySomeJob(String CustomerAccount_accountNo) { // displays the jobs by customer account
        try {
            return conn.displaySomeJob(CustomerAccount_accountNo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displayAllCust() { //display all the customer account
        try {
            return conn.displayAllCust();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySomeCust(String valuedCustomer) { //search by if valued or not
        try {
            return conn.displaySomeCust(valuedCustomer);
        } catch (SQLException ex) {
        }
        return null;
    } 

    public static ResultSet displayAllStaff() { //out all staff info
        try {
            return conn.displayAllStaff();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySomeStaff(String jobTitle) { //displays the staff
        try {
            return conn.displaySomeStaff(jobTitle);
        } catch (SQLException ex) {
        }
        return null;
    }
    public static ResultSet displayAllTasksForJob(String jobId){ // out put all of the tasks for  job
     try {
            return conn.displayAllTasksForJob(jobId);
        } catch (SQLException ex) {
        }
        return null;
    }
    public static ResultSet displayAllTasksForJobsNoInput() {
    try {
            return conn.displayAllTasksForJobsNoInput();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displayAllTask() { //all task
        try {
            return conn.displayAllTask();
        } catch (SQLException ex) {
        }
        return null;

    }

    public static ResultSet displaySomeTask(String location) {  //some tasks displayed
        try {
            return conn.displaySomeTask(location);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displayIndividualPerfReport(String date, String datee) { // displays the report
        try {
            return conn.displayIndividualPerfReport(date, datee);
        } catch (SQLException ex) {
        }
        return null;

    }

    public static ResultSet displayInPerfReportTotalEffort(String date, String datee) {
        try {
            return conn.displayInPerfReportTotalEffort(date, datee);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displayCustomerSalesReport(String accountNo, String dateOne, String dateTwo) { // this calls the method in DbConnection to display the sales report
        try {
            return conn.displayCustomerSalesReport(accountNo, dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySummaryPerfReport1parta(String dateOne, String dateTwo) { // this is for day shift 1 saj
        try {
            return conn.displaySummaryPerfReport1parta(dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySummaryPerfReport1partb(String dateOne, String dateTwo) { // this is for day shift 1 saj
        try {
            return conn.displaySummaryPerfReport1partb(dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySummaryPerfReportdayTwoA(String dateOne, String dateTwo) { //day shift 2 part A
        try {
            return conn.displaySummaryPerfReportdayTwoA(dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySummaryPerfReportdayTwoB(String dateOne, String dateTwo) { //day shift 2 part B
        try {
            return conn.displaySummaryPerfReportdayTwoB(dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySummaryPerfReportdayThreeA(String dateOne, String dateTwo) {
        try {
            return conn.displaySummaryPerfReportdayThreeA(dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySummaryPerfReportdayThreeB(String dateOne, String dateTwo) {
        try {
            return conn.displaySummaryPerfReportdayThreeB(dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ResultSet displaySummaryPerfReportfinal1(String dateOne, String dateTwo) {
        try {
            return conn.displaySummaryPerfReportfinal1(dateOne, dateTwo);
        } catch (SQLException ex) {
        }
        return null;
    }

    public static boolean deleteCusAccount(String accountNo) { //delete customer account 
        return conn.deleteCusAccount(accountNo);
    }

    public static boolean deleteTask(int taskId) {
        return conn.deleteTask(taskId);
    }
    public static boolean CommenceATask(String completedBy, String JobId, String taskId){ //this starts a task
        return conn.CommenceATask(completedBy,JobId,taskId);
    }
    public static boolean CommenceATaskA(String startTime, String taskId){
        return conn.CommenceATaskA(startTime, taskId);
    }
    public static ResultSet displayPaymentInfo(String customerId){
     try {
            return conn.displayPaymentInfo(customerId);
        } catch (SQLException ex) {
        }
        return null;
    }
    public static ResultSet displayPaymenttotal(String customerId, String jobId){
     try {
            return conn.displayPaymenttotal(customerId,jobId);
        } catch (SQLException ex) {
        }
        return null;
    }
    public static boolean displaylerable(String customerId, String jobId){
        
        String totoal = conn.displaylerable(customerId, jobId);
        
        if (totoal.equals("done")) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean inputCasPayment(String amountPaid,String customerId, String paymentDate) { //taking payment cash
        
            return conn.inputCasPayment(amountPaid,customerId,paymentDate);
    }
    public static boolean inputCardPayment(String expiryDate,String type, String last_digits, String customerNo, String amountPaid, String paymentDate, String jobId, String pen){
        return conn.inputCardPayment(expiryDate,type, last_digits, customerNo, amountPaid, paymentDate, jobId, pen); //taking payment card
    }
    public static boolean updateTaskPiro(String jobId, String taskId, String urgentTask){
        return conn.updateTaskPiro(jobId,taskId,urgentTask);
    }
    public static boolean updateJobPiro(String jobId, String urgentTask){ //set job prioirty
        return conn.updateJobPiro(jobId,urgentTask);
    }

    public static boolean newJobAlert() { //this method alerts the office manager or shift manager of a new job
        ResultSet resultSet;
        boolean passed = false;
        try {
            resultSet = conn.newJobAlert();
            resultSet.next();
            String Alerted = resultSet.getString("Alerted");
            if (Alerted.equals("false")) {
                NewJobAlert d = new NewJobAlert();
                d.fetchAll();
                d.setVisible(true);
                passed = true;
            }
            conn.closeDBConnection();

        } catch (SQLException ex) {
            System.out.println("newJobAlert failed");
        }

        return passed;
    }
    public static ResultSet displayJobAlert(){ //this is to display all the new jobs to alert
     try {
            return conn.displayJobAlert();
        } catch (SQLException ex) {
        }
        return null;
    }
    public static boolean taskpirporAlert() { //this method alerts the office manager or shift manager of a new job
        ResultSet resultSet;
        boolean passed = false;
        try {
            resultSet = conn.changeTaskpirAlert();
            resultSet.next();
            String Alerted = resultSet.getString("taskAlert");
            if (Alerted.equals("false")) {
                TaskPriorityAlert v = new TaskPriorityAlert();
                v.setVisible(true);
                passed = true;
            }
            conn.closeDBConnection();

        } catch (SQLException ex) {
            System.out.println("taskpir failed");
        }

        return passed;
    }
    public static ResultSet DisplaychangeTaskpirAlert(){ //this this ables all tasks that have have had there priority changed
        try {
        return conn.DisplaychangeTaskpirAlert();
        } catch (SQLException ex) {
        }
        return null;
    }
    public static boolean updateChangeTaskPirAlert(){
        return conn.updateChangeTaskPirAlert();
    } 
    public static boolean completeTask(String taskId, String jobId){
        return conn.completeTask(taskId, jobId);
    }

    public static Date currentDate() { //this gets us the current date

        return new java.util.Date();
    }
    
    public static boolean jobDeadlineAlert() { //alerts the shift manager and the office manager of a deadline approaching
        ResultSet resultSet;
        boolean passed = false;
        
        try {
            resultSet = conn.jobDeadlineAlert();
            boolean stop = false;
            while (resultSet.next() && !stop) {

                Date date = resultSet.getTimestamp("Date");
                Date currentDate = currentDate();
                long milDif =  currentDate.getTime() - date.getTime();
                long fiveMilli = (5 * 24 * 60 * 60 * 1000);
                System.out.println("doff " + milDif/(fiveMilli/5) +" "+ resultSet.getString("jobId"));
                if (milDif < -(fiveMilli)) { //less the 
                    System.out.println("Stopped");
                    stop = true;
                } else if (milDif > -fiveMilli && milDif < 0) { //less then 5 days
                    //Add to list
                    System.out.println(milDif);
                    DeadlineComingUpAlert v = new DeadlineComingUpAlert(); 
                    v.fetchAll();
                    v.setVisible(true);
 
                } else {  // this means Date is greater then CurrentDate overdue
                    OverDueAlert d = new OverDueAlert();
                    d.setVisible(true);
                    }
            }
            passed = true;
            conn.closeDBConnection();

        } catch (SQLException ex) {
            System.out.println("jobDeadlineAlert done");
        }

        return passed;
    }
    public static void generatRimderLetter(String customerID,String JobId,String paymentDue,String addressA,String addressCity,String addressPostcode,String customerName, String Date){
        Document document = new Document(PageSize.A4);
        document.addAuthor("Sajawa Kiani");
        document.addTitle("OVERDUE PAYMENT");
        System.out.print("document created...");
        try{
            PdfWriter.getInstance(document, new FileOutputStream("letter.pdf"));
            document.open();
            
            Paragraph para = new Paragraph("Invoice Reminders\n" 
                    
                    + "\n"
                    +customerID+ "\n"
                    +customerName + "\n"
                    +addressA + "\n" 
                    + addressCity + "\n"
                    + addressPostcode +"\n" 
                   
                    + "\n"
                    + "\n" 
                    +"The Lab \n"
                    + "Bloomsbury’s Image Processing Laboratory 2,\n" 
                    +"27 Sainsbury Close, \n" 
                    +"Stratford, \n" 
                    +"Essex EJ6 5TJ \n" 
                    +"18th January 2018 \n"
                    +"Phone: 0207 235 7534 \n"
                    + "\n"
                    + "\n" 
                    +"Dear" +" "+ customerName +", \n"
                    + "\n" 
                    +"REMINDER - INVOICE NO.: 197362 Job No:" + JobId + " " + "Total Amount:£" + paymentDue + "\n"  
                    +"According to our records, it appears that we have not yet received payment of the above invoice, which was posted to you on" + " " +Date+ ", for photographic work done in our laboratory. \n"
                    +"We would appreciate payment at your earliest convenience.\n" 
                    +"If you have already sent a payment to us recently, please accept our apologies. \n"
                    + "\n"
                    + "\n" 
                    +"Yours sincerely,\n"
                    +"BAPERS");
            document.add(para);
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        document.close();
        
    }
    /*public static boolean genremindersLetter() { //alerts the shift manager and the office manager of a deadline approaching
        ResultSet resultSet;
        boolean passed = false;
        
        try {
            resultSet = conn.GenerateremindersLetter();//.remindersDebtors();
            boolean stop = false;
            while (resultSet.next() && !stop) {
                String customerId = resultSet.getString("CustomerAccount_accountNo");//this gets the customers ID
                String JobId = resultSet.getString("jobId");//this gets the job id
                String paymentDue = resultSet.getString("sum(t.price)");//this gets the total
                String addressA = resultSet.getString("address");
                String addressCity = resultSet.getString("city");
                String addressPostcode = resultSet.getString("postcode");
                String customerName = resultSet.getString("firstName");
                
                Date date = resultSet.getTimestamp("Date");
                Date currentDate = currentDate();
                long milDif =  currentDate.getTime() - date.getTime();
                long fiveMilli = (5 * 24 * 60 * 60 * 1000);
                System.out.println("doff " + milDif/(fiveMilli/5) +" "+ resultSet.getString("jobId"));
                if (milDif < -(fiveMilli)) { //less the 
                    System.out.println("Stopped");
                    stop = true;
                } else {
              generatRimderLetter(customerId,JobId,paymentDue,addressA,addressCity,addressPostcode,customerName); //this line of code generates the reminder letter for customers
                }
            }
            passed = true;
            conn.closeDBConnection();

        } catch (SQLException ex) {
            System.out.println("email not sent");
            System.out.print(ex +"\n" );
        }
        
        return passed;
    }*/
    public static boolean remindersDebtors() { //alerts the shift manager and the office manager of a deadline approaching
        ResultSet resultSet;
        boolean passed = false;
        
        try {
            resultSet = conn.GenerateremindersLetter();//.remindersDebtors();
            boolean stop = false;
            while (resultSet.next() && !stop) {
                ///////////////
                 String customerId = resultSet.getString("CustomerAccount_accountNo");//this gets the customers ID
                String JobId = resultSet.getString("jobId");//this gets the job id
                String paymentDue = resultSet.getString("sum(t.price)");//this gets the total
                String addressA = resultSet.getString("address");
                String addressCity = resultSet.getString("city");
                String addressPostcode = resultSet.getString("postcode");
                String customerName = resultSet.getString("firstName");
                String d = resultSet.getString("Date");
                ////////////////
                
                Date date = resultSet.getTimestamp("Date");
                Date currentDate = currentDate();
                long milDif =  currentDate.getTime() - date.getTime();
                long fiveMilli = (5 * 24 * 60 * 60 * 1000);
                System.out.println("doff " + milDif/(fiveMilli/5) +" "+ resultSet.getString("jobId"));
                if (milDif < -(fiveMilli)) { //less the 
                    System.out.println("Stopped");
                    stop = true;
                } else {
                    generatRimderLetter(customerId,JobId,paymentDue,addressA,addressCity,addressPostcode,customerName, d);
                    
        try{
           String email = resultSet.getNString("email"); // this sends the emails
            System.out.print("asdfghjklkjhgfdsdfghjklkjhgfdssdfghj");
            
            String host ="smtp.gmail.com" ;
            String user = "megabytelimted@gmail.com";
            String pass = "mubxwanz";
            String to = email; 
            String from = "megabytelimted@gmail.com";
            String subject = "Overdue Payment";
            String messageText = "Dear Customer,\n"
                    + "\n "
                    + "According to our records, it appears that we have not yet received payment for your recent purchase, "
                    +"for photographic work done in our laboratory\n"
                    +"We would appreciate payment at your earliest convenience.\n"
                    +"If you have already sent a payment to us recently, please accept our apologies.\n"
                    + "\n "
                    +"Yours sincerely,\n"
                    + "G. Lancaster";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
           JOptionPane.showMessageDialog(null, "Reminders sent to debtors, for overdue payment",  "Sent!", JOptionPane.INFORMATION_MESSAGE); //emails sent
        }catch(Exception ex){
          System.out.println(ex);
            }
        }
            }
            passed = true;
            conn.closeDBConnection();

        } catch (SQLException ex) {
            System.out.println("email not sent");
            System.out.print(ex +"\n" );
        }
        
        return passed;
    }
     public static boolean BackupAutomatic() throws ParseException { //this line of code does automatic backup
        ResultSet resultSet;
        boolean passed = false;
            boolean stop = false;

                Date currentDate = currentDate();
                                          
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                String dateInString = "18-04-2018 14:20:56";
                Date date = sdf.parse(dateInString);
                System.out.println(date); //Tue Aug 31 10:20:56 SGT 1982
                                
                long milDif =  currentDate.getTime() - date.getTime();
                long fiveMilli = (5 * 24 * 60 * 60 * 1000);
                
                if (milDif < -(fiveMilli)) { //less the 
                    System.out.println("Stopped");
                    stop = true;
                } else { //if current date is greater then back up date
                    Process p=null;
        try {
            Runtime runtime = Runtime.getRuntime(); //this is auto back up
            p=runtime.exec("C:/Program Files//MySQL/MySQL Server 5.7/bin/mysqldump.exe -uroot -proot --add-drop-database -B bapers -r"+ "C:/Users/sajawal/Desktop/Uni/Autobackup.sql");
            int processComplete = p.waitFor();
            if (processComplete==0) {
                System.out.print("Backup Created Succuss");
            }else{
                System.out.print("Can't Create backup");
            }
        } catch (Exception e) {
            e.printStackTrace();
            } 
        }
            passed = true;   
        return passed;
    }
                
    public static ResultSet displayJobslessThan5days(){ //this is to display all the new jobs to overdure
     try {
            return conn.jobDeadlineAlert();
        } catch (SQLException ex) {
        }
        return null;
    }

    public static boolean newJobAlertUpdate() {
        return conn.newJobAlertUpdate();
    }
public static String getPassword(String staffId){//sarath 
    
        ResultSet rts;
         
        try{
            rts = conn.forgotPassword(staffId);
            rts.next();
            String password = rts.getString("password"); //sends the email for forget password
            
            System.out.print(password + "sajawal was here for password");
            
            return password;
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        return "error"; //change later
    }
    public static String getEmail(String staffId){//sarath
    
        ResultSet rts;
        
        try{
            rts = conn.forgotPassword(staffId);
            rts.next();
            String email = rts.getString("email");
            
            System.out.print(email + "sajawal was here");
            
            return email;
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        return "error for email (getEmail)"; 
    }
    public static Staff getSt() {
        return st;
    }

    public static void setSt(Staff st) {
        controller.st = st;
    }

    public static void openOfficeMgrHome() {
        OfficeMgrHome ofm = new OfficeMgrHome(); //sets the level of access
        ofm.setVisible(true);
    }

    public static void openShiftMgrHome() {//sets the level of access
        ShiftMgrHome s = new ShiftMgrHome();
        s.setVisible(true);
    }

    public static void openTechnicianHome() {//sets the level of access
        TechnicianHome tm = new TechnicianHome();
        tm.setVisible(true);
    }

    public static void openRepHome() {//sets the level of access
        ReceptionistHome rm = new ReceptionistHome();
        rm.setVisible(true);
    }

    public static DBConnection getConn() {
        return conn;
    }

    public static void closeDBConnection() {
        try {
            conn.closeDBConnection();
        } catch (Exception e) {
        }
    }
    public static boolean removeTasking(String jobId, String taskId){
        return conn.removeTasking(jobId, taskId);
    
    }
    public static boolean checking(String jobId) { 
        ResultSet resultSet;
        boolean passed = false;
        try {
            resultSet = conn.completeJobcheck(jobId);
            resultSet.next();
            String statues = resultSet.getString("status");
            if (statues.equals("Complete")) {
                completeJob(jobId);
                passed = true;
            }
            conn.closeDBConnection();

        } catch (SQLException ex) {
            System.out.println("taskpir failed");
        }

        return passed;
    }
    public static boolean completeJob(String jobId){
        return conn.completeJob(jobId);
    }
    public static ResultSet displayFixedTotal(String customerId, String jobId){
        try {
            return conn.displayFixedTotal(customerId,jobId);
        } catch (SQLException ex) {
        }
        return null;
    }
    public static ResultSet displayvariableTotal(String accountNo, String jobId, String volumeDiscountId){
        try {
            return conn.displayvariableTotal(accountNo, jobId, volumeDiscountId);
        } catch (SQLException ex) {
        }
        return null;
    }
    ///////////////////////////////////////discount/////////////////////////////////////////////
     public static ResultSet setVariableDiscount(String discountRate, int discountID){
     try {
            return conn.setVariableDiscount(discountRate, discountID);
        } catch (SQLException ex) {
        }
        return null;
     }
     
     public static ResultSet setFixedDiscount(String discountRate, int discountID){
     try {
            return conn.setVariableDiscount(discountRate, discountID);
        } catch (SQLException ex) {
        }
        return null;
     }
     
     public static ResultSet setFlexibleDiscount(String discountRate, int discountID){
     try {
            return conn.setVariableDiscount(discountRate, discountID);
        } catch (SQLException ex) {
        }
        return null;
     }//
     public static boolean updateDiscountType(String discountID, String accountNo, String discountType){
         return conn.updateDiscountType(discountID, accountNo, discountType);
     }
     
     public static boolean updateVariableDiscountType(String volumeDiscountId,  String discountID,String discountRate, String volume){ 
         return conn.updateVariableDiscountType(volumeDiscountId,discountID, discountRate, volume);
     }
     public static boolean updateFixedDiscountType(String discountRate, String discountID){
         return conn.updateFixedDiscountType(discountRate, discountID);
     }
     
     public static boolean updateFlexibleDiscountType(String discountRate, String taskID, String discountID){
         return conn.updateFlexibleDiscountType(discountRate, taskID, discountID);
     }   
    //////////////////////////////////////////////discount above////////////////////////////////////////////////
}
