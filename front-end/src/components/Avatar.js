import React from 'react'
import { Buffer } from 'buffer';
import Identicon from 'react-identicons';

const genAvatar = (string, size, style) => {
    if (string) {
        const buffer = Buffer.from(string, 'utf8').toString('hex');
        return (
            <div style={style}>
                <Identicon string={buffer} size={size} />
            </div>
        )
    }
    else return(
        <div style={style}>
            <i className="fa fa-user-circle-o" aria-hidden="true" style={{ fontSize: size }}></i>
        </div>
    )
}

export default genAvatar;
