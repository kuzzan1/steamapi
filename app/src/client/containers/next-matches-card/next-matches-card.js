import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import moment from 'moment';

require('./next-matches-card.scss');

class NextMatchesCard extends React.Component {
    constructor(props) {
      super(props)
      this.state = {
        matches: []
      }
    }

    componentWillMount() {
        this.update()
    }

    render() {
      var matches = this.state.matches.map(match => {
        let startTime = moment(match.date);
          return (
            <div key={match.id}>
              <span>There's an {match.discipline} match, {match.name}, beginning {startTime.fromNow()}</span>
            </div>
          )
      })
      return (
          <div className="next-matches-card">
            <div className="card-content">
              <h2 className="card-title"> Next 5 Matches </h2>
              {matches}
            </div>

          </div>
      )

    }

    update() {
      model.get(['nextXMatches', 5]).then( response => {
        console.log(response);
          this.setState({matches: response.json.nextXMatches})
      });
    }
}

NextMatchesCard.propTypes = {matches: React.PropTypes.array};
NextMatchesCard.defaultProps = {matches: []};

module.exports = NextMatchesCard
