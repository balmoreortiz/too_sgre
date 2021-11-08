package com.sgrs

class Edificio {

    String name

    static constraints = {
        name size: 3..10, blank:false
    }

    String toString(){
        name
    }
}
