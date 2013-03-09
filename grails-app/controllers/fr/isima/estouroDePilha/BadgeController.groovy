package fr.isima.estouroDePilha

import org.springframework.dao.DataIntegrityViolationException

class BadgeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [badgeInstanceList: Badge.list(params).sort{it.users.size()}.reverse(), badgeInstanceTotal: Badge.count()]
    }

    def show(Long id) {
        def badgeInstance = Badge.get(id)
        if (!badgeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'badge.label', default: 'Badge'), id])
            redirect(action: "list")
            return
        }

        [badgeInstance: badgeInstance]
    }
}
