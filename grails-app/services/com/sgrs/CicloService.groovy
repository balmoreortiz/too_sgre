package com.sgrs

import grails.gorm.services.Service

@Service(Ciclo)
interface CicloService {

    Ciclo get(Serializable id)

    List<Ciclo> list(Map args)

    Long count()

    void delete(Serializable id)

    Ciclo save(Ciclo ciclo)

}