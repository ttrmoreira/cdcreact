import React, { Component } from "react";
import Pubsub from 'pubsub-js';


class FotoHeader extends Component{
    render(){
        return(
            <header className="foto-header">
            <figure className="foto-usuario">
              <img src="{this.props.foto.urlFoto}" alt="foto do usuario"/>
              <figcaption className="foto-usuario">
                <a href="#">
                  {this.props.foto.loginUsuario}
                </a>  
              </figcaption>
            </figure>
        <time className="foto-data">{this.props.foto.horario}</time>
          </header>

        );
    }
}

class FotoInfo extends Component{

    constructor(props){
        super(props);
        this.state = {likers:this.props.foto.likers};
    }


    componentWillMount(){
        Pubsub.subscribe('atualiza-liker',(topico,infoLiker) => {
            if(this.props.foto.id === infoLiker.fotoId){
                const possivelLiker = this.state.likers.find(liker => liker.login === infoLiker.liker.login);
                if(possivelLiker === undefined){
                    const novoLikers = this.state.likers.concat(infoLiker.liker);
                    this.setState({likers:novoLikers});
                }else{
                    const novoLikers = this.state.likers.filter(liker => liker.login !== infoLiker.liker.login);
                    this.setState({likers:novoLikers});
                }
            }
        })
    }

    render(){
        return(
            <div className="foto-info">
            <div className="foto-info-likes">
                {
                    this.state.likers.map(liker => {
                        return(<a key={liker.login} href="#">{liker.login},</a>)
                    })
                }

               curtiram
           
            </div>

            <p className="foto-info-legenda">
              <a className="foto-info-autor">autor </a>
                {
                    this.props.foto.comentario
                }
            </p>

            <ul className="foto-info-comentarios">
                {
                    this.props.foto.comentarios.map(comentario => {
                        return ( <li className="comentario" key={comentario.id}>
                                    <a className="foto-info-autor">{comentario.login} </a>
                                        {comentario.texto}
                                </li>
                        );
                    })
                }
            </ul>
          </div>
        );
    }
}

class FotoAtualizacoes extends Component{

    constructor(props){
        super(props);
        this.state = {likeada : this.props.foto.likeada};
    }

    like(event){
        event.preventDefault();
        fetch(`http://localhost:8080/api/fotos/${this.props.foto.id}/like?X-AUTH-TOKEN=${localStorage.getItem('auth-token')}`,{method: 'POST'})
            .then(response => {
                if(response.ok){
                    return response.json();
                }else{
                    throw new Error ("Não foi possível realizar o like da foto");
                }
            })
            .then(liker => {
                this.setState({likeada : !this.state.likeada});
                Pubsub.publish('atualiza-liker', {fotoId:this.props.foto.id, liker});
            });
    }

    render(){
        return(
            <section className="fotoAtualizacoes">
            <a onClick={this.like.bind(this)} className={this.state.likeada ? 'fotoAtualizacoes-like-ativo' : 'fotoAtualizacoes-like'}>Linkar</a>
            <form className="fotoAtualizacoes-form">
              <input type="text" placeholder="Adicione um comentário..." className="fotoAtualizacoes-form-campo"/>
              <input type="submit" value="Comentar!" className="fotoAtualizacoes-form-submit"/>
            </form>

          </section>
        );
    }
}

export default class FotoItem extends Component {
    render(){
        return (
            <div className="foto">
                <FotoHeader foto={this.props.foto}/>
                <img alt="foto" className="foto-src" src={this.props.foto.urlFoto}/>
                <FotoInfo foto={this.props.foto}/>
                <FotoAtualizacoes foto={this.props.foto}/>
            </div>   
        )
    }
}

