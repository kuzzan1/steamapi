require('normalize.css');
require('./Sidebar.less');

import React from 'react';
import UserModule from 'components/UserModule/UserModule';

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