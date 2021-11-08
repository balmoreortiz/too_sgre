package com.sgrs

import grails.gorm.services.Service

@Service(Materia)
interface MateriaService {

    Materia get(Serializable id)

    List<Materia> list(Map args)

    Long count()

    void delete(Serializable id)

    Materia save(Materia materia)

}