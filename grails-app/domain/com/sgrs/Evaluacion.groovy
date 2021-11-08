package com.sgrs

class Evaluacion {

    String name

    static hasMany = [reserva: Reserva]

    static constraints = {
        name size: 5..20, blank: false
    }

    String toString(){
        name
    }
}
