/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suicidaesquadrao.estacionamento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class  ConexaoBD {
    
    public static Connection getConnection ()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/poo?useTimezone=true&serverTimezone=UTC",
                "root","adminadmin");
    }

}    
   