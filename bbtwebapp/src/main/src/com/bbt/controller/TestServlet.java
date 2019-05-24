package com.bbt.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author TheFlash
 * @Date 2019/5/23
 * @TIME 13:11
 */
@WebServlet(name = "TestServlet",urlPatterns = "/hello")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.getWriter().println("luanmale");
        response.getWriter().println("woshidashuaige");


    }
}



