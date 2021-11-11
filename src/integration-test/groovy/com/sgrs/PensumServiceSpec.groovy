package com.sgrs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PensumServiceSpec extends Specification {

    PensumService pensumService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pensum(...).save(flush: true, failOnError: true)
        //new Pensum(...).save(flush: true, failOnError: true)
        //Pensum pensum = new Pensum(...).save(flush: true, failOnError: true)
        //new Pensum(...).save(flush: true, failOnError: true)
        //new Pensum(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pensum.id
    }

    void "test get"() {
        setupData()

        expect:
        pensumService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pensum> pensumList = pensumService.list(max: 2, offset: 2)

        then:
        pensumList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pensumService.count() == 5
    }

    void "test delete"() {
        Long pensumId = setupData()

        expect:
        pensumService.count() == 5

        when:
        pensumService.delete(pensumId)
        sessionFactory.currentSession.flush()

        then:
        pensumService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pensum pensum = new Pensum()
        pensumService.save(pensum)

        then:
        pensum.id != null
    }
}
