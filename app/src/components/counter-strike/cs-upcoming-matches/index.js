/* global $ */
import React from 'react';

class CsGoUpcomingMatches extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            matches: []
        };
    }

    loadCsGoSummary() {
        $.ajax({
            url: this.props.url,
            dataType: 'json',
            success: function(data) {
                this.setState({
                    matches: data.channel.items
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
            <div className={'cs-go-upcoming-matches component ' + this.props.size}>
                <h2>Upcoming Matches</h2>
            </div>
        );
    }
}

export default CsGoUpcomingMatches;