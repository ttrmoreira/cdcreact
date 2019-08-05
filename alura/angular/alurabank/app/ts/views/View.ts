abstract class View<T> {
    
    
    protected _elemento: JQuery;

    constructor(seletor: string) {
        //Uso de JQuery com declaração .tsd para escopo global
        this._elemento = $(seletor);
    }

    update(model: T) {

        this._elemento.html(this.template(model));
    }

    abstract template(model: T): string;

}