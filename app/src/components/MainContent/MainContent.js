///* global $ */
require('./MainContent.less');

import React from 'react';
import CsGoServerSummary from '../CsGoServerSummary/CsGoServerSummary';

class MainContent extends React.Component {
	render(){
        return (
            <div id="main">
                <div className="row">
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="large" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="large" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="large" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="medium" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="large" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="large" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="large" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="large" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                    <CsGoServerSummary size="small" url="http://localhost/app/cs/game/servers" />
                </div>
            </div>
        );
    }
}

MainContent.propTypes = {

};

MainContent.defaultProps = {
    
};

export default MainContent;