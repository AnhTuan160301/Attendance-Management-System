/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pdm_project_final;

import java.sql.Connection;
import java.sql.DriverManager;


public class connectDB {
    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=PDM_Project_Final";
        String userName = "sa";
        String password = "123";
        return DriverManager.getConnection(connectionUrl, userName, password);
    } 
    
}
