
import React, {Component} from 'react';

export default class SelectCustomizado extends Component{

    constructor(props){
        super(props);
    }


    handleChange = (event) =>
    {
        let selectedValue = event.target.value;
        this.props.onChange(selectedValue);
    }

    render(){
        let arrayOfData = this.props.arrayOfData;
        let options = arrayOfData.map((data) =>
                <option 
                    key={data.id}
                    value={data.id}
                >
                    {data.name}
                </option>
            );
        
            return (
            <select value={this.props.id} name={this.props.name} className="pure-controls" onChange={this.handleChange}>
                <option>{this.props.label}</option>
                {options}
           </select>
        )
    }
}