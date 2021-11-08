package com.sgrs

class Reserva {

    String name
    String fecha

    static belongsTo = [locales: Local, materias: Materia, evaluaciones: Evaluacion, horarios: Horario, estados: Estado]

    static constraints = {
        name size: 5..40, blank:false
        fecha size: 5..10, blank:false
    }

    String toString(){
        name
    }
}
