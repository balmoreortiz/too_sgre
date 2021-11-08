package com.sgrs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EdificioController {

    EdificioService edificioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond edificioService.list(params), model:[edificioCount: edificioService.count()]
    }

    def show(Long id) {
        respond edificioService.get(id)
    }

    def create() {
        respond new Edificio(params)
    }

    def save(Edificio edificio) {
        if (edificio == null) {
            notFound()
            return
        }

        try {
            edificioService.save(edificio)
        } catch (ValidationException e) {
            respond edificio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'edificio.label', default: 'Edificio'), edificio.id])
                redirect edificio
            }
            '*' { respond edificio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond edificioService.get(id)
    }

    def update(Edificio edificio) {
        if (edificio == null) {
            notFound()
            return
        }

        try {
            edificioService.save(edificio)
        } catch (ValidationException e) {
            respond edificio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'edificio.label', default: 'Edificio'), edificio.id])
                redirect edificio
            }
            '*'{ respond edificio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        edificioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'edificio.label', default: 'Edificio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'edificio.label', default: 'Edificio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
