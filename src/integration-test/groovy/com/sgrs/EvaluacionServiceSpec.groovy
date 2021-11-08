package com.sgrs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EvaluacionServiceSpec extends Specification {

    EvaluacionService evaluacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Evaluacion(...).save(flush: true, failOnError: true)
        //new Evaluacion(...).save(flush: true, failOnError: true)
        //Evaluacion evaluacion = new Evaluacion(...).save(flush: true, failOnError: true)
        //new Evaluacion(...).save(flush: true, failOnError: true)
        //new Evaluacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //evaluacion.id
    }

    void "test get"() {
        setupData()

        expect:
        evaluacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Evaluacion> evaluacionList = evaluacionService.list(max: 2, offset: 2)

        then:
        evaluacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        evaluacionService.count() == 5
    }

    void "test delete"() {
        Long evaluacionId = setupData()

        expect:
        evaluacionService.count() == 5

        when:
        evaluacionService.delete(evaluacionId)
        sessionFactory.currentSession.flush()

        then:
        evaluacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Evaluacion evaluacion = new Evaluacion()
        evaluacionService.save(evaluacion)

        then:
        evaluacion.id != null
    }
}
