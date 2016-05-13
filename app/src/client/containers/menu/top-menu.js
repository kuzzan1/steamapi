import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import { Link } from 'react-router'

class TopMenu extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          disciplines: {}
        }
    }
    componentWillMount() {
        this.update()
    }

    render() {
        var disciplines = Object.keys(this.state.disciplines).map(idx => {
            return (
                <Link key={idx} to={`/discipline/${this.state.disciplines[idx].id}`} ><h1>{this.state.disciplines[idx].name}</h1></Link>
            )
        })

        return (
          <div>            
            <div className="discipline__tournaments" >
                {disciplines}
            </div>
          </div>
        )
    }

    update() {
        model.get(['disciplines']).then( response => this.setState({disciplines: response.json.disciplines}));
    }
}

module.exports = TopMenu
