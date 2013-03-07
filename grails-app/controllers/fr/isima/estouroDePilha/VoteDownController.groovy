package fr.isima.estouroDePilha

import org.springframework.dao.DataIntegrityViolationException

class VoteDownController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [voteDownInstanceList: VoteDown.list(params), voteDownInstanceTotal: VoteDown.count()]
    }

    def create() {
        [voteDownInstance: new VoteDown(params)]
    }

    def save() {
        def voteDownInstance = new VoteDown(params)
        if (!voteDownInstance.save(flush: true)) {
            render(view: "create", model: [voteDownInstance: voteDownInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), voteDownInstance.id])
        redirect(action: "show", id: voteDownInstance.id)
    }

    def show(Long id) {
        def voteDownInstance = VoteDown.get(id)
        if (!voteDownInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), id])
            redirect(action: "list")
            return
        }

        [voteDownInstance: voteDownInstance]
    }

    def edit(Long id) {
        def voteDownInstance = VoteDown.get(id)
        if (!voteDownInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), id])
            redirect(action: "list")
            return
        }

        [voteDownInstance: voteDownInstance]
    }

    def update(Long id, Long version) {
        def voteDownInstance = VoteDown.get(id)
        if (!voteDownInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (voteDownInstance.version > version) {
                voteDownInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'voteDown.label', default: 'VoteDown')] as Object[],
                          "Another user has updated this VoteDown while you were editing")
                render(view: "edit", model: [voteDownInstance: voteDownInstance])
                return
            }
        }

        voteDownInstance.properties = params

        if (!voteDownInstance.save(flush: true)) {
            render(view: "edit", model: [voteDownInstance: voteDownInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), voteDownInstance.id])
        redirect(action: "show", id: voteDownInstance.id)
    }

    def delete(Long id) {
        def voteDownInstance = VoteDown.get(id)
        if (!voteDownInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), id])
            redirect(action: "list")
            return
        }

        try {
            voteDownInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'voteDown.label', default: 'VoteDown'), id])
            redirect(action: "show", id: id)
        }
    }
}
