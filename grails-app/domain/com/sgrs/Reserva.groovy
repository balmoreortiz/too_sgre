package com.sgrs

class Reserva {

    String name         //e.g name: "primer examen parcial Fisico-Química I"
    String fecha        //e.g fecha: "13-nov-2021"

    static belongsTo = [locales: Local, materias: Materia, evaluaciones: Evaluacion, horarios: Horario, estados: Estado]

    static constraints = {
        name size: 5..100, blank:false
        fecha size: 5..11, blank:false
    }

    String toString(){
        name
    }
}
