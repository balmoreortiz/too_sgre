package com.sgrs

class Local {

    String name

    static hasMany = [reserva: Reserva]

    static constraints = {
        name size: 3..6, blank: false, unique:true
    }

    String toString(){
        name
    }
}
