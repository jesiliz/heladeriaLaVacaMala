
package com.eggGrupo3.heladeriaLaVacaMala.servicios;

import org.springframework.stereotype.Service;


public class ErrorService extends Exception{
    
    public ErrorService(String msn){
        super(msn);
    }
}
