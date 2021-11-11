package com.sgrs

class Reserva {

    String name         //e.g name: "primer examen parcial Fisico-Química I"
    String fecha        //e.g fecha: "13-nov-2021"

    static belongsTo = [
        /*todo esto es accedido por medio de sus campos identificadores + toString()*/
        locales: Local,             //eg. local: B22
        materias: Materia,          //eg. materia: TOO115
        evaluaciones: Evaluacion,   //e.g evaluación: Examen Parcial
        horarios: Horario,          //e.g horario: "6:20-8:15"
        estados: Estado]            //e.g estado: pendiente

    static constraints = {
        name size: 5..100, blank:false
        fecha size: 5..11, blank:false
    }

    String toString(){
        name
    }
}
