class Turma {
    constructor(atividade, tipoAtividade, codigoTurma, periodoLetivo) {
        this._atividade = atividade;
        this._tipoAtividade = tipoAtividade;
        this._codigoTurma = codigoTurma;
        this._periodoLetivo = periodoLetivo;
    }
    get atividade() {
        return this._atividade;
    }
    get tipoAtividade() {
        return this._tipoAtividade;
    }
    get codigoTurma() {
        return this._codigoTurma;
    }
    get periodoLetivo() {
        return this._periodoLetivo;
    }
}
