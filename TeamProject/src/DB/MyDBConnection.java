/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import controller.controller;
import java.sql.Connection;
import static java.sql.Connection.TRANSACTION_READ_COMMITTED;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date; //for the date problem

/**
 *
 * @author sajawal
 */
public class MyDBConnection implements DBConnection {

    private static Connection conn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet mkdir = null;

    @Override
    public void testConnection() throws SQLException { //this creates the connecttion with the mysql database

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made welldone");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
    }

    @Override
    public ResultSet login(String username, String password) throws SQLException {
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            
            conn.setAutoCommit(false);//turns autocommit off
            conn.setTransactionIsolation(TRANSACTION_READ_COMMITTED); //this sets the isloation level
            
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("SELECT * FROM staff WHERE staffId = ? AND password = ?"); //query to select the staff memebers dependednt on the staffId and password
            log.setString(1, username);
            log.setString(2, password);
            ResultSet set = log.executeQuery(); // get the infor from database
            
            conn.commit(); //this will commit it again
            conn.setAutoCommit(true);//sets it back to normal 

            return set;

        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();//roll backs if it fails
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");

    }
    @Override
    public ResultSet displayAllJob() throws SQLException{ // display all jobs done
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying job welldone");
        conn.setAutoCommit(false);//turns autocommit off
            conn.setTransactionIsolation(TRANSACTION_READ_COMMITTED); //this sets the isloation level
        stm = conn.createStatement();
        mkdir = stm.executeQuery("SELECT jobId, due_amount, CustomerAccount_accountNo,jobDescription,Date, isCompleted, active  from job"); //query to select all neccessay job information for a job done
        conn.commit(); //remove if it falses
            conn.setAutoCommit(true);//removes if it falses 
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
            conn.rollback();//roll backs if it fails
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    @Override
    public void closeDBConnection() throws SQLException {
        conn.close();
        System.out.print("The connection has been closed");
    }

    @Override
    public String createStaffAcc(String staffid, String firstName, String surname, String jobTitle, String password, String email) { 
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working welldone");
            PreparedStatement recordCreate;
            recordCreate = conn.prepareStatement("INSERT INTO staff VALUES (?,?,?,?,?,?)");
            recordCreate.setString(1, staffid);
            recordCreate.setString(2, firstName); // inserting into the table staff
            recordCreate.setString(3, surname);
            recordCreate.setString(4, jobTitle);
            recordCreate.setString(5, password);
            recordCreate.setString(6, email);
            
            recordCreate.execute();
            return "done";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "SQL Exception";
        }
    }

    @Override
    public String addCustomerAcc(String accountNo, String accountName, String title, String firstName, String surname, String address, String postcode, String city, String phoneNo, String valuedCustomer,String email) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for createing customer welldone");
            PreparedStatement recCusAccCreate;
            recCusAccCreate = conn.prepareStatement("INSERT INTO customeraccount(accountNo, accountName, title, firstName, surname, address, postcode, city, phoneNo, valuedCustomer, email)  VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            recCusAccCreate.setString(1, accountNo);
            recCusAccCreate.setString(2, accountName);
            recCusAccCreate.setString(3, title);            // inserting into the table customeraccount
            recCusAccCreate.setString(4, firstName);
            recCusAccCreate.setString(5, surname);
            recCusAccCreate.setString(6, address);
            recCusAccCreate.setString(7, postcode);
            recCusAccCreate.setString(8, city);
            recCusAccCreate.setString(9, phoneNo); 
            recCusAccCreate.setString(10, valuedCustomer);
            recCusAccCreate.setString(11, email);
            
            recCusAccCreate.execute();
            return "done";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "SQL Exception";
        }

    }

    @Override
    public String addNewTask(int taskId, String location, String shelfslot, float price, int duration, String taskDescription, float StartTime) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for createing new task welldone");
            PreparedStatement recCusAccCreate;
            recCusAccCreate = conn.prepareStatement("INSERT INTO task (taskId, location, shelfslot, price, duration, taskDescription, StartTime) VALUES (?,?,?,?,?,?,?)");
            recCusAccCreate.setInt(1, taskId);
            recCusAccCreate.setString(2, location);
            recCusAccCreate.setString(3, shelfslot); // inserting into the table task
            recCusAccCreate.setFloat(4, price);
            recCusAccCreate.setInt(5, duration);
            recCusAccCreate.setString(6, taskDescription);
            recCusAccCreate.setFloat(7, StartTime);
            recCusAccCreate.execute();
            return "done";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "SQL Exception";
        }
    }

    @Override
    public String addNewJob(String jobId, float due_amount, String urgent_job, String accountNo, String jobDescription, String date) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");

            System.out.println("Database is working for createing new JOB welldone");

            pstm = conn.prepareStatement("INSERT INTO job (jobId, due_amount, urgent_job, CustomerAccount_accountNo, jobDescription, Date) VALUES (?,?,?,?,?,?)");
            pstm.setString(1, jobId);
            pstm.setFloat(2, due_amount);
            pstm.setString(3, urgent_job); // inserting into the table job 
            pstm.setString(4, accountNo);
            pstm.setString(5, jobDescription);
            pstm.setString(6, date);
            pstm.execute();
            return "done";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "SQL Exception";
        }
    }

    @Override
    public boolean updateCustInfo(String accountNo, String accountName, String title, String firstName, String surname, String address, String postcode, String city, String phoneNo, String valuedCustomer, String status) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");

            System.out.println("Database is working for updating customer information welldone"); 

            pstm = conn.prepareStatement("update customeraccount set accountName= ?, title= ?, firstName= ?,surname = ?,address =?, postcode = ?, city =?, phoneNo=?, valuedCustomer=?, statues=? where accountNo = ?");            
            pstm.setString(11, accountNo);
            pstm.setString(1, accountName);
            pstm.setString(2, title);                   // Updating the customeraccount details 
            pstm.setString(3, firstName);
            pstm.setString(4, surname);
            pstm.setString(5, address);
            pstm.setString(6, postcode);
            pstm.setString(7, city);
            pstm.setString(8, phoneNo);
            pstm.setString(9, valuedCustomer);
            pstm.setString(10,status);
            pstm.execute();
            //pstm.executeUpdate(); not need this saj
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
    @Override
    public String updateStaffAcc(String staffid, String firstName, String surname, String jobTitle, String password, String email){ //comeback to this dont need to its fixed
    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for updateStaffAcc welldone");
            PreparedStatement recordCreate;
            recordCreate = conn.prepareStatement("update staff set firstName=?, surname= ?, jobTitle=?, password=?, email=? WHERE staffId= ?");
            recordCreate.setString(5, email);
            recordCreate.setString(1, firstName); // updating the staff account dependent on the staffId
            recordCreate.setString(2, surname);
            recordCreate.setString(3, jobTitle);
            recordCreate.setString(4, password);
            recordCreate.setString(6, staffid);
            recordCreate.execute();
            return "done";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "NOT DONE";
        }
    }
    
    @Override
    public boolean updateJob(String jobId,float due_amount, String urgent_job, String accountNo, String jobDescription, String date) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");

            System.out.println("Database is working for updating job welldone"); //working fix it sajawal

            pstm = conn.prepareStatement("update job set  due_amount= ?, urgent_job = ?, jobDescription =?, Date=? where CustomerAccount_accountNo  = ? and jobId= ?");            
            pstm.setString(5, accountNo);
            pstm.setString(6, jobId);
            pstm.setFloat(1, due_amount); // updating the job details dependent on the the customer account number and the jobId 
            pstm.setString(2, urgent_job);
            pstm.setString(3, jobDescription);
            pstm.setString(4, date);
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override   // This method updates the task dependent on the taskId 
    public boolean updateTask(int taskId, String location, String shelfslot, float price, int duration, String taskDescription, float StartTime, String TaskCompleted) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for createing new task welldone");
            PreparedStatement recCusAccCreate;
            recCusAccCreate = conn.prepareStatement("update task set location= ?, shelfslot= ?, price = ?, duration =?, taskDescription=?, StartTime=?, TaskCompleted=?  where taskId = ?");
            recCusAccCreate.setInt(8, taskId);
            recCusAccCreate.setString(1, location);
            recCusAccCreate.setString(2, shelfslot);
            recCusAccCreate.setFloat(3, price);             
            recCusAccCreate.setInt(4, duration);
            recCusAccCreate.setString(5, taskDescription);
            recCusAccCreate.setFloat(6, StartTime);
            recCusAccCreate.setString(7, TaskCompleted);
            recCusAccCreate.execute();
             return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
         
    @Override
    public ResultSet displaySomeJob(String CustomerAccount_accountNo) throws SQLException{ // display jobs done by the customer account number and and the active status of the the job
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying job welldone");
        
        pstm = conn.prepareStatement("SELECT jobId, due_amount, CustomerAccount_accountNo,jobDescription,Date, isCompleted, active  from job WHERE CustomerAccount_accountNo = ? or active = ?");
        pstm.setString(1, CustomerAccount_accountNo);
        pstm.setString(2, CustomerAccount_accountNo);
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }

    @Override
    public ResultSet displayAllCust() throws SQLException { // displays all the customer account details from the the customer table

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying customer welldone");
            stm = conn.createStatement();
            mkdir = stm.executeQuery("SELECT * FROM customeraccount");
            return mkdir;
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
 
    
    @Override
    public ResultSet displaySomeCust(String valuedCustomer) throws SQLException{ // display only the valued customers
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying customer account welldone");
        
        pstm = conn.prepareStatement("SELECT * FROM customeraccount where valuedCustomer =? ");
        pstm.setString(1, valuedCustomer);
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    } 
    
    @Override
    public ResultSet displayAllStaff() throws SQLException { // display all staff details apart from the email and the password

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying all staff welldone");
            stm = conn.createStatement();
            mkdir = stm.executeQuery("select staffId, firstName, surname, jobTitle from staff");
            return mkdir;
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    
     @Override
    public ResultSet displaySomeStaff(String jobTitle) throws SQLException{ // display staff details dependent on the job title of the staff memeber
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying some staff by role welldone");
        
        pstm = conn.prepareStatement("select staffId, firstName, surname, jobTitle from staff where jobTitle =? ");
        pstm.setString(1, jobTitle);
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    
    @Override
    public ResultSet displayAllTask() throws SQLException { //display all the task details 

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying all tasks welldone");
            stm = conn.createStatement();
            mkdir = stm.executeQuery("select * from task");
            return mkdir;
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    } 
  
    @Override
    public ResultSet displaySomeTask(String location) throws SQLException{ // display the task details dependent on the location of the task
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying some task by location welldone");
        
        pstm = conn.prepareStatement("select * from task where location =? ");
        pstm.setString(1, location);
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    
    @Override
    public ResultSet displayAllTasksForJob(String jobId) throws SQLException{ // displays all the tasks for particular job dependent on the jobid inputed and it it ordered by the taskId ///
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying  All Tasks For Job welldone");
        
        pstm = conn.prepareStatement("select jt.Job_jobId as 'Job ID', jt.Task_taskId as 'Task ID', "
                + "t.location as 'Department', t.shelfslot as 'Shelf Slot', t.price as 'Price', "
                + "jt.completedBy as 'Completed by', jt.status as 'Status'\n" 
                +"from job_has_task jt\n"
                +"inner join task t on jt.Task_taskId = t.taskId\n" 
                +"where jt.Job_jobId = ?\n"
                /*+"group by jt.Job_jobId, jt.Task_taskId, jt.completedBy\n"*/ //we do not need this 
                +"order by jt.Task_taskId");
        pstm.setString(1, jobId);
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    @Override
    public ResultSet displayAllTasksForJobsNoInput() throws SQLException{ // display all the task for a job which is organised by the taskid 
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying  All Tasks For Job welldone");
        
        pstm = conn.prepareStatement("select jt.Job_jobId as 'Job ID', jt.Task_taskId as 'Task ID', \n" 
                +"t.location as 'Department', t.shelfslot as 'Shelf Slot', t.price as 'Price', \n" 
                +"jt.completedBy as 'Completed by', jt.status as 'Status'\n" 
                +"from job_has_task jt\n" 
                +" inner join task t on jt.Task_taskId = t.taskId\n" 
               /*+"group by jt.Job_jobId, jt.Task_taskId, jt.completedBy \n"*/
                +"order by jt.Task_taskId");
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    @Override
    public ResultSet displayIndividualPerfReport(String date, String datee) throws SQLException { // display the Individual Performance Report query without the Total Effort 

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
           
            pstm = conn.prepareStatement("select firstName as 'First Name', surname as 'Surname', "
                    + "jobId as 'Code', jt.Task_taskId as 'Task IDs', k.location as 'Department',"
                    + " j.Date as 'Date', k.startTime as 'Start Time', k.duration as 'Time Taken', "
                    + "sum(k.duration) as Total"
                    + " from Staff s inner join Job_has_Task jt inner join Job j "
                    + "inner join Task k on s.staffId = jt.Staff_staffId "
                    + "and j.jobId = jt.Job_jobId where j.Date between ? and ? group by jobId, firstName, surname, Task_taskId, location, "
                    + "j.Date, duration, startTime, k.taskId order by jobId asc, taskId asc, location asc, startTime asc ");
           pstm.setString(1, date);
           pstm.setString(2, datee);
        mkdir= pstm.executeQuery();
        return mkdir;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
        
    }
    @Override
    public ResultSet displayInPerfReportTotalEffort(String date, String datee) throws SQLException {  //displays the Individual Performance Report Total Effort
 
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select sum(k.duration) as Total\n" 
                    +"from Staff s inner join Job_has_Task jt inner join Job j \n" 
                    +"inner join Task k on s.staffId = jt.Staff_staffId \n" 
                    +"and j.jobId = jt.Job_jobId where j.Date between ? and ?");
           pstm.setString(1, date);
           pstm.setString(2, datee);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    @Override
    public ResultSet displaySummaryPerfReport1parta(String dateOne, String dateTwo) throws SQLException { //Displays the query for the day shift 1 where the start time is prestated in the code and the dates are inputed

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
           
            pstm = conn.prepareStatement("select j.Date, c.location as Department,\n" 
                + " sum(c.duration) as 'Time Taken' from job j \n" 
                +" inner join (select job_jobId, Task_taskId from job_has_task) \n" 
                +" d on d.Job_jobID = j.jobId inner join( \n" 
                +"select taskId, location, StartTime, duration\n" 
                +"from task\n" 
                +") c on c.taskId = d.Task_taskId\n" 
                +"where StartTime between 0500 and 1430\n" 
                +" and j.Date between ? and ?\n" 
                +"group by j.Date");
           pstm.setString(1, dateOne);
           pstm.setString(2, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    @Override
    public ResultSet displaySummaryPerfReport1partb(String dateOne, String dateTwo) throws SQLException { //Displays the query for Total time taken for a day shift 1  

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select location as Department, c.Tot as 'Total for Shift 1'\n" 
                +"from job j\n" 
                +"inner join (\n" 
                +"select Job_jobId, Task_taskId\n"
                +"from job_has_task\n"
                +") d on d.Job_jobID = j.jobId\n" 
                +"inner join (\n" 
                +"select taskId, location, StartTime, sum(duration) as Tot\n" 
                +"from task\n"
                +"where StartTime between 0500 and 1430\n"
                +") c on c.taskId = d.Task_taskId\n" 
                +"where j.Date between ? and ?\n"
                +"group by c.location");
           pstm.setString(1, dateOne);
           pstm.setString(2, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    @Override
    public ResultSet displaySummaryPerfReportdayTwoA(String dateOne, String dateTwo) throws SQLException { ////Displays the query for the day shift 2 where the start time is prestated in the code and the dates are inputed

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select j.Date, c.location as Department, sum(c.duration) as 'Time Taken'\n" 
                    +"from job j\n" 
                    +"inner join(\n" 
                    +"select Job_jobId, Task_taskId\n" 
                    +"from job_has_task\n" 
                    +") d on d.Job_jobID = j.jobId\n" 
                    +"inner join(\n"
                    +"select taskId, location, StartTime, duration\n" 
                    +"from task\n" 
                    +") c on c.taskId = d.Task_taskId\n" 
                    +"where StartTime between 1430 and 2200 and j.Date between ? and ?\n" 
                    +"group by j.Date");
           pstm.setString(1, dateOne);
           pstm.setString(2, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    @Override
    public ResultSet displaySummaryPerfReportdayTwoB(String dateOne, String dateTwo) throws SQLException { //this is for day shift 2 b

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select location as Department, c.Tot as 'Total for Shift 2'\n" 
                    +"from job j\n" 
                    +"inner join (\n" 
                    +"select Job_jobId, Task_taskId\n" 
                    +"from job_has_task\n" 
                    +") d on d.Job_jobId = j.jobId\n"
                    +"inner join (\n"
                    +"select taskId, location, StartTime, sum(duration) as Tot\n" 
                    +"from task where StartTime between 1430 and 2200\n" 
                    +") c on c.taskId = d.Task_taskId\n" 
                    +"where j.Date between ? and ?\n" 
                    +"group by c.location");
           pstm.setString(1, dateOne);
           pstm.setString(2, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    @Override
    public ResultSet displaySummaryPerfReportdayThreeA(String dateOne, String dateTwo) throws SQLException { //Displays the query for the day shift 3 where the start time is prestated in the code and the dates are inputed
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select j.Date, c.location as Department, sum(c.duration) as 'Time Taken'\n" 
                    +"from job j\n" 
                    +"inner join(\n" 
                    +"select Job_jobId, Task_taskId\n" 
                    +"from job_has_task\n" 
                    +") d on d.Job_jobID = j.jobId\n" 
                    +"inner join (\n" 
                    +"select taskId, location, StartTime, duration\n"
                    +"from task\n" 
                    +")c on c.taskId = d.task_taskId\n"
                    +"where StartTime between 1420 and 2200"
                    + ""
                    + " and j.Date between ? and ?\n"
                    +"group by j.Date");
           pstm.setString(1, dateOne);
           pstm.setString(2, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    public ResultSet displaySummaryPerfReportdayThreeB(String dateOne, String dateTwo) throws SQLException { //this is for day shift 3 b
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select location as Department, c.Tot as 'Total for Shift 3'\n" 
                    +"from job j \n" 
                    +"inner join(\n" 
                    +"select Job_jobId, Task_taskId\n" 
                    +"from job_has_task\n"
                    +") d on d.Job_jobID = j.jobId\n" 
                    +"inner join (\n" 
                    +"select taskId, location, StartTime, sum(duration) as Tot\n" 
                    +"from task\n"
                    +"where StartTime between 1420 and 2200\n" 
                    +") c on c.taskId = d.Task_taskId\n"
                    +"where j.Date between ? and ?\n"
                    +"group by c.location");
           pstm.setString(1, dateOne);
           pstm.setString(2, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    public ResultSet displaySummaryPerfReportfinal1(String dateOne, String dateTwo) throws SQLException { //this is for day shift 3 b
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select location as Department, c.Tot as 'Total Shift'\n" 
                    +"from job j \n" 
                    +"inner join(\n" 
                    +"select Job_jobId, Task_taskId\n" 
                    +"from job_has_task\n" 
                    +") d on d.Job_jobID = j.jobId\n" 
                    +"inner join (\n" 
                    +"select taskId, location, StartTime, sum(duration) as Tot\n" 
                    +"from task\n" 
                    +") c on c.taskId = d.Task_taskId\n" 
                    +"where j.Date between ? and ?\n" 
                    +"group by c.location");
           pstm.setString(1, dateOne);
           pstm.setString(2, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    @Override
    public ResultSet displayCustomerSalesReport(String accountNo,String dateOne, String dateTwo) throws SQLException { //Dipalys the Customer Sales report query which in takes an account number and 2 dates

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for displaying Individual Performance Report welldone");
            
            pstm = conn.prepareStatement("select j.jobId as 'Job', j.due_amount as 'Price', t.taskId as 'Task', \n" 
                    +"t.location as 'Department',t.StartTime as 'Start Time', t.duration as 'Time Taken', \n" 
                    +"jt.completedBy as 'Completed By', t.shelfslot as 'Shelf on Completion'\n" 
                    +"from job j inner join job_has_task jt on j.jobId = jt.Job_jobId\n" 
                    +"inner join task t on jt.Task_taskId = t.taskId\n" 
                    +"inner join staff s on jt.staff_staffId = s.staffId\n" 
                    +"where j.CustomerAccount_accountNo = ? and j.Date between ? and ?\n" 
                    +"group by j.jobId, t.taskId, t.location\n" 
                    + "order by j.jobId asc, t.taskId asc, t.location asc, t.shelfslot");
           pstm.setString(1, accountNo);
           pstm.setString(2, dateOne);
           pstm.setString(3, dateTwo);
        mkdir= pstm.executeQuery();
        return mkdir;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        throw new UnsupportedOperationException("not coded yet please wait."); 
    }
    
    @Override
    public boolean deleteCusAccount(String accountNo) { // uses delete query to remove a customer account dependent on the customer account number
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for delete customer account welldone");
            PreparedStatement recCusAccCreate;
            recCusAccCreate = conn.prepareStatement("delete from customeraccount where accountNo = ?");
            recCusAccCreate.setString(1, accountNo);            
            recCusAccCreate.execute();
             return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean deleteTask(int taskId) { // uses delete query to remove a task dependent on the task id
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("Database is working for createing new task welldone");
            PreparedStatement recCusAccCreate;
            recCusAccCreate = conn.prepareStatement("delete from task where taskId = ?");
            recCusAccCreate.setInt(1, taskId);            
            recCusAccCreate.execute();
             return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public ResultSet newJobAlert() throws SQLException { //Obtains the status of the of the alerts from the job and organises it based on the "Alerted"
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("New Job Alert displayed weldone");
            stm = conn.createStatement();
            String test = "select Alerted from job order by Alerted asc ";
           ResultSet saj = stm.executeQuery(test); 
            return saj;
        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
    @Override
    public ResultSet displayJobAlert() throws SQLException { // Displays the Job Details based on the if the Alerted attribute is false and it is order by ascending order of "Alerted"
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("New Job Alert displayed weldone");
            stm = conn.createStatement();
            String test = "select jobId,due_amount,urgent_job,CustomerAccount_accountNo, jobDescription, Date from job where Alerted = 'false' order by Alerted asc ";
           ResultSet saj = stm.executeQuery(test); 
            return saj;
        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
    @Override
    public boolean newJobAlertUpdate(){ //Updates the alert attribute to true when only then the attribute is false
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            pstm = conn.prepareStatement("update job set Alerted ='true' where Alerted = 'false'");
            pstm.execute();
        return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
        @Override
    public ResultSet jobDeadlineAlert() throws SQLException { //select the information of a job and displays it based on the date of the job in ascending order
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("jobDeadlineAlert displayed weldone");
            stm = conn.createStatement();
            String testing = "select jobId,due_amount,urgent_job,CustomerAccount_accountNo, jobDescription, Date from job order by Date asc";
           ResultSet sajawal = stm.executeQuery(testing); 
            return sajawal;
        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
    @Override
    public ResultSet forgotPassword(String staffId) throws SQLException  { // selects the password from the database based on the staff id this infomation will be given to the staff memeber via email

    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("SELECT password, email FROM staff where staffId = ? "); //staffId will be inputed into this query
            log.setString(1, staffId);
            ResultSet set = log.executeQuery(); // get the infor from database

            return set;

        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    } 
    @Override
    public boolean addTAsking(String jobId, String taskId, String fullName, String staffID){ // this is a insert statement to add a task inot job_has_task table 

    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("INSERT INTO job_has_task (Job_jobId, Task_taskId, completedBy, staff_staffId)"
                    + " VALUES (?, ?, ?, ?)"); 
            log.setString(1, jobId);
            log.setString(2, taskId);
            log.setString(3, fullName);
            log.setString(4, staffID);
            log.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean removeTasking(String jobId, String taskId){ //this uses a delete query to remove a task from job_has_task table only by entering the jobId and taskId

    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("delete from job_has_task where Job_jobId= ? and Task_taskId= ?"); 
            log.setString(1, jobId);
            log.setString(2, taskId);
            
            log.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean CommenceATask(String completedBy, String JobId, String taskId) {//This updates the job_has_task table completedBy attribute via a input from a user and udates the status to 'in progress'
                //this update is dependent on the jobId and TaskId which is selected in the query
    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("UPDATE job_has_task SET completedBy = ?, status= 'in progress' WHERE Job_jobId= ? and Task_taskId= ?");
            log.setString(1, completedBy);
            log.setString(2, JobId);
            log.setString(3, taskId);
            log.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }//update task set StartTime= ? where taskId = ?
    @Override
    public boolean CommenceATaskA(String startTime, String taskId) { //This updates the task table details of when a task ahas started by taskId

    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("update task set StartTime= ? where taskId = ?");
            log.setString(1, startTime);
            log.setString(2, taskId);
            log.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public ResultSet displayPaymentInfo(String customerId) throws SQLException{ // displays prices of task in a job based on the on the customer account number inputed into the system 
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying payment informtion welldone");
        
        pstm = conn.prepareStatement("select jt.Job_jobId as 'Job ID', jt.Task_taskId as 'Task ID', \n" 
                +"t.price as 'Price' \n"
                +"from job_has_task jt\n"
                +"inner join task t on jt.Task_taskId = t.taskId\n"
                +"inner join job j on jt.Job_jobId = j.jobId\n" 
                +"where j.CustomerAccount_accountNo = ?\n" 
                /*+"group by jt.Job_jobId, jt.Task_taskId \n"*/
                +"order by jt.Job_jobId, jt.Task_taskId");
        pstm.setString(1, customerId);
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    @Override
    public ResultSet displayPaymenttotal(String customerId, String jobId) throws SQLException{ // display the payment total amount for a certain job, this will alao apply the VAT of 20% to the total
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying payment informtion welldone");
        
        pstm = conn.prepareStatement("select jt.Job_jobId as 'Job ID',round(sum(t.price)*1.2, 2) as 'Total Job Price'\n"
                +"from job_has_task jt\n" 
                +"inner join task t on jt.Task_taskId = t.taskId\n"
                +"inner join job j on jt.Job_jobId = j.jobId\n" 
                +"where j.CustomerAccount_accountNo = ? and jt.Job_jobId = ?\n" 
                +"group by jt.Job_jobId\n" 
                +"order by jt.Job_jobId");
        pstm.setString(1, customerId);
        pstm.setString(2, jobId);
        mkdir= pstm.executeQuery();
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    @Override
    public String displaylerable(String customerId, String jobId){ // display the price of total job price applying the VAT of 20% 
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying payment informtion welldone");
        
        pstm = conn.prepareStatement("select round(sum(t.price)*1.2, 2) as 'Total Job Price'\n" 
                +"from job_has_task jt\n" 
                +"inner join task t on jt.Task_taskId = t.taskId\n"
                +"inner join job j on jt.Job_jobId = j.jobId\n" 
                +"where j.CustomerAccount_accountNo = ? and jt.Job_jobId = ?\n" 
                +"group by jt.Job_jobId\n"
                +"order by jt.Job_jobId");
        pstm.setString(1, customerId);
        pstm.setString(2, jobId);
        pstm.executeQuery();
        return "done";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "SQL Exception";
        }
    }
    @Override
    public boolean inputCasPayment(String amountPaid,String customerId, String paymentDate) { //inserts into the payment table to set the type of payement to cash, and jobPaid status to 'yes' 
        try{// While the otheer information is inputed by the user
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying payment informtion welldone");
        
        pstm = conn.prepareStatement("INSERT INTO payment (amountPaid, paymentType, CustomerAccount_accountNo, paymentDate, jobPaid) \n" 
                +"VALUES (?, 'cash', ?, ?, 'yes')");
        pstm.setString(1, amountPaid);
        pstm.setString(2, customerId);
        pstm.setString(3, paymentDate);
        pstm.execute();
        return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    } 
    @Override //inserting the data into the card payment table and setting the JobPaid status as 'yes' by default this is used for paying for a invoice 
    public boolean inputCardPayment(String expiryDate,String type, String last_digits, String customerNo, String amountPaid, String paymentDate, String jobId, String pin) { 
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying payment informtion welldone");
        
        pstm = conn.prepareStatement("INSERT INTO cardpayment (expiryDate, type, last_digits, customerAccount_accountNo,amountPaid, "
                + "paymentDate,jobPaid,jobId,sePin)VALUES (?,?,?,?,?,?,'yes',?,?)");
        pstm.setString(1, expiryDate);
        pstm.setString(2, type);
        pstm.setString(3, last_digits);
        pstm.setString(4, customerNo);
        pstm.setString(5, amountPaid);
        pstm.setString(6, paymentDate);
        pstm.setString(7, jobId);
        pstm.setString(8,pin);
        pstm.execute();
        return true;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean updateTaskPiro(String jobId, String taskId, String urgentTask ) { //updates the job_has_task table toi set the priority of the task dependent on the taskid and jobid inputed 
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");

            System.out.println("Database is working for updating job welldone");

            pstm = conn.prepareStatement("UPDATE job_has_task SET urgent_task=?, taskAlert='false' WHERE Task_taskId=? and Job_jobId = ?");            
            
            pstm.setString(1, urgentTask); 
            pstm.setString(2, taskId);
            pstm.setString(3, jobId);
            
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean updateJobPiro(String jobId, String urgentTask ) {//updates the urgency of a task dependent on the job Id
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");

            System.out.println("Database is working for updating job welldone");

            pstm = conn.prepareStatement("UPDATE job SET urgent_job=? WHERE jobId=?");            
            
            pstm.setString(1, urgentTask); 
            pstm.setString(2, jobId);
            
            pstm.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
     @Override
    public ResultSet changeTaskpirAlert() throws SQLException { //this does the check for the change task alert
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("New Job Alert displayed weldone");
            stm = conn.createStatement();
            
            String test = "select taskAlert from job_has_task order by taskAlert asc";
           ResultSet saj = stm.executeQuery(test); 
            return saj;
        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
     @Override
    public ResultSet DisplaychangeTaskpirAlert() throws SQLException {  //displays the the jobs with task that have not been alert to the office manager 
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("New Job Alert displayed weldone");
            stm = conn.createStatement();
            
            String test = "select Job_jobId as 'Job ID', Task_taskId as 'Task ID', status, urgent_task as 'Urgent Task' from job_has_task where taskAlert = 'false'";
           ResultSet saj = stm.executeQuery(test); 
            return saj;
        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
    @Override
    public boolean updateChangeTaskPirAlert(){ //updates the alert status of a task in a job where the taskAlert is false
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            pstm = conn.prepareStatement("update job_has_task set taskAlert ='true' where taskAlert = 'false'");
            pstm.execute();
        return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    @Override
    public ResultSet remindersDebtors() throws SQLException  { //display the information of a job which have a overdue payment for a particular customer 

    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("select j.jobId,j.due_amount,j.urgent_job,j.CustomerAccount_accountNo, j.jobDescription, j.Date, c.email\n" 
                    +"from job j\n" 
                    +"inner join customeraccount c on j.CustomerAccount_accountNo = c.accountNo\n"
                    +"order by Date asc"); //creates the statmetn a blank one
            ResultSet set = log.executeQuery(); // get the infor from database

            return set;

        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    } 
    @Override
    public ResultSet GenerateremindersLetter() throws SQLException  { //displays information for a reminder letter which contains the information of the customer job, there persoanl details and payment due

    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("select j.jobId,c.firstName,c.address, c.city, c.postcode,sum(t.price),j.urgent_job,j.CustomerAccount_accountNo, j.jobDescription, j.Date, c.email\n"
                    +"from job j \n"
                    +"inner join customeraccount c on j.CustomerAccount_accountNo = c.accountNo\n" 
                    +"inner join job_has_task jt on j.jobId = jt.Job_jobId\n"
                    +"inner join task t on t.taskId = jt.Task_taskId\n" 
                    +"group by j.jobId,c.firstName,c.address, c.city, c.postcode,j.urgent_job,j.CustomerAccount_accountNo, j.jobDescription, j.Date, c.email\n"
                    +"order by Date asc"); //creates the statmetn a blank one
            ResultSet set = log.executeQuery(); // get the infor from database

            return set;

        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
    
    @Override
    public boolean completeTask(String taskId, String jobId){
        //updates the task from in progress to complete for a particualr job
    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("UPDATE job_has_task SET status='Complete' WHERE Task_taskId=? and Job_jobId=?");
             log.setString(1, taskId); 
            log.setString(2, jobId);
            log.execute(); // get the information from database

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    /////////////////////////////////////
    @Override
    public ResultSet completeJobcheck(String jobId){
              //this check the job is complete 
    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");
            conn.setAutoCommit(false);//turns autocommit off
            conn.setTransactionIsolation(TRANSACTION_READ_COMMITTED); //this sets the isloation level
            

            PreparedStatement log = conn.prepareStatement("select * from job_has_task where /*status = 'Complete' and*/ Job_jobId = ?");
            log.setString(1, jobId);
            log.execute(); // get the infor from database
             ResultSet set = log.executeQuery();
             conn.commit(); //remove if it falses
            conn.setAutoCommit(true);//removes if it falses 
            
             return set;
             
        } catch (SQLException ex) {
            //ex.printStackTrace();
            
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        try {
            conn.rollback();
        } catch (SQLException ex1) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex1);
        }
        }
    
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
    
    @Override
    public boolean completeJob(String jobId){
            //updates the status of a job to 'completed' dependent on the joId
    try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement log = conn.prepareStatement("UPDATE job SET status='Completed' WHERE jobId= ?");
            log.setString(1, jobId);
            log.execute(); // get the infor from database
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    ///////////////////////////////////////////////////////// discount //////////////////////////////////////////////////
    
    
    public boolean setVariableDiscount(int discountID, String discountRate){
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
        pstm = conn.prepareStatement("update job set Alerted ='true' where Alerted = 'false'");
        pstm.setString(1, discountRate);
        pstm.setInt(2, discountID);
        pstm.execute();
        return true;
    } catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    }
    
    @Override
    public ResultSet setVariableDiscount(String discountRate, int discountID) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement discount = conn.prepareStatement("SELECT * FROM staff WHERE staffId = ? AND password = ?"); //creates the statmetn a blank one
            discount.setString(1, discountRate);
            discount.setInt(2, discountID);
            
            ResultSet set = discount.executeQuery(); // get the infor from database
            return set;

        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");
    }
    
    @Override
    public ResultSet setFixedDiscount(String discountRate, int discountID) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement discount = conn.prepareStatement("SELECT * FROM staff WHERE staffId = ? AND password = ?"); //creates the statmetn a blank one
            discount.setInt(1, discountID);
            discount.setString(2, discountRate);
            ResultSet set = discount.executeQuery(); // get the infor from database

            return set;

        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");

    }
    
    @Override
    public ResultSet setFlexibleDiscount(String discountRate, int discountID) throws SQLException {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
            System.out.println("connection made weldone");

            PreparedStatement discount = conn.prepareStatement("SELECT * FROM staff WHERE staffId = ? AND password = ?"); //creates the statmetn a blank one
            discount.setInt(1, discountID);
            discount.setString(2, discountRate);
            ResultSet set = discount.executeQuery(); // get the infor from database
            return set;

        } catch (SQLException ex) {
            Logger.getLogger(MyDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Sorry not know please come later ");

    }
    
    @Override
    public boolean updateDiscountType(String discountID, String accountNo, String discountType){ //works
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
        
        pstm = conn.prepareStatement("INSERT INTO discounttype VALUES (?, ?, ?)");
        pstm.setString(1,discountID);
        pstm.setString(2,accountNo);
        pstm.setString(3,discountType);
        pstm.execute();
        return true;
    } catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    
    }
    @Override
        public boolean updateVariableDiscountType(String volumeDiscountId,  String discountID,String discountRate, String volume){ //works 
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
        
        pstm = conn.prepareStatement("INSERT INTO volumediscount (volumeDiscountId, DiscountType_discountID, discountRate, volume) \n"
                +"VALUES (?, ?, ?, ?);");
        pstm.setString(1,volumeDiscountId);
        pstm.setString(2,discountID);
        pstm.setString(3,discountRate);
        pstm.setString(4, volume);
        pstm.execute();
        return true;
    } catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    
    }
      @Override
        public boolean updateFixedDiscountType(String discountRate, String discountID){
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
        
        pstm = conn.prepareStatement("INSERT INTO fixed (discountRate, discounttype_discountID) VALUES (?,?)");
        pstm.setString(1,discountRate);
        pstm.setString(2,discountID);
        pstm.execute();
        return true;
    } catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    
    }
      @Override
        public boolean updateFlexibleDiscountType(String discountRate, String discountID, String taskID){
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapers", "root", "root");
   
        pstm = conn.prepareStatement("INSERT INTO flexible (discountRate, DiscountType_discountID, task_taskId) VALUES (?, ?, ?)");
        pstm.setString(1,discountRate);
        pstm.setString(2,discountID);
        pstm.setString(3,taskID);
            
        pstm.execute();
        return true;
    } catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    
    }
    @Override
    public ResultSet displayFixedTotal(String customerId, String jobId) throws SQLException{ // display some jobs done
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying payment informtion welldone");
        conn.setAutoCommit(false);//turns autocommit off
            conn.setTransactionIsolation(TRANSACTION_READ_COMMITTED); //this sets the isloation level
 
        pstm = conn.prepareStatement("select jt.Job_jobId as 'Job ID',round(sum(t.price)*1.2*(1-(f.discountRate/100)),2) as 'Total Job Price'\n" 
                +"from job_has_task jt\n" 
                +"inner join task t on jt.Task_taskId = t.taskId\n" 
                +"inner join job j on jt.Job_jobId = j.jobId\n" 
                +"inner join customeraccount c on c.accountNo = j.CustomerAccount_accountNo\n"
                +"inner join discounttype d on d.CustomerAccount_accountNo = c.accountNo\n"
                +"inner join fixed f on f.DiscountType_discountID = d.discountID\n" 
                +"where j.CustomerAccount_accountNo = ? and jt.Job_jobId = ?\n" 
                +"group by jt.Job_jobId\n"
                +"order by jt.Job_jobId");
        pstm.setString(1, customerId);
        pstm.setString(2, jobId);
        mkdir= pstm.executeQuery();
        conn.commit(); //this will commit it again
            conn.setAutoCommit(true);//sets it back to normal 
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
            conn.rollback();//roll backs if it fails
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    @Override
    public ResultSet displayvariableTotal(String accountNo, String jobId, String volumeDiscountId) throws SQLException{ // display some jobs done
        try{
        conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bapers", "root", "root");
        System.out.println("Database is working for displaying payment informtion welldone");
        conn.setAutoCommit(false);//turns autocommit off
        conn.setTransactionIsolation(TRANSACTION_READ_COMMITTED); //this sets the isloation level
 
        pstm = conn.prepareStatement("select jt.Job_jobId as 'Job ID', round(sum(t.price)*1.2*(1-(v.discountRate/100)),2) as 'Total Job Price'\n"
                +"from job_has_task jt\n" 
                +"inner join task t on jt.Task_taskId = t.taskId\n" 
                +"inner join job j on jt.Job_jobId = j.jobId\n" 
                +"inner join customeraccount c on c.accountNo = j.CustomerAccount_accountNo\n"
                +"inner join discounttype d on d.CustomerAccount_accountNo = c.accountNo\n" 
                +"inner join volumediscount v on v.DiscountType_discountID = d.discountID\n" 
                +"where c.accountNo = ? and jt.Job_jobId = ? and v.volumeDiscountId = ?");
        pstm.setString(1, accountNo);
        pstm.setString(2, jobId);
        pstm.setString(3, volumeDiscountId);
        mkdir= pstm.executeQuery();
        conn.commit(); //this will commit it again
        conn.setAutoCommit(true);//sets it back to normal 
        return mkdir;
        }catch (SQLException ex) {
            System.out.println("SQL Exception");
            conn.rollback();//roll backs if it fails
        }
        throw new UnsupportedOperationException("Havent coded it yet.");
    }
    
}
