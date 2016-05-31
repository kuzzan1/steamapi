import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import moment from 'moment';

require('./next-tournaments-card.scss');

class NextTournamentsCard extends React.Component {
    constructor(props) {
      super(props)
      this.state = {
        tournaments: []
      }
    }

    componentWillMount() {
        this.update()
    }

    render() {
      var tournaments = this.state.tournaments.map(tournament => {
        let startTime = moment(tournament.dateStart);
        let endTime = moment(tournament.dateEnd);
          return (
            <div key={tournament.tournamentId}>
              <span>
                There's an {tournament.discipline} tournament, {tournament.name}, beginning {startTime.fromNow()} and ending {endTime.from(startTime, true)} later. It has {tournament.streams.length} streams available.
              </span>
            </div>
          )
      })
      return (
          <div className="next-tournaments-card">
            <div className="card-content">
              <h2 className="card-title"> Next 5 Tournaments </h2>
              {tournaments}
            </div>

          </div>
      )

    }

    update() {
      model.get(['nextXTournaments', 5]).then( response => {
        console.log(response);
          this.setState({tournaments: response.json.nextXTournaments})
      });
    }
}

NextTournamentsCard.propTypes = {matches: React.PropTypes.array};
NextTournamentsCard.defaultProps = {matches: []};

module.exports = NextTournamentsCard
