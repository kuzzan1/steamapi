import React from 'react';
import Falcor from 'falcor';
import model from '../../model';
import Team from '../../containers/team/team';
import moment from 'moment';

require('./match-card.scss');

class MatchCard extends React.Component {
    constructor(props) {
        super(props)
        this.state = props.match;
    }
    componentWillMount() {
        this.update()
    }

    completedMatch() {
      let opponentOne = this.state.opponents[0],
          opponentTwo = this.state.opponents[1];

      const gameTime = moment(this.state.date).format('dddd, MMMM Do YYYY, h:mm:ss a');

      return (
        <div className="match-card completed">
          <div className="card-content">
            <span className="card-title">{this.state.name}</span>
            <span className="time">{gameTime}</span>
            <div className="stage-round">
              <span>Stage {this.state.stageNumber}</span>
              <span>Round {this.state.roundNumber}</span>
            </div>

            <div className="scoreboard">
              <div>
                <span>{opponentOne.participant.name}:</span>
                <span>{opponentOne.score}</span>
              </div>
              <div>
                <span>{opponentTwo.participant.name}:</span>
                <span>{opponentTwo.score}</span>
              </div>
            </div>
          </div>
        </div>
      )
    }

    upcomingMatch() {
      return (
        <div className="match-card upcoming">
          <div className="card-content">
            <span className="card-title">{this.state.name}</span>
            <span className="time">{gameTime}</span>
            <div className="stage-round">
              <span>Stage {this.state.stageNumber}</span>
              <span>Round {this.state.roundNumber}</span>
            </div>

            <div className="scoreboard">
              <div>
                <span>{opponentOne.participant.name}:</span>
              </div>
              <div>
                <span>{opponentTwo.participant.name}:</span>
              </div>
            </div>
          </div>
          <div className="card-action">
            <a href="#">Stream</a>
            <a href="#">Stream</a>
          </div>
        </div>

      )
    }

    render() {

      const teams = this.state.opponents ? this.state.opponents.map(opponent => {
          return (
              <div key={opponent.participant.id}>
                    <Team participant={opponent.participant} />
              </div>
          )
      }) : [];

      if (this.state.status === 'completed') {
        return this.completedMatch();
      } else {
        return this.upcomingMatch();
      }


    }

    update() {
    }
}

module.exports = MatchCard
