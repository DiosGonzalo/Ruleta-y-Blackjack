package controller;

import models.Casino;

public class ControllerCasino { // Hecho por Pablo García María

    private Casino casino;

    public ControllerCasino(Casino casino) {
        this.casino = casino;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

}
