package com.sgrs

import grails.gorm.services.Service

@Service(Edificio)
interface EdificioService {

    Edificio get(Serializable id)

    List<Edificio> list(Map args)

    Long count()

    void delete(Serializable id)

    Edificio save(Edificio edificio)

}