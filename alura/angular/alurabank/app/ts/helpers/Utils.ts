import {Negociacao} from '../models/Negociacao';
import {Imprimivel} from '../models/Imprimivel';

export function imprime(...objetos:Imprimivel[]){
    objetos.forEach(imprimivel => imprimivel.paraTexto());
}