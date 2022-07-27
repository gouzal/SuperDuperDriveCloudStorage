/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udacity.jwdnd.course1.cloudstorage.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Larbi
 */
public class ErrorController  implements org.springframework.boot.web.servlet.error.ErrorController{

@RequestMapping("/error")
public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    
    if (status != null) {
        Integer statusCode = Integer.valueOf(status.toString());
    
        if(statusCode == HttpStatus.NOT_FOUND.value()) {
            return "error404";
        }
//        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//            return "error-500";
//        }
    }
    return "error";
}
    @Override
    public String getErrorPath() {
         return "error";
    }
    
}
