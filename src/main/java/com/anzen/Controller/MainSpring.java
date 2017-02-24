package com.anzen.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 
 * 
 *  Descripcion: Esta clase funciona como Principal para la ejecucion de Spring boot.
 *
 */

@SpringBootApplication
public class MainSpring {

	/**
	 * Metodo Main
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(MainSpring.class, args);
    }
}