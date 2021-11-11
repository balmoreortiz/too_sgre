package com.sgrs

class Pensum {

    Integer id_pensum   //e.g id_pensum: 1
    String name         //e.g name: [Pensum Ingeniería Química, Pensum Ingeniería en Sistemas Informáticos]

    static hasMany = [
        carrera: Carrera,   //e.g id_carrera: [1,2,3 ..]
        ciclo: Ciclo,   //e.g id_ciclo: [1,2,3..10]
        materia: Materia    //e.g cod_materia: [MAT115, MTE115, IAI115, PSI15]
    ]

    static constraints = {
        id_pensum blank:false, unique:true
        name blank: false
    }
}
