package com.sgrs

class Evaluacion {

    String name
    String id_eva

    static hasMany = [reserva: Reserva]

    static constraints = {
        id_eva blank:false, unique:true
        name size: 5..20, blank: false
    }

    String toString(){
        name
    }
}
