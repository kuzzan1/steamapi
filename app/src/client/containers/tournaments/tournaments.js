import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import { Link } from 'react-router'

class Tournaments extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
          tournaments: [],
          disciplineId: props.disciplineId,
          disciplineName: props.disciplineName,
          displayInline: props.displayInline
        }
    }

    componentWillMount() {
        this.update()
    }

    componentWillReceiveProps(nextProps) {
       this.state = {disciplineId: nextProps.disciplineId, tournaments: [], disciplineName: nextProps.disciplineName}
       this.update();
    }

    renderInline() {
      var tournaments = this.state.tournaments.map(tournament => {

          return (
              <div key={tournament.tournamentId}>
                <Link to={`/tournament/${tournament.tournamentId}`} ><span>{tournament.fullName}</span></Link>
                <span> to be held in </span>
                <span>{tournament.location}</span>
              </div>
          )
      })
      return (
        <div>
          <h1>All Tournaments</h1>
          <div className="tournaments" >
              {tournaments}
          </div>
        </div>
      )

    }

    renderStandalone() {
      var tournaments = this.state.tournaments.map(tournament => {

          return (
              <div key={tournament.tournamentId}>
                <span> The {tournament.discipline} tournament </span>
                <Link to={`/tournament/${tournament.tournamentId}`} ><span>{tournament.fullName}</span></Link>
                <span> to be held in </span>
                <span>{tournament.location}</span>
                <div>
                  <span>{tournament.description}</span>
                </div>
                <div>
                  <h3>Prices</h3>
                  <span>{tournament.prize}</span>
                </div>
                <div>
                  <a href={tournament.website} target='_blank'>Tournament Website</a>
                </div>
              </div>
          )
      })
      return (
        <div>
          <h2>{this.state.disciplineName} Tournaments</h2>
          <div className="discipline__tournaments" >
              {tournaments}
          </div>
        </div>
      )
    }


    render() {
      if (this.props.displayInline) {
        return this.renderInline();
      } else {
        return this.renderStandalone();
      }
    }

    update() {
      if (this.props.displayInline) {
        model.get(['tournamentsByDiscipline', this.state.disciplineId, ['fullName','location','online']]).then( response => {
          this.setState({tournaments: response.json.tournamentsByDiscipline[this.state.disciplineId]});
        });
      } else {
        model.get(['tournaments']).then( response => {
          this.setState({tournaments: response.json.tournaments});
        });

      }

    }
}

Tournaments.propTypes = {disciplineId: React.PropTypes.string, displayInline: React.PropTypes.bool};
Tournaments.defaultProps = {disciplineId: "", displayInline: false};


module.exports = Tournaments
