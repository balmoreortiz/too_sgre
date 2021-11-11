package com.sgrs

class Materia {

    String codigo
    String name

    static hasMany = [reserva: Reserva]
    static belongsTo = [carrera: Carrera, ciclo: Ciclo]

    static constraints = {
        codigo size: 6..8, blank: false, unique: true
        name size: 5..40, blank: false
    }

    String toString(){
        name
    }
}
