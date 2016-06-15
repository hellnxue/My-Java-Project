package com.anbo.util;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class Log4jInit extends HttpServlet {

public void init() {

        String prefix = getServletContext().getRealPath("/");

        String file = getInitParameter("log4j");

        System.out.println("................log4j start");

        if (file != null) {

               PropertyConfigurator.configure(prefix + file);

        }

}

public void doGet(HttpServletRequest req, HttpServletResponse res) {

}

}


