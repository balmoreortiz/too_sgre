package com.sgrs

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PensumController {

    PensumService pensumService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pensumService.list(params), model:[pensumCount: pensumService.count()]
    }

    def show(Long id) {
        respond pensumService.get(id)
    }

    def create() {
        respond new Pensum(params)
    }

    def save(Pensum pensum) {
        if (pensum == null) {
            notFound()
            return
        }

        try {
            pensumService.save(pensum)
        } catch (ValidationException e) {
            respond pensum.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pensum.label', default: 'Pensum'), pensum.id])
                redirect pensum
            }
            '*' { respond pensum, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond pensumService.get(id)
    }

    def update(Pensum pensum) {
        if (pensum == null) {
            notFound()
            return
        }

        try {
            pensumService.save(pensum)
        } catch (ValidationException e) {
            respond pensum.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pensum.label', default: 'Pensum'), pensum.id])
                redirect pensum
            }
            '*'{ respond pensum, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        pensumService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pensum.label', default: 'Pensum'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pensum.label', default: 'Pensum'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
