///* global $ */
require('./CsGoServerSummary.less');

import React from 'react';

class CsGoServerSummary extends React.Component {
    constructor(props) {
        super(props);
        this.state = { 
            scheduler: '',
            onlineServers: '',
            onlinePlayers: '',
            searchingPlayers: '',
            avgSearchTime: ''
         };
    }
    
    loadCsGoSummary() {
        $.ajax({
            url: this.props.url,
            dataType: 'json',
            success: function(data) {
                this.setState({ 
                    scheduler: data.result.matchmaking.scheduler,
                    onlineServers: data.result.matchmaking.online_servers,
                    onlinePlayers: data.result.matchmaking.online_players,
                    searchingPlayers: data.result.matchmaking.searching_players,
                    avgSearchTime: data.result.matchmaking.search_seconds_avg
                });
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(data, status, err.toString());
            }.bind(this)
        });
    }
    
    componentDidMount() {
        this.loadCsGoSummary();
    }
    
    render(){


        return (
            <div className={'cs-go-server-summary component ' + this.props.size}>
                <div className="item">
                    <span className="label">Status:</span>
                    <span className="value status">{this.state.scheduler}</span>
                </div>
                <div className="item">
                    <span className="label">Online servers:</span>
                    <span className="value">{this.state.onlineServers}</span>
                </div>
                <div className="item">
                    <span className="label">Online players:</span>
                    <span className="value">{this.state.onlinePlayers}</span>
                </div>
                <div className="item">
                    <span className="label">Searching players:</span>
                    <span className="value">{this.state.searchingPlayers}</span>
                </div>
                <div className="item">
                    <span className="label">Average search time:</span>
                    <span className="value">{this.state.avgSearchTime + ' seconds'}</span>
                </div>
            </div>
        );
    }
}

CsGoServerSummary.propTypes = {

};

CsGoServerSummary.defaultProps = {

};

export default CsGoServerSummary;