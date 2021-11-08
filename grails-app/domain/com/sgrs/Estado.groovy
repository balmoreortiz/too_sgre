package com.sgrs

class Estado {

    String name

    static hasMany = [reserva: Reserva]

    static constraints = {
        name size:5..15, blank:false
    }

    String toString(){
        name
    }
}
