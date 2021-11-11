package com.sgrs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CicloServiceSpec extends Specification {

    CicloService cicloService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ciclo(...).save(flush: true, failOnError: true)
        //new Ciclo(...).save(flush: true, failOnError: true)
        //Ciclo ciclo = new Ciclo(...).save(flush: true, failOnError: true)
        //new Ciclo(...).save(flush: true, failOnError: true)
        //new Ciclo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ciclo.id
    }

    void "test get"() {
        setupData()

        expect:
        cicloService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ciclo> cicloList = cicloService.list(max: 2, offset: 2)

        then:
        cicloList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cicloService.count() == 5
    }

    void "test delete"() {
        Long cicloId = setupData()

        expect:
        cicloService.count() == 5

        when:
        cicloService.delete(cicloId)
        sessionFactory.currentSession.flush()

        then:
        cicloService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ciclo ciclo = new Ciclo()
        cicloService.save(ciclo)

        then:
        ciclo.id != null
    }
}
