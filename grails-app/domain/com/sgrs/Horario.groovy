package com.sgrs

class Horario {

    String name
    String horario

    static hasMany = [reserva: Reserva]

    static constraints = {
        name siez: 5..40, blank:false
        horario size: 5..30, blank:false
    }

    String toString(){
        name
    }
}
