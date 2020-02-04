/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseproject;

/**
 *
 * @author jardo
 */
public class EnterpriseProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printSQLDate("10-21-2015");
    }
    static void printSQLDate(String date){
        String month = date.substring(0,2);
        String day = date.substring(3,5);
        String year = date.substring(6);
        System.out.println(year+"-"+ month+"-"+day);
        
    }
    
}
