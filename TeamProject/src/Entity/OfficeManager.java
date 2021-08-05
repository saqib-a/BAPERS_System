/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import controller.*;
import java.sql.SQLException;

/**
 *
 * @author sajawal
 */
public class OfficeManager extends ShiftManager {

    public OfficeManager(String staffid, String firstName, String surname, String jobTitle) {
        super(staffid, firstName, surname, jobTitle);
    }
   
}
