package com.sgrs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MateriaController {

    MateriaService materiaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond materiaService.list(params), model:[materiaCount: materiaService.count()]
    }

    def show(Long id) {
        respond materiaService.get(id)
    }

    def create() {
        respond new Materia(params)
    }

    def save(Materia materia) {
        if (materia == null) {
            notFound()
            return
        }

        try {
            materiaService.save(materia)
        } catch (ValidationException e) {
            respond materia.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'materia.label', default: 'Materia'), materia.id])
                redirect materia
            }
            '*' { respond materia, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond materiaService.get(id)
    }

    def update(Materia materia) {
        if (materia == null) {
            notFound()
            return
        }

        try {
            materiaService.save(materia)
        } catch (ValidationException e) {
            respond materia.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'materia.label', default: 'Materia'), materia.id])
                redirect materia
            }
            '*'{ respond materia, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        materiaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'materia.label', default: 'Materia'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'materia.label', default: 'Materia'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
