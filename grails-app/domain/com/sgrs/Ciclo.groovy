package com.sgrs

class Ciclo {

    Integer id_ciclo
    String name

    static hasMany = [materia: Materia]

    static constraints = {
        id_ciclo blank: false, unique:true
        name size:5..40, blank:false
    }

    String toString(){
        name
    }
}
