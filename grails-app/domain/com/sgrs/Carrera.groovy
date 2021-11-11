package com.sgrs

class Carrera {

    String name

    static hasMany = [materia: Materia]

    static constraints = {
        name size:5..40, blank:false, unique:true
    }

    String toString(){
        name
    }
}
