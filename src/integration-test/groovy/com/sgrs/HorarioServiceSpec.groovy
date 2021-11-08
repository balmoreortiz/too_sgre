package com.sgrs

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HorarioServiceSpec extends Specification {

    HorarioService horarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Horario(...).save(flush: true, failOnError: true)
        //new Horario(...).save(flush: true, failOnError: true)
        //Horario horario = new Horario(...).save(flush: true, failOnError: true)
        //new Horario(...).save(flush: true, failOnError: true)
        //new Horario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //horario.id
    }

    void "test get"() {
        setupData()

        expect:
        horarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Horario> horarioList = horarioService.list(max: 2, offset: 2)

        then:
        horarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        horarioService.count() == 5
    }

    void "test delete"() {
        Long horarioId = setupData()

        expect:
        horarioService.count() == 5

        when:
        horarioService.delete(horarioId)
        sessionFactory.currentSession.flush()

        then:
        horarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Horario horario = new Horario()
        horarioService.save(horario)

        then:
        horario.id != null
    }
}
