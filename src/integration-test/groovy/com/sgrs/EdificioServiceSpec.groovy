package com.sgrs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EdificioServiceSpec extends Specification {

    EdificioService edificioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Edificio(...).save(flush: true, failOnError: true)
        //new Edificio(...).save(flush: true, failOnError: true)
        //Edificio edificio = new Edificio(...).save(flush: true, failOnError: true)
        //new Edificio(...).save(flush: true, failOnError: true)
        //new Edificio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //edificio.id
    }

    void "test get"() {
        setupData()

        expect:
        edificioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Edificio> edificioList = edificioService.list(max: 2, offset: 2)

        then:
        edificioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        edificioService.count() == 5
    }

    void "test delete"() {
        Long edificioId = setupData()

        expect:
        edificioService.count() == 5

        when:
        edificioService.delete(edificioId)
        sessionFactory.currentSession.flush()

        then:
        edificioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Edificio edificio = new Edificio()
        edificioService.save(edificio)

        then:
        edificio.id != null
    }
}
