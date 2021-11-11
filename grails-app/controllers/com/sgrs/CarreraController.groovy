package com.sgrs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CarreraController {

    CarreraService carreraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond carreraService.list(params), model:[carreraCount: carreraService.count()]
    }

    def show(Long id) {
        respond carreraService.get(id)
    }

    def create() {
        respond new Carrera(params)
    }

    def save(Carrera carrera) {
        if (carrera == null) {
            notFound()
            return
        }

        try {
            carreraService.save(carrera)
        } catch (ValidationException e) {
            respond carrera.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'carrera.label', default: 'Carrera'), carrera.id])
                redirect carrera
            }
            '*' { respond carrera, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond carreraService.get(id)
    }

    def update(Carrera carrera) {
        if (carrera == null) {
            notFound()
            return
        }

        try {
            carreraService.save(carrera)
        } catch (ValidationException e) {
            respond carrera.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'carrera.label', default: 'Carrera'), carrera.id])
                redirect carrera
            }
            '*'{ respond carrera, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        carreraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'carrera.label', default: 'Carrera'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carrera.label', default: 'Carrera'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
