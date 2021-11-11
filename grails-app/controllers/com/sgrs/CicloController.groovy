package com.sgrs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CicloController {

    CicloService cicloService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cicloService.list(params), model:[cicloCount: cicloService.count()]
    }

    def show(Long id) {
        respond cicloService.get(id)
    }

    def create() {
        respond new Ciclo(params)
    }

    def save(Ciclo ciclo) {
        if (ciclo == null) {
            notFound()
            return
        }

        try {
            cicloService.save(ciclo)
        } catch (ValidationException e) {
            respond ciclo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ciclo.label', default: 'Ciclo'), ciclo.id])
                redirect ciclo
            }
            '*' { respond ciclo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond cicloService.get(id)
    }

    def update(Ciclo ciclo) {
        if (ciclo == null) {
            notFound()
            return
        }

        try {
            cicloService.save(ciclo)
        } catch (ValidationException e) {
            respond ciclo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ciclo.label', default: 'Ciclo'), ciclo.id])
                redirect ciclo
            }
            '*'{ respond ciclo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        cicloService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ciclo.label', default: 'Ciclo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ciclo.label', default: 'Ciclo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
