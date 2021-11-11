package com.sgrs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CarreraServiceSpec extends Specification {

    CarreraService carreraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Carrera(...).save(flush: true, failOnError: true)
        //new Carrera(...).save(flush: true, failOnError: true)
        //Carrera carrera = new Carrera(...).save(flush: true, failOnError: true)
        //new Carrera(...).save(flush: true, failOnError: true)
        //new Carrera(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //carrera.id
    }

    void "test get"() {
        setupData()

        expect:
        carreraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Carrera> carreraList = carreraService.list(max: 2, offset: 2)

        then:
        carreraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        carreraService.count() == 5
    }

    void "test delete"() {
        Long carreraId = setupData()

        expect:
        carreraService.count() == 5

        when:
        carreraService.delete(carreraId)
        sessionFactory.currentSession.flush()

        then:
        carreraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Carrera carrera = new Carrera()
        carreraService.save(carrera)

        then:
        carrera.id != null
    }
}
