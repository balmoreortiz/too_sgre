package com.sgrs

class Ciclo {

    Integer id_ciclo        //e.g id_ciclo: 1
    String name             //e.g name: CICLO IV

    static hasMany = [materia: Materia]

    static constraints = {
        id_ciclo blank: false, unique:true
        name size:5..40, blank:false
    }

    String toString(){
        name
    }
}
