import React, {Component} from 'react';
import PubSub from 'pubsub-js';

export default class InputCustomizado extends Component{

    constructor(){
        super();
        this.state = {msgErro:''};
    }

    render(){
        return (

            <div className="pure-control-group">
                <label htmlFor={this.props.id}>{this.props.label}</label> 
                <input {...this.props} />  
                 <span className="erro">{this.state.msgErro}</span>                
            </div>

        );
    }

    componentDidMount(){
        PubSub.subscribe("erro-validacao", function (topico, objeto){
            if(objeto.field === this.props.name){
                this.setState({msgErro: objeto.defaultMessage});
            }
        }.bind(this));

        PubSub.subscribe("limpa-erros", function(topico){
            this.setState({msgErro:''});
        }.bind(this))
    }
}