package com.sgrs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HorarioController {

    HorarioService horarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond horarioService.list(params), model:[horarioCount: horarioService.count()]
    }

    def show(Long id) {
        respond horarioService.get(id)
    }

    def create() {
        respond new Horario(params)
    }

    def save(Horario horario) {
        if (horario == null) {
            notFound()
            return
        }

        try {
            horarioService.save(horario)
        } catch (ValidationException e) {
            respond horario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'horario.label', default: 'Horario'), horario.id])
                redirect horario
            }
            '*' { respond horario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond horarioService.get(id)
    }

    def update(Horario horario) {
        if (horario == null) {
            notFound()
            return
        }

        try {
            horarioService.save(horario)
        } catch (ValidationException e) {
            respond horario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'horario.label', default: 'Horario'), horario.id])
                redirect horario
            }
            '*'{ respond horario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        horarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'horario.label', default: 'Horario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'horario.label', default: 'Horario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
