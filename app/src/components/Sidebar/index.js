require('./sidebar.less');

import React from 'react';
import UserModule from '../user-module/index';

class SidebarComponent extends React.Component {
	render(){
        return (
            <aside id="sidebar">
                <UserModule></UserModule>
            </aside>
        );
    }
}

SidebarComponent.propTypes = {

};

SidebarComponent.defaultProps = {

};

export default SidebarComponent;