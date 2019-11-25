class Turma{
    
    private _atividade: string;
    private _tipoAtividade: string;
    private _codigoTurma: string;
    private _periodoLetivo: string;

    constructor(atividade :string, tipoAtividade :string, codigoTurma :string, periodoLetivo :string){
        
        this._atividade = atividade;
        this._tipoAtividade = tipoAtividade;
        this._codigoTurma = codigoTurma;
        this._periodoLetivo = periodoLetivo;
    }

    get atividade (){
        return this._atividade;
    }

    get tipoAtividade(){
        return this._tipoAtividade;
    }

    get codigoTurma(){
        return this._codigoTurma;
    }

    get periodoLetivo(){
        return this._periodoLetivo;
    }
}