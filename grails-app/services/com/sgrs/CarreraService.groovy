package com.sgrs

import grails.gorm.services.Service

@Service(Carrera)
interface CarreraService {

    Carrera get(Serializable id)

    List<Carrera> list(Map args)

    Long count()

    void delete(Serializable id)

    Carrera save(Carrera carrera)

}