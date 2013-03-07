package fr.isima.estouroDePilha

import org.springframework.dao.DataIntegrityViolationException

class VoteUpController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [voteUpInstanceList: VoteUp.list(params), voteUpInstanceTotal: VoteUp.count()]
    }

    def create() {
        [voteUpInstance: new VoteUp(params)]
    }

    def save() {
        def voteUpInstance = new VoteUp(params)
        if (!voteUpInstance.save(flush: true)) {
            render(view: "create", model: [voteUpInstance: voteUpInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), voteUpInstance.id])
        redirect(action: "show", id: voteUpInstance.id)
    }

    def show(Long id) {
        def voteUpInstance = VoteUp.get(id)
        if (!voteUpInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), id])
            redirect(action: "list")
            return
        }

        [voteUpInstance: voteUpInstance]
    }

    def edit(Long id) {
        def voteUpInstance = VoteUp.get(id)
        if (!voteUpInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), id])
            redirect(action: "list")
            return
        }

        [voteUpInstance: voteUpInstance]
    }

    def update(Long id, Long version) {
        def voteUpInstance = VoteUp.get(id)
        if (!voteUpInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (voteUpInstance.version > version) {
                voteUpInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'voteUp.label', default: 'VoteUp')] as Object[],
                          "Another user has updated this VoteUp while you were editing")
                render(view: "edit", model: [voteUpInstance: voteUpInstance])
                return
            }
        }

        voteUpInstance.properties = params

        if (!voteUpInstance.save(flush: true)) {
            render(view: "edit", model: [voteUpInstance: voteUpInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), voteUpInstance.id])
        redirect(action: "show", id: voteUpInstance.id)
    }

    def delete(Long id) {
        def voteUpInstance = VoteUp.get(id)
        if (!voteUpInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), id])
            redirect(action: "list")
            return
        }

        try {
            voteUpInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'voteUp.label', default: 'VoteUp'), id])
            redirect(action: "show", id: id)
        }
    }
}
