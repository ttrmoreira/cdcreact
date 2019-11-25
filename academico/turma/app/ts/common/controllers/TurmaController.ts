class TurmaController {

    private _inputAtividade
    private _inputTipoAtividade
    private _inputCodigoTurma
    private _inputPeriodoLetivo


    constructor (){
        this._inputAtividade = document.querySelector('#atividade');
        this._inputTipoAtividade = document.querySelector('#tipoAtividade');
        this._inputCodigoTurma = document.querySelector('#codigoTurma');
        this._inputPeriodoLetivo = document.querySelector('#peridoLetivo');
    }

    adiciona(event) {

        event.preventDefault();

        const turma = new Turma(
            this._inputAtividade.value,
            this._inputTipoAtividade.value,
            this._inputCodigoTurma.value,
            this._inputPeriodoLetivo.value);
            
        console.log(turma);
    }

}