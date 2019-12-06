package br.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */

 /**
 * Chama página inicial
 * */


@Controller
public class HomeController
{
 /**
 * Chama página inicial
 * */
 @RequestMapping("home")
 public String index()
 {
 return "home/index";
 }
    
}
