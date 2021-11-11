package com.sgrs

class Horario {

    String name
    String horario
    Integer id_horario

    static hasMany = [reserva: Reserva]

    static constraints = {
        id_horario blank:false, unique:true
        name siez: 5..40, blank:false
        horario size: 5..30, blank:false
    }

    String toString(){
        name
    }
}
