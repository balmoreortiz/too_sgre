package com.sgrs

import grails.gorm.services.Service

@Service(Horario)
interface HorarioService {

    Horario get(Serializable id)

    List<Horario> list(Map args)

    Long count()

    void delete(Serializable id)

    Horario save(Horario horario)

}