package com.sgrs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MateriaServiceSpec extends Specification {

    MateriaService materiaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Materia(...).save(flush: true, failOnError: true)
        //new Materia(...).save(flush: true, failOnError: true)
        //Materia materia = new Materia(...).save(flush: true, failOnError: true)
        //new Materia(...).save(flush: true, failOnError: true)
        //new Materia(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //materia.id
    }

    void "test get"() {
        setupData()

        expect:
        materiaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Materia> materiaList = materiaService.list(max: 2, offset: 2)

        then:
        materiaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        materiaService.count() == 5
    }

    void "test delete"() {
        Long materiaId = setupData()

        expect:
        materiaService.count() == 5

        when:
        materiaService.delete(materiaId)
        sessionFactory.currentSession.flush()

        then:
        materiaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Materia materia = new Materia()
        materiaService.save(materia)

        then:
        materia.id != null
    }
}
